package com.example.root.dez;

import com.example.root.dez.Model.SearchAnswer;
import com.example.root.dez.Model.Search;
import com.example.root.dez.Model.Track;
import com.example.root.dez.Model.TrackAnswer;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 10.12.16.
 */

public class DeezRequest {

    private Realm realm;
    private OnSavedListener listen;
    private int pageIndex = 0;
    private int id;


    public void setOnSavedListener(OnSavedListener listen) {
        this.listen = listen;
    }


    public void Request(String CALL_TYPE, int parameterInt) {
        Request(CALL_TYPE, parameterInt, null);
    }

    public void Request(String CALL_TYPE, final int parameterInt, String search) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API service = retrofit.create(API.class);

        switch (CALL_TYPE) {

            case Constants.SEARCH_CALL:

                Call<SearchAnswer> call = service.CallSearch(search, parameterInt);
                call.enqueue(new Callback<SearchAnswer>() {
                    @Override
                    public void onResponse(Call<SearchAnswer> call, Response<SearchAnswer> response) {
                        saveSearch(response.body());

                        if (listen != null) {
                            if (response.body().getTotal() > parameterInt + 25) {
                                listen.donne(true, parameterInt);
                            } else listen.donne(false, 0);
                        }
                    }

                    @Override
                    public void onFailure(Call<SearchAnswer> call, Throwable t) {
                    }
                });
                break;

            case Constants.ALBUM_CALL:
                id = parameterInt;
                Call<TrackAnswer> call2 = service.CallTracks(parameterInt);

                call2.enqueue(new Callback<TrackAnswer>() {
                    @Override
                    public void onResponse(Call<TrackAnswer> call, Response<TrackAnswer> response) {
                        saveAlbum(response.body());
                        if (listen != null)
                            listen.donne(false, 0);
                    }

                    @Override
                    public void onFailure(Call<TrackAnswer> call, Throwable t) {
                    }
                });
                break;
        }
    }

    public void saveSearch(SearchAnswer answer) {

        if (realm == null) {
            realm = Realm.getDefaultInstance();
        }

        realm.beginTransaction();
        for (Search s : answer.getData()) {
            realm.copyToRealm(s);
        }

        realm.commitTransaction();
    }



    public void saveAlbum(TrackAnswer answer) {

        if (realm == null) {
            realm = Realm.getDefaultInstance();
        }

        RealmQuery<Search> query = realm.where(Search.class);
        query.equalTo("id", Integer.toString(id));
        RealmResults<Search> result1 = query.findAll();
        final Search search = result1.first();

        realm.beginTransaction();
        for (Track t : answer.getData()) {
            t.setAlbum_name(search.getTitle());
            search.getDispTrack().add(t);
        }
        realm.commitTransaction();
    }

}
