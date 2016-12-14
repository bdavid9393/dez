package com.example.root.dez.Model;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by root on 13.12.16.
 */

public class TrackAnswer extends RealmObject{

    private String total;

    private RealmList<Track> data;

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public RealmList<Track> getData() {
        return data;
    }

    public void setData(RealmList<Track> data) {
        this.data = data;
    }
}
