package com.ll.location.domain;

import com.ll.location.model.Localimg;
import com.ll.location.model.Usercomment;

import java.util.List;

/**
 * Created by liulei on 2017/7/17.
 * 用户评论单条记录 包括多个图片
 */
public class CommentResult {

 Usercomment usercomment;
 List<Localimg> localimgs;

 public Usercomment getUsercomment() {
  return usercomment;
 }

 public void setUsercomment(Usercomment usercomment) {
  this.usercomment = usercomment;
 }

 public List<Localimg> getLocalimgs() {
  return localimgs;
 }

 public void setLocalimgs(List<Localimg> localimgs) {
  this.localimgs = localimgs;
 }
}
