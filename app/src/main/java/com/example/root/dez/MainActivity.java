package com.example.root.dez;
import android.app.Fragment;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;


import com.example.root.dez.Fragments.SearchFragment;
import com.example.root.dez.Model.SearchAnswer;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends FragmentActivity {

    private Realm realm;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        initFragment();
    }

    private void initFragment(){




        Fragment fragment;

        fragment = new SearchFragment();

        FragmentTransaction ft = getFragmentManager()
                .beginTransaction();
        ft.replace(R.id.fragment_frame,fragment);

        ft.commit();
    }






}
