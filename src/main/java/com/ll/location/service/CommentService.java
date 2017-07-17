package com.ll.location.service;

import com.ll.location.domain.CommentResults;
import com.ll.location.domain.ExecuteResult;
import com.ll.location.model.Usercomment;

/**
 * Created by liulei on 2017/7/17.
 */
public interface CommentService {
    /**
     * 添加用户评论 或者广告
     */
    ExecuteResult comment(Usercomment usercomment);

    /**
     * 返回用户评论或者广告
     * @return
     */
    CommentResults listComment();
}
