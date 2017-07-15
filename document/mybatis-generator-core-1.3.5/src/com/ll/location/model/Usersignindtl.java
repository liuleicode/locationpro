package com.ll.location.model;

import java.util.Date;

public class Usersignindtl {
    private String usersignindtlid;

    private String usersignid;

    private String userid;

    private String localdtlid;

    private Date createtime;

    private Date updatetime;

    public String getUsersignindtlid() {
        return usersignindtlid;
    }

    public void setUsersignindtlid(String usersignindtlid) {
        this.usersignindtlid = usersignindtlid == null ? null : usersignindtlid.trim();
    }

    public String getUsersignid() {
        return usersignid;
    }

    public void setUsersignid(String usersignid) {
        this.usersignid = usersignid == null ? null : usersignid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getLocaldtlid() {
        return localdtlid;
    }

    public void setLocaldtlid(String localdtlid) {
        this.localdtlid = localdtlid == null ? null : localdtlid.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}