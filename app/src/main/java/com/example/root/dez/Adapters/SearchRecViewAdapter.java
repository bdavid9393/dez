package com.example.root.dez.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.root.dez.Fragments.SearchFragment;
import com.example.root.dez.Model.Search;
import com.example.root.dez.R;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class SearchRecViewAdapter extends RealmRecyclerViewAdapter<Search,SearchRecViewAdapter.MyViewHolder> {

    private final SearchFragment activity;



    boolean isLoading = false, isMoreDataAvailable = true;


    public SearchRecViewAdapter(SearchFragment activity, OrderedRealmCollection<Search> data) {
        super(activity.getActivity() ,data, false);
        this.activity = activity;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        Search obj = getData().get(position);
        holder.data = obj;
        holder.artist.setText(obj.getArtist().getName());
        holder.albumName.setText(obj.getTitle());

        if(position>=getItemCount()-1 && isMoreDataAvailable  ){

            activity.loadMore();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView artist;
        public TextView albumName;
        public Search data;

        public MyViewHolder(View view) {
            super(view);
            artist = (TextView) view.findViewById(R.id.row_artist_tv);
            albumName = (TextView) view.findViewById(R.id.row_album_tv);

            view.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            activity.onSelectAlbum(data);

        }
    }

    public void setMoreDataAvailable(boolean moreDataAvailable) {
        isMoreDataAvailable = moreDataAvailable;
    }
}

