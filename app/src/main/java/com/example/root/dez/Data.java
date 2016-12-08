package com.example.root.dez;

/**
 * Created by root on 06.12.16.
 */

public class Data {
    private String title_short;

    private String id;

    private String readable;

    private String rank;

    private String duration;

    private String title;

    private String preview;

    private Album album;

    private String link;

    private String title_version;

    private Artist artist;

    private String type;

    private String explicit_lyrics;

    public String getTitle_short ()
    {
        return title_short;
    }

    public void setTitle_short (String title_short)
    {
        this.title_short = title_short;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getReadable ()
    {
        return readable;
    }

    public void setReadable (String readable)
    {
        this.readable = readable;
    }

    public String getRank ()
    {
        return rank;
    }

    public void setRank (String rank)
    {
        this.rank = rank;
    }

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getPreview ()
    {
        return preview;
    }

    public void setPreview (String preview)
    {
        this.preview = preview;
    }

    public Album getAlbum ()
    {
        return album;
    }

    public void setAlbum (Album album)
    {
        this.album = album;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getTitle_version ()
    {
        return title_version;
    }

    public void setTitle_version (String title_version)
    {
        this.title_version = title_version;
    }

    public Artist getArtist ()
    {
        return artist;
    }

    public void setArtist (Artist artist)
    {
        this.artist = artist;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getExplicit_lyrics ()
    {
        return explicit_lyrics;
    }

    public void setExplicit_lyrics (String explicit_lyrics)
    {
        this.explicit_lyrics = explicit_lyrics;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [title_short = "+title_short+", id = "+id+", readable = "+readable+", rank = "+rank+", duration = "+duration+", title = "+title+", preview = "+preview+", album = "+album+", link = "+link+", title_version = "+title_version+", artist = "+artist+", type = "+type+", explicit_lyrics = "+explicit_lyrics+"]";
    }
}
