package com.ll.location.model;

import java.util.Date;

public class Usersignin {
    private String usersigninid;

    private String userid;

    private String localdtlid;

    private Date createtime;

    private Date updatetime;

    private Long signincount;

    public String getUsersigninid() {
        return usersigninid;
    }

    public void setUsersigninid(String usersigninid) {
        this.usersigninid = usersigninid == null ? null : usersigninid.trim();
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

    public Long getSignincount() {
        return signincount;
    }

    public void setSignincount(Long signincount) {
        this.signincount = signincount;
    }
}