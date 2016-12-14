package com.example.root.dez.Model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by root on 06.12.16.
 */

public class SearchAnswer extends RealmObject {
    @PrimaryKey
    private long id;

    private int total;

    private String next;

    private RealmList<Search> data;

    public int getTotal ()
    {
        return total;
    }

    public void setTotal (int total)
    {
        this.total = total;
    }

    public String getNext ()
    {
        return next;
    }

    public void setNext (String next)
    {
        this.next = next;
    }

    public RealmList<Search> getData() {
        return data;
    }

    public void setData(RealmList<Search> data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
