package com.ll.location.dao;

import com.ll.location.model.Local;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;


public class LocalSqlProvider {

    public String insertSelective(Local record) {
        BEGIN();
        INSERT_INTO("local");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getLocalno() != null) {
            VALUES("localno", "#{localno,jdbcType=VARCHAR}");
        }
        
        if (record.getLocalname() != null) {
            VALUES("localname", "#{localname,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            VALUES("province", "#{province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            VALUES("city", "#{city,jdbcType=VARCHAR}");
        }
        
        if (record.getStreet() != null) {
            VALUES("street", "#{street,jdbcType=VARCHAR}");
        }
        
        if (record.getOrigin() != null) {
            VALUES("origin", "#{origin,jdbcType=VARCHAR}");
        }
        
        if (record.getMeaning() != null) {
            VALUES("meaning", "#{meaning,jdbcType=VARCHAR}");
        }
        
        if (record.getEvolution() != null) {
            VALUES("evolution", "#{evolution,jdbcType=VARCHAR}");
        }
        
        if (record.getPosition() != null) {
            VALUES("position", "#{position,jdbcType=VARCHAR}");
        }
        
        if (record.getStory() != null) {
            VALUES("story", "#{story,jdbcType=VARCHAR}");
        }
        
        if (record.getImage() != null) {
            VALUES("image", "#{image,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Local record) {
        BEGIN();
        UPDATE("local");
        
        if (record.getLocalno() != null) {
            SET("localno = #{localno,jdbcType=VARCHAR}");
        }
        
        if (record.getLocalname() != null) {
            SET("localname = #{localname,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            SET("province = #{province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            SET("city = #{city,jdbcType=VARCHAR}");
        }
        
        if (record.getStreet() != null) {
            SET("street = #{street,jdbcType=VARCHAR}");
        }
        
        if (record.getOrigin() != null) {
            SET("origin = #{origin,jdbcType=VARCHAR}");
        }
        
        if (record.getMeaning() != null) {
            SET("meaning = #{meaning,jdbcType=VARCHAR}");
        }
        
        if (record.getEvolution() != null) {
            SET("evolution = #{evolution,jdbcType=VARCHAR}");
        }
        
        if (record.getPosition() != null) {
            SET("position = #{position,jdbcType=VARCHAR}");
        }
        
        if (record.getStory() != null) {
            SET("story = #{story,jdbcType=VARCHAR}");
        }
        
        if (record.getImage() != null) {
            SET("image = #{image,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }
}