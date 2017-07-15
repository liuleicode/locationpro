package com.ll.location.model;

public class Localimg {
    private Long localimgid;

    private String imgtypeid;

    private String imgtype;

    private String status;

    private String imgurl;

    public Long getLocalimgid() {
        return localimgid;
    }

    public void setLocalimgid(Long localimgid) {
        this.localimgid = localimgid;
    }

    public String getImgtypeid() {
        return imgtypeid;
    }

    public void setImgtypeid(String imgtypeid) {
        this.imgtypeid = imgtypeid == null ? null : imgtypeid.trim();
    }

    public String getImgtype() {
        return imgtype;
    }

    public void setImgtype(String imgtype) {
        this.imgtype = imgtype == null ? null : imgtype.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }
}