package com.example.covidtracker.model;

public class Precautions {

    private String title;
    private String precautionsBody;
    private Integer imgResource;

    public Precautions(String title, String precautionsBody, Integer imgResource) {
        this.title = title;
        this.precautionsBody = precautionsBody;
        this.imgResource = imgResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrecautionsBody() {
        return precautionsBody;
    }

    public void setPrecautionsBody(String precautionsBody) {
        this.precautionsBody = precautionsBody;
    }

    public Integer getImgResource() {
        return imgResource;
    }

    public void setImgResource(Integer imgResource) {
        this.imgResource = imgResource;
    }
}
