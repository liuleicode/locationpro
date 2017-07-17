package com.ll.location.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by liulei on 2017/7/17.
 */
@Controller
@RequestMapping("/comment")
public class CommentsController {

    @RequestMapping("/comment")
    public ModelAndView comment(){


    }

    @RequestMapping("/findcomments")
    public ModelAndView findcomments(){

    }
}
