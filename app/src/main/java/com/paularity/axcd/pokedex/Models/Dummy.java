package com.paularity.axcd.pokedex.Models;

public class Dummy
{
    private String title;
    private String description;
    private String time;
    private String img;

    public Dummy(String title, String description, String time, String img)
    {
        this.title = title;
        this.description = description;
        this.time = time;
        this.img = img;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getImg()
    {
        return img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

}
