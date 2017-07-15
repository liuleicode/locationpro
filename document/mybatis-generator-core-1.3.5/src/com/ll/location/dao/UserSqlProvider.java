package com.ll.location.dao;

import com.ll.location.model.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");
        
        if (record.getUserid() != null) {
            sql.VALUES("userid", "#{userid,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("createtime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastsignintime() != null) {
            sql.VALUES("lastsignintime", "#{lastsignintime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getCreatetime() != null) {
            sql.SET("createtime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastsignintime() != null) {
            sql.SET("lastsignintime = #{lastsignintime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("userid = #{userid,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}