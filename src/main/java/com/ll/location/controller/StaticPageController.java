package com.ll.location.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Wu on 2017/7/23.
 */
@Controller
@RequestMapping("/staticpage")
public class StaticPageController {


    @RequestMapping("/gofirstPage")
    public ModelAndView gofitstPage(){
        ModelAndView modelAndView=new ModelAndView("/jsp/staticpage/firstpage");
        return modelAndView;
    }

    @RequestMapping("/gofirstPage2")
    public ModelAndView gofitstPage2(){
        ModelAndView modelAndView=new ModelAndView("/jsp/staticpage/firstpage-2");
        return modelAndView;
    }

    /**
     * 评论
     * @return
     */
    @RequestMapping("/gocommentPage")
    public ModelAndView gocommentPage(){
        ModelAndView modelAndView=new ModelAndView("/jsp/staticpage/comment");
        return modelAndView;
    }

    /**
     * 评论-回复
     * @return
     */
    @RequestMapping("/gocommentPage2")
    public ModelAndView gocommentPage2(){
        ModelAndView modelAndView=new ModelAndView("/jsp/staticpage/comment-2");
        return modelAndView;
    }

    @RequestMapping("/gomycenterPage")
    public ModelAndView gomycenterPage(){
        ModelAndView modelAndView=new ModelAndView("/jsp/staticpage/mycenter");
        return modelAndView;
    }
}
