package com.example.root.dez;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 07.12.16.
 */

public class SearchFragment extends Fragment implements View.OnClickListener {

    private ListView songs;
    private ArrayAdapter<String> listAdapter;
    private int PageIndex = 0;
    private AlertDialog dialog;


    private Button btn_search, btn_next, btn_prev;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search,container,false);

        stdFragment(view);
        return view;
    }

    public void stdFragment(View view) {
        songs = (ListView)view.findViewById(R.id.lv_songs);


        btn_next = (Button) view.findViewById(R.id.btn_next);
        btn_prev = (Button) view.findViewById(R.id.btn_prev);
        btn_search = (Button) view.findViewById(R.id.btn_search);

        btn_next.setOnClickListener(this);
        btn_prev.setOnClickListener(this);
        btn_search.setOnClickListener(this);


        ArrayList<String> planetList = new ArrayList<String>();
        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, planetList);

        Request();


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_search:


                break;
            case R.id.btn_next:
                PageIndex = PageIndex + 25;
                Request();
                break;
            case R.id.btn_prev:
                PageIndex = PageIndex - 25;
                Request();

                break;


        }
    }


    private void Request() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API service = retrofit.create(API.class);

        Call<SearchResults> call = service.valami("eminem", PageIndex);

        call.enqueue(new Callback<SearchResults>() {
            @Override
            public void onResponse(Call<SearchResults> call, Response<SearchResults> response) {

                Toast.makeText(getActivity(), response.toString(),
                        Toast.LENGTH_LONG).show();
                ListIt(response.body());


            }

            @Override
            public void onFailure(Call<SearchResults> call, Throwable t) {
                Toast.makeText(getActivity(), "this is my Toast message!!! =)",
                        Toast.LENGTH_LONG).show();

            }
        });


    }

    public void ListIt(SearchResults sr) {

        listAdapter.clear();

        for (int i = 0; i != sr.getData().length; i++) {

            listAdapter.add(sr.getData()[i].getTitle());

        }

        songs.setAdapter(listAdapter);


    }
}
