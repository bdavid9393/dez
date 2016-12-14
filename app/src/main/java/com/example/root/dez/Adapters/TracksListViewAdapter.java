package com.example.root.dez.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.root.dez.Fragments.AlbumFragment;
import com.example.root.dez.Model.Track;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;
import io.realm.internal.Context;

/**
 * Created by root on 13.12.16.
 */

public class TracksListViewAdapter extends RealmBaseAdapter<Track> implements ListAdapter {

    private AlbumFragment activity;

    private static class ViewHolder  {
        TextView track;


    }

    public TracksListViewAdapter(OrderedRealmCollection<Track> realmResults, AlbumFragment activity) {
        super(activity.getActivity(),realmResults);
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)  {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.track = (TextView) convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Track item = adapterData.get(position);
        viewHolder.track.setText(item.getTrack_position()+"-"+item.getTitle());
        return convertView;
    }
}



