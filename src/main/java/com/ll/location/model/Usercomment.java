package com.ll.location.model;

public class Usercomment {
    private String usercommentid;

    private String userid;

    private String localdtlid;

    private String comment;

    private String commenttype;

    public String getUsercommentid() {
        return usercommentid;
    }

    public void setUsercommentid(String usercommentid) {
        this.usercommentid = usercommentid == null ? null : usercommentid.trim();
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getCommenttype() {
        return commenttype;
    }

    public void setCommenttype(String commenttype) {
        this.commenttype = commenttype == null ? null : commenttype.trim();
    }
}