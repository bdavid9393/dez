package com.example.root.dez;

/**
 * Created by root on 06.12.16.
 */

public class SearchResults {

    private String total;

    private String next;

    private Data[] data;

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
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

    public Data[] getData ()
    {
        return data;
    }

    public void setData (Data[] data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [total = "+total+", next = "+next+", data = "+data+"]";
    }
}
