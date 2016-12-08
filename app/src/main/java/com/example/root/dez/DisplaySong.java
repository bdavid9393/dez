package com.example.root.dez;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by root on 06.12.16.
 */

public class DisplaySong extends Fragment implements View.OnClickListener{



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.song_fragment,container,false);

        stdFragment(view);
        return view;
    }

    private void stdFragment(View view) {



    }


    @Override
    public void onClick(View view) {

    }
}
