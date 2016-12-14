package com.example.root.dez.Fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.root.dez.Constants;
import com.example.root.dez.DeezRequest;
import com.example.root.dez.Model.Search;
import com.example.root.dez.Model.Track;
import com.example.root.dez.OnSavedListener;
import com.example.root.dez.R;
import com.example.root.dez.Adapters.TracksListViewAdapter;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by root on 13.12.16.
 */

public class AlbumFragment extends Fragment {
    private int searchID, artistID;
    private Realm realm;
    private TextView tv_album, tv_artist, tv_link;
    private ProgressBar pb_list, pb_image;
    private Boolean isAlreadyLoaded = false;
    private ListView listView;

    private DeezRequest r = new DeezRequest();
    private RealmResults<Search> result1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_album, container, false);
        searchID = getArguments().getInt("AlbumID", 0);

        loadData(view);
        return view;
    }


    public void loadData(View view) {

        if (realm == null) {
            realm = Realm.getDefaultInstance();
        }

        RealmQuery<Search> query = realm.where(Search.class);
        query.equalTo("id", Integer.toString(searchID));
        result1 = query.findAll();
        final Search search = result1.first();
        artistID = Integer.parseInt(search.getArtist().getId());

        listView = (ListView) view.findViewById(R.id.lv_tracklist);

        pb_list = (ProgressBar) view.findViewById(R.id.pb_album);
        tv_album = (TextView) view.findViewById(R.id.tv_album_name);
        tv_artist = (TextView) view.findViewById(R.id.tv_artist_name);
        tv_link = (TextView) view.findViewById(R.id.tv_album_link);

        tv_album.setText(search.getTitle());
        tv_artist.setText(search.getArtist().getName());
        tv_link.setText(search.getLink());

        ImageView albumImage = (ImageView) view.findViewById(R.id.iv_album);
        String internetUrl = search.getCover_big();

        pb_image = (ProgressBar) view.findViewById(R.id.pb_image_album);
        Glide.with(getActivity())
                .load(internetUrl)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        pb_image.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        pb_image.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(albumImage);


        if (!isAlreadyLoaded)
            r.Request(Constants.ALBUM_CALL, searchID);
        else ListTracks();


        r.setOnSavedListener(new OnSavedListener() {
            @Override
            public void donne(Boolean result, int pi) {

                setAlreadyLoaded(true);
                ListTracks();
            }
        });

        tv_artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onArtistClickListener();
            }
        });

        tv_link.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(search.getLink()));
                getActivity().startActivity(intent);
            }
        });

    }


    public void ListTracks() {
        if (realm == null) {
            realm = Realm.getDefaultInstance();
        }


        RealmResults<Track> trackRealmResults = realm.where(Track.class).findAll();
        final TracksListViewAdapter adapter = new TracksListViewAdapter(trackRealmResults, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onTrackSelected(adapter.getItem(i).getId());}
        });
        pb_list.setVisibility(View.GONE);


    }

    public void onTrackSelected(String trackID) {

        Fragment fragment = new TrackFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("TrackID", Integer.parseInt(trackID));
        fragment.setArguments(bundle);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        ft.addToBackStack(null);
        ft.commit();


    }

    private void onArtistClickListener() {
        Fragment fragment = new ArtistFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("ArtistID", artistID);
        fragment.setArguments(bundle);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        ft.addToBackStack(null);
        ft.commit();


    }

    public void setAlreadyLoaded(Boolean alreadyLoaded) {
        isAlreadyLoaded = alreadyLoaded;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
