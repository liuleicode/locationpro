package com.ll.location.controller;

import com.alibaba.fastjson.JSONObject;
import com.ll.location.domain.CommentResults;
import com.ll.location.domain.ExecuteResult;
import com.ll.location.model.Localimg;
import com.ll.location.model.Usercomment;
import com.ll.location.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by liulei on 2017/7/17.
 */
@Controller
@RequestMapping("/comment")
public class CommentsController {

    Logger logger = LoggerFactory.getLogger(CommentsController.class);
    @Autowired
    CommentService commentService;

    @RequestMapping("/comment")
    @ResponseBody
    public ModelAndView comment(Usercomment usercomment, HttpServletRequest request, HttpServletResponse response) {
        //TODO 缺少图片上传的步骤 需要加上
        ModelAndView modelAndView = null;
        if (usercomment == null) {
            modelAndView = new ModelAndView("error");
            modelAndView.addObject("ExecuteResult", new ExecuteResult("1", "传入参数不能为空"));
            return modelAndView;
        }
        //usercomment.getCommenttype()  2-用户评论 3-广告
        if ("2".equals(usercomment.getCommenttype()))
            modelAndView = new ModelAndView("comments");
        else if ("3".equals(usercomment.getCommenttype()))
            modelAndView = new ModelAndView("advertisement");
        else {
            modelAndView = new ModelAndView("error");
            modelAndView.addObject("ExecuteResult", new ExecuteResult("1", "评论状态参数有误"));
            return modelAndView;
        }

        ExecuteResult executeResult = commentService.comment(usercomment);
        if (executeResult == null || "1".equals(executeResult.getSuccess())) {
            logger.error(JSONObject.toJSONString(executeResult));
            modelAndView = new ModelAndView("error");
            modelAndView.addObject("ExecuteResult", new ExecuteResult("1", "评论失败"));
            return modelAndView;
        }

        modelAndView.addObject("ExecuteResult", executeResult);

        return modelAndView;


    }

    /**
     * @param pageno
     * @param pagesize
     * @param request
     * @param response
     * @param commenttype 2-用户评论 3-广告
     * @return
     */
    @RequestMapping("/findcommentsbypage")
    public ModelAndView findCommentsByPage(Integer pageno, Integer pagesize, String commenttype, HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = null;
        if (pageno == null || pagesize == null || null == commenttype || (!"2".equals(commenttype) && !"3".equals(commenttype))) {
            modelAndView = new ModelAndView("error");
            modelAndView.addObject("ExecuteResult", new ExecuteResult("1", "传入参数有误"));
        }

        CommentResults commentResults = commentService.listComment(pageno, pagesize);

        //如果是评论 跳转到评论页面
        if("2".equals(commenttype)) {
            modelAndView = new ModelAndView("commentpage");
            modelAndView.addObject("commentResults",commentResults);
        }else{

            //如果是广告 跳转到广告页面
            modelAndView = new ModelAndView("broadcast");
            modelAndView.addObject("commentResults",commentResults);
        }

        return modelAndView;

    }
}
