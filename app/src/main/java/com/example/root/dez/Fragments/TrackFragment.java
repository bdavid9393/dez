package com.example.root.dez.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.root.dez.DeezRequest;
import com.example.root.dez.Model.Artist;
import com.example.root.dez.Model.Search;
import com.example.root.dez.Model.Track;
import com.example.root.dez.R;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by root on 13.12.16.
 */

public class TrackFragment extends Fragment {


    private int trackID;
    private Realm realm;
    private TextView tv_album, tv_artist, tv_link, tv_title, tv_duration;
    private DeezRequest r = new DeezRequest();
    private RealmResults<Track> result1, result2;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_track, container, false);
        trackID = getArguments().getInt("TrackID", 0);
        loadData(view);
        return view;
    }


    public void loadData(View view) {

        if (realm == null) {
            realm = Realm.getDefaultInstance();
        }

        RealmQuery<Track> query = realm.where(Track.class).equalTo("id", Integer.toString(trackID));

        result1 = query.findAll();
        final Track track = result1.first();


        tv_artist = (TextView) view.findViewById(R.id.tv_artist_name_track);
        tv_link = (TextView) view.findViewById(R.id.tv_track_link_track);
        tv_album = (TextView) view.findViewById(R.id.tv_album_name_track);
        tv_title = (TextView) view.findViewById(R.id.tv_track_title_track);
        tv_duration = (TextView) view.findViewById(R.id.tv_duration_track);


        tv_artist.setText(track.getArtist().getName());
        tv_link.setText(track.getLink());
        tv_title.setText(track.getTitle());
        tv_duration.setText(track.getDuration());
        tv_album.setText(track.getAlbum_name());

        tv_link.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(track.getLink()));
                getActivity().startActivity(intent);
            }
        });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }

}
