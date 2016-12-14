package com.example.root.dez.Fragments;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.example.root.dez.Constants;
import com.example.root.dez.DeezRequest;
import com.example.root.dez.Model.Album;
import com.example.root.dez.Model.Artist;
import com.example.root.dez.Model.Gerne;
import com.example.root.dez.Model.Search;
import com.example.root.dez.Model.Track;
import com.example.root.dez.OnSavedListener;
import com.example.root.dez.R;
import com.example.root.dez.Adapters.SearchRecViewAdapter;


import io.realm.Realm;

import io.realm.RealmQuery;
import io.realm.RealmResults;


/**
 * Created by root on 07.12.16.
 */

public class SearchFragment extends Fragment implements View.OnClickListener {


    private Realm realm;
    private int pageIndex;
    private Button btn_search;
    private ProgressBar pb_search;
    private RecyclerView recyclerView;
    private SearchRecViewAdapter sa;
    private DeezRequest r = new DeezRequest();
    private EditText et_search;
    private String toSearch;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        if (realm == null)
            realm = Realm.getDefaultInstance();

        et_search = (EditText) view.findViewById(R.id.et_search);
        pb_search = (ProgressBar) view.findViewById(R.id.pb_search);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        btn_search = (Button) view.findViewById(R.id.btn_search);
        pb_search.setVisibility(View.GONE);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        sa = new SearchRecViewAdapter(this, realm.where(Search.class).findAllAsync());
        recyclerView.setAdapter(sa);
        recyclerView.setHasFixedSize(true);

        btn_search.setOnClickListener(this);

        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_search:
                toSearch = et_search.getText().toString();
                if (!toSearch.isEmpty()) {
                    pb_search.setVisibility(View.VISIBLE);
                    if (!realm.isEmpty()) {
                        deletePreviousSearch();
                    }
                    startSearch();

                } else
                    Toast.makeText(getActivity(), "A mező üres!",
                            Toast.LENGTH_SHORT).show();

                break;
        }
    }


    public void startSearch() {
        r.Request(Constants.SEARCH_CALL, 0, toSearch);

        r.setOnSavedListener(new OnSavedListener() {


            @Override
            public void donne(Boolean result, int pageIndex) {
                RealmResults<Search> query = realm.where(Search.class).findAll();
               if( query.isEmpty())
                   Toast.makeText(getActivity(), "Nincs találat!",
                           Toast.LENGTH_SHORT).show();

                setPageIndex(pageIndex);
                sa.setMoreDataAvailable(result);
                setUpRecyclerView();
            }
        });
    }

    private void setUpRecyclerView() {
        sa.notifyDataSetChanged();

        pb_search.setVisibility(View.GONE);
    }


    public void loadMore() {
        pb_search.setVisibility(View.VISIBLE);
        r.Request(Constants.SEARCH_CALL, pageIndex + 25, toSearch);
        sa.setMoreDataAvailable(true);

    }

    public void deletePreviousSearch() {
        pageIndex = 0;
        RealmResults<Search> rows1 = realm.where(Search.class).findAll();
        RealmResults<Track> rows2 = realm.where(Track.class).findAll();
        RealmResults<Album> rows3 = realm.where(Album.class).findAll();
        RealmResults<Artist> rows4 = realm.where(Artist.class).findAll();
        RealmResults<Gerne> rows5 = realm.where(Gerne.class).findAll();

        realm.beginTransaction();
        rows1.deleteAllFromRealm();
        rows2.deleteAllFromRealm();
        rows3.deleteAllFromRealm();
        rows4.deleteAllFromRealm();
        rows5.deleteAllFromRealm();
        realm.commitTransaction();

        sa.notifyDataSetChanged();
    }

    public void onSelectAlbum(Search search) {

        RealmResults<Track> rows2 = realm.where(Track.class).findAll();
        realm.beginTransaction();
        rows2.deleteAllFromRealm();
        realm.commitTransaction();

        Fragment fragment = new AlbumFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("AlbumID", Integer.parseInt(search.getId()));
        fragment.setArguments(bundle);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        ft.addToBackStack(null);
        ft.commit();

    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}


