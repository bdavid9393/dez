package com.example.root.dez.Model;

import java.io.Reader;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by root on 10.12.16.
 */

public class Gerne extends RealmObject{
    private String picture;


    private String id;

    private String picture_medium;

    private String picture_big;

    private String picture_small;

    private String name;


    private String picture_xl;

    public String getPicture ()
    {
        return picture;
    }

    public void setPicture (String picture)
    {
        this.picture = picture;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getPicture_medium ()
    {
        return picture_medium;
    }

    public void setPicture_medium (String picture_medium)
    {
        this.picture_medium = picture_medium;
    }

    public String getPicture_big ()
    {
        return picture_big;
    }

    public void setPicture_big (String picture_big)
    {
        this.picture_big = picture_big;
    }

    public String getPicture_small ()
    {
        return picture_small;
    }

    public void setPicture_small (String picture_small)
    {
        this.picture_small = picture_small;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }


    public String getPicture_xl ()
    {
        return picture_xl;
    }

    public void setPicture_xl (String picture_xl)
    {
        this.picture_xl = picture_xl;
    }

}
