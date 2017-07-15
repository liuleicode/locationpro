package com.ll.location.dao;

import com.ll.location.model.Usersignindtl;
import org.apache.ibatis.jdbc.SQL;

public class UsersignindtlSqlProvider {

    public String insertSelective(Usersignindtl record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("usersignindtl");
        
        if (record.getUsersignindtlid() != null) {
            sql.VALUES("usersignindtlid", "#{usersignindtlid,jdbcType=VARCHAR}");
        }
        
        if (record.getUsersignid() != null) {
            sql.VALUES("usersignid", "#{usersignid,jdbcType=VARCHAR}");
        }
        
        if (record.getUserid() != null) {
            sql.VALUES("userid", "#{userid,jdbcType=VARCHAR}");
        }
        
        if (record.getLocaldtlid() != null) {
            sql.VALUES("localdtlid", "#{localdtlid,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("createtime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatetime() != null) {
            sql.VALUES("updatetime", "#{updatetime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Usersignindtl record) {
        SQL sql = new SQL();
        sql.UPDATE("usersignindtl");
        
        if (record.getUsersignid() != null) {
            sql.SET("usersignid = #{usersignid,jdbcType=VARCHAR}");
        }
        
        if (record.getUserid() != null) {
            sql.SET("userid = #{userid,jdbcType=VARCHAR}");
        }
        
        if (record.getLocaldtlid() != null) {
            sql.SET("localdtlid = #{localdtlid,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("createtime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatetime() != null) {
            sql.SET("updatetime = #{updatetime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("usersignindtlid = #{usersignindtlid,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}