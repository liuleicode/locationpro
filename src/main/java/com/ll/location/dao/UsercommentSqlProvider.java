package com.ll.location.dao;

import com.ll.location.model.Usercomment;
import org.apache.ibatis.jdbc.SQL;

public class UsercommentSqlProvider {

    public String insertSelective(Usercomment record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("usercomment");
        
        if (record.getUsercommentid() != null) {
            sql.VALUES("usercommentid", "#{usercommentid,jdbcType=VARCHAR}");
        }
        
        if (record.getUserid() != null) {
            sql.VALUES("userid", "#{userid,jdbcType=VARCHAR}");
        }
        
        if (record.getLocaldtlid() != null) {
            sql.VALUES("localdtlid", "#{localdtlid,jdbcType=VARCHAR}");
        }
        
        if (record.getComment() != null) {
            sql.VALUES("comment", "#{comment,jdbcType=VARCHAR}");
        }
        
        if (record.getCommenttype() != null) {
            sql.VALUES("commenttype", "#{commenttype,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Usercomment record) {
        SQL sql = new SQL();
        sql.UPDATE("usercomment");
        
        if (record.getUserid() != null) {
            sql.SET("userid = #{userid,jdbcType=VARCHAR}");
        }
        
        if (record.getLocaldtlid() != null) {
            sql.SET("localdtlid = #{localdtlid,jdbcType=VARCHAR}");
        }
        
        if (record.getComment() != null) {
            sql.SET("comment = #{comment,jdbcType=VARCHAR}");
        }
        
        if (record.getCommenttype() != null) {
            sql.SET("commenttype = #{commenttype,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("usercommentid = #{usercommentid,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}