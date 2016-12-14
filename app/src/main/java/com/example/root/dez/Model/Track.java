package com.example.root.dez.Model;

import io.realm.RealmObject;

/**
 * Created by root on 10.12.16.
 */

public class Track extends RealmObject {
    private String readable;



    private String isrc;

    private String disk_number;



    private String link;

    private String title_version;

    private String type;

    private String gain;

    private String bpm;

    private String album_name;

    private String id;

    private String title_short;

    private String track_position;

    private String title;

    private String share;

    private String duration;

    private String rank;

    private String preview;



    private String release_date;

    private Artist artist;

    private String explicit_lyrics;


    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getReadable ()
    {
        return readable;
    }

    public void setReadable (String readable)
    {
        this.readable = readable;
    }




    public String getIsrc ()
    {
        return isrc;
    }

    public void setIsrc (String isrc)
    {
        this.isrc = isrc;
    }

    public String getDisk_number ()
    {
        return disk_number;
    }

    public void setDisk_number (String disk_number)
    {
        this.disk_number = disk_number;
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

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getGain ()
    {
        return gain;
    }

    public void setGain (String gain)
    {
        this.gain = gain;
    }

    public String getBpm ()
    {
        return bpm;
    }

    public void setBpm (String bpm)
    {
        this.bpm = bpm;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle_short ()
    {
        return title_short;
    }

    public void setTitle_short (String title_short)
    {
        this.title_short = title_short;
    }

    public String getTrack_position ()
    {
        return track_position;
    }

    public void setTrack_position (String track_position)
    {
        this.track_position = track_position;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getShare ()
    {
        return share;
    }

    public void setShare (String share)
    {
        this.share = share;
    }

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getRank ()
    {
        return rank;
    }

    public void setRank (String rank)
    {
        this.rank = rank;
    }

    public String getPreview ()
    {
        return preview;
    }

    public void setPreview (String preview)
    {
        this.preview = preview;
    }



    public String getRelease_date ()
    {
        return release_date;
    }

    public void setRelease_date (String release_date)
    {
        this.release_date = release_date;
    }

    public Artist getArtist ()
    {
        return artist;
    }

    public void setArtist (Artist artist)
    {
        this.artist = artist;
    }

    public String getExplicit_lyrics ()
    {
        return explicit_lyrics;
    }

    public void setExplicit_lyrics (String explicit_lyrics)
    {
        this.explicit_lyrics = explicit_lyrics;
    }
}
