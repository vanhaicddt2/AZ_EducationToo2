package com.example.azeducationtoo;

public class VideoYoutube {
    private String Title;
    private String Thumbnail;
    private String Picture;
    private String Idvideo;



    public VideoYoutube(String title, String thumbnail, String picture,String idvideo) {
        Title = title;
        Thumbnail = thumbnail;
        Picture = picture;
        Idvideo = idvideo;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        Thumbnail = thumbnail;
    }

    public String getIdvideo() {
        return Idvideo;
    }

    public void setIdvideo(String idvideo) {
        Idvideo = idvideo;
    }
}
