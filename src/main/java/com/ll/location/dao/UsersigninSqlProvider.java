package com.ll.location.dao;

import com.ll.location.model.Usersignin;
import org.apache.ibatis.jdbc.SQL;

public class UsersigninSqlProvider {

    public String insertSelective(Usersignin record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("usersignin");
        
        if (record.getUsersigninid() != null) {
            sql.VALUES("usersigninid", "#{usersigninid,jdbcType=VARCHAR}");
        }
        
        if (record.getUserid() != null) {
            sql.VALUES("userid", "#{userid,jdbcType=VARCHAR}");
        }
        
        if (record.getLocaldtlid() != null) {
            sql.VALUES("localdtlid", "#{localdtlid,jdbcType=VARCHAR}");
        }
        
        if (record.getLocaldtlname() != null) {
            sql.VALUES("localdtlname", "#{localdtlname,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("createtime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatetime() != null) {
            sql.VALUES("updatetime", "#{updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSignincount() != null) {
            sql.VALUES("signincount", "#{signincount,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Usersignin record) {
        SQL sql = new SQL();
        sql.UPDATE("usersignin");
        
        if (record.getUserid() != null) {
            sql.SET("userid = #{userid,jdbcType=VARCHAR}");
        }
        
        if (record.getLocaldtlid() != null) {
            sql.SET("localdtlid = #{localdtlid,jdbcType=VARCHAR}");
        }
        
        if (record.getLocaldtlname() != null) {
            sql.SET("localdtlname = #{localdtlname,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("createtime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatetime() != null) {
            sql.SET("updatetime = #{updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSignincount() != null) {
            sql.SET("signincount = #{signincount,jdbcType=BIGINT}");
        }
        
        sql.WHERE("usersigninid = #{usersigninid,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}