package com.ll.location.service;

import com.ll.location.dao.UsercommentMapper;
import com.ll.location.domain.CommentResults;
import com.ll.location.domain.ExecuteResult;
import com.ll.location.model.Usercomment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by liulei on 2017/7/17.
 */
@Repository
public class CommentServiceImpl implements CommentService{
    @Autowired
    UsercommentMapper usercommentMapper;
    /**
     * 添加用户评论 或者广告
     *
     * @param usercomment
     */
    @Override
    public ExecuteResult comment(Usercomment usercomment) {

        //TODO 图片上传功能需要添加
        usercomment.setUsercommentid(UUID.randomUUID().toString());
        usercommentMapper.insert(usercomment);
        ExecuteResult executeResult = new ExecuteResult("0","评论添加成功");
        return executeResult;
    }

    /**
     * 返回用户评论或者广告
     *
     * @return
     */
    @Override
    public CommentResults listComment(Integer pageno,Integer pagesize) {
        Integer firstitem = pageno*pagesize -1;
        return null;
    }
}
