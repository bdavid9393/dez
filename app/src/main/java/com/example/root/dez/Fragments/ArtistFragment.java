package com.example.root.dez.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.root.dez.Constants;
import com.example.root.dez.DeezRequest;
import com.example.root.dez.Model.Artist;
import com.example.root.dez.Model.Search;
import com.example.root.dez.OnSavedListener;
import com.example.root.dez.R;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by root on 13.12.16.
 */

public class ArtistFragment extends Fragment {

    private int artistID;
    private Realm realm;
    private TextView tv_artist, tv_link;
    private ProgressBar pb_image;

    private RealmResults<Artist> result1;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_artist, container, false);
        artistID = getArguments().getInt("ArtistID", 0);
        loadData(view);
        return view;
    }


    public void loadData(View view) {

        if (realm == null) {
            realm = Realm.getDefaultInstance();
        }

        RealmQuery<Artist> query = realm.where(Artist.class).equalTo("id", Integer.toString(artistID));
        result1 = query.findAll();
        final Artist artist = result1.first();


        tv_artist = (TextView) view.findViewById(R.id.tv_artist_name_2);
        tv_link = (TextView) view.findViewById(R.id.tv_album_link_2);

        tv_artist.setText(artist.getName());
        tv_link.setText(artist.getLink());

        ImageView albumImage = (ImageView) view.findViewById(R.id.iv_artist);
        String internetUrl = artist.getPicture_big();
        pb_image = (ProgressBar) view.findViewById(R.id.pb_image_artist);
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


        tv_link.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(artist.getLink()));
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
