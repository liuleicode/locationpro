package com.ll.location.domain;

import com.ll.location.model.Localimg;
import com.ll.location.model.Usercomment;

import java.util.List;

/**
 * Created by liulei on 2017/7/17.
 * 用户评论单条记录 包括多个图片
 */
public class CommentResults {


    List<CommentResult> commentResults;

    public List<CommentResult> getCommentResults() {
        return commentResults;
    }

    public void setCommentResults(List<CommentResult> commentResults) {
        this.commentResults = commentResults;
    }

}
