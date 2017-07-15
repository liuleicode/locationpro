package com.ll.location.model;

import java.util.Date;

public class User {
    private String userid;

    private Date createtime;

    private Date lastsignintime;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastsignintime() {
        return lastsignintime;
    }

    public void setLastsignintime(Date lastsignintime) {
        this.lastsignintime = lastsignintime;
    }
}