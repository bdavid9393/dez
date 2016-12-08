package com.example.root.dez;

/**
 * Created by root on 06.12.16.
 */

public class DzUser {


        private String picture;

        private String id;

        private String picture_medium;

        private String picture_big;

        private String picture_small;

        private String link;

        private String name;

        private String tracklist;

        private String type;

        private String country;

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

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getTracklist ()
    {
        return tracklist;
    }

    public void setTracklist (String tracklist)
    {
        this.tracklist = tracklist;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getPicture_xl ()
    {
        return picture_xl;
    }

    public void setPicture_xl (String picture_xl)
    {
        this.picture_xl = picture_xl;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [picture = "+picture+", id = "+id+", picture_medium = "+picture_medium+", picture_big = "+picture_big+", picture_small = "+picture_small+", link = "+link+", name = "+name+", tracklist = "+tracklist+", type = "+type+", country = "+country+", picture_xl = "+picture_xl+"]";
    }

}
