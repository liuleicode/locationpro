package com.ll.location.service;

import com.ll.location.dao.LocalimgMapper;
import com.ll.location.dao.UsercommentMapper;
import com.ll.location.domain.CommentResult;
import com.ll.location.domain.ExecuteResult;
import com.ll.location.model.Localimg;
import com.ll.location.model.Usercomment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by liulei on 2017/7/17.
 */
@Repository
public class CommentServiceImpl implements CommentService {
    @Autowired
    UsercommentMapper usercommentMapper;
    @Autowired
    LocalimgMapper localimgMapper;

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
        ExecuteResult executeResult = new ExecuteResult("0", "评论添加成功");
        return executeResult;
    }

    /**
     * 返回用户评论或者广告
     *
     * @return
     */
    @Override
    public List<CommentResult> listComment(Integer pageno, Integer pagesize, String commenttype) {
        Integer firstitem = pageno * pagesize - 1;

        List<CommentResult> commentResultList = new ArrayList<>();
        List<String> usercommentsids = new ArrayList<>();
        List<Usercomment> usercomments = usercommentMapper.selectByCommenttypeByPage(pageno * pagesize - 1, pagesize, commenttype);
        //空则无数据
        if (usercomments == null || usercomments.isEmpty())
            return commentResultList;

        for (Usercomment usercomment : usercomments) {
            CommentResult commentResult = new CommentResult();
            commentResult.setUsercomment(usercomment);
            usercommentsids.add(usercomment.getUsercommentid());
            commentResultList.add(commentResult);
        }


        List<Localimg> localimgs = localimgMapper.selectByUsercommentids(usercommentsids);
        if (localimgs == null || localimgs.isEmpty()) {
            return commentResultList;
        }

        for (CommentResult commentResult : commentResultList) {
            for (Localimg localimg : localimgs) {
                if (commentResult.getUsercomment().getUsercommentid().equals(localimg.getImgtypeid())) {
                    if (commentResult.getLocalimgs() == null)
                        commentResult.setLocalimgs(new ArrayList<>());

                    commentResult.getLocalimgs().add(localimg);
                }
            }
        }

        return commentResultList;
    }
}
