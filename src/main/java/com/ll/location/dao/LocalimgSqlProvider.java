package com.ll.location.dao;

import com.ll.location.model.Localimg;
import org.apache.ibatis.jdbc.SQL;

public class LocalimgSqlProvider {

    public String insertSelective(Localimg record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("localimg");
        
        if (record.getLocalimgid() != null) {
            sql.VALUES("localimgid", "#{localimgid,jdbcType=BIGINT}");
        }
        
        if (record.getImgtypeid() != null) {
            sql.VALUES("imgtypeid", "#{imgtypeid,jdbcType=VARCHAR}");
        }
        
        if (record.getImgtype() != null) {
            sql.VALUES("imgtype", "#{imgtype,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getImgurl() != null) {
            sql.VALUES("imgurl", "#{imgurl,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Localimg record) {
        SQL sql = new SQL();
        sql.UPDATE("localimg");
        
        if (record.getImgtypeid() != null) {
            sql.SET("imgtypeid = #{imgtypeid,jdbcType=VARCHAR}");
        }
        
        if (record.getImgtype() != null) {
            sql.SET("imgtype = #{imgtype,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getImgurl() != null) {
            sql.SET("imgurl = #{imgurl,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("localimgid = #{localimgid,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}