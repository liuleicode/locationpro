package com.ll.location.dao;

import com.ll.location.model.Localdtl;
import org.apache.ibatis.jdbc.SQL;

public class LocaldtlSqlProvider {

    public String insertSelective(Localdtl record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("localdtl");
        
        if (record.getLocationid() != null) {
            sql.VALUES("locationid", "#{locationid,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getParentid() != null) {
            sql.VALUES("parentid", "#{parentid,jdbcType=VARCHAR}");
        }
        
        if (record.getLocallevel() != null) {
            sql.VALUES("locallevel", "#{locallevel,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getCountryid() != null) {
            sql.VALUES("countryid", "#{countryid,jdbcType=VARCHAR}");
        }
        
        if (record.getCountryname() != null) {
            sql.VALUES("countryname", "#{countryname,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceid() != null) {
            sql.VALUES("provinceid", "#{provinceid,jdbcType=VARCHAR}");
        }
        
        if (record.getProvincename() != null) {
            sql.VALUES("provincename", "#{provincename,jdbcType=VARCHAR}");
        }
        
        if (record.getCityid() != null) {
            sql.VALUES("cityid", "#{cityid,jdbcType=VARCHAR}");
        }
        
        if (record.getCityname() != null) {
            sql.VALUES("cityname", "#{cityname,jdbcType=VARCHAR}");
        }
        
        if (record.getCountyid() != null) {
            sql.VALUES("countyid", "#{countyid,jdbcType=VARCHAR}");
        }
        
        if (record.getCountyname() != null) {
            sql.VALUES("countyname", "#{countyname,jdbcType=VARCHAR}");
        }
        
        if (record.getRegionid() != null) {
            sql.VALUES("regionid", "#{regionid,jdbcType=VARCHAR}");
        }
        
        if (record.getRegionname() != null) {
            sql.VALUES("regionname", "#{regionname,jdbcType=VARCHAR}");
        }
        
        if (record.getLocaltionfixurl() != null) {
            sql.VALUES("localtionfixurl", "#{localtionfixurl,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            sql.VALUES("area", "#{area,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getMainshortname() != null) {
            sql.VALUES("mainshortname", "#{mainshortname,jdbcType=VARCHAR}");
        }
        
        if (record.getMainbeforename() != null) {
            sql.VALUES("mainbeforename", "#{mainbeforename,jdbcType=VARCHAR}");
        }
        
        if (record.getMainothername() != null) {
            sql.VALUES("mainothername", "#{mainothername,jdbcType=VARCHAR}");
        }
        
        if (record.getMainoriginofname() != null) {
            sql.VALUES("mainoriginofname", "#{mainoriginofname,jdbcType=VARCHAR}");
        }
        
        if (record.getMainmeanofname() != null) {
            sql.VALUES("mainmeanofname", "#{mainmeanofname,jdbcType=VARCHAR}");
        }
        
        if (record.getMainhistoryevolution() != null) {
            sql.VALUES("mainhistoryevolution", "#{mainhistoryevolution,jdbcType=VARCHAR}");
        }
        
        if (record.getMainlocalinfo() != null) {
            sql.VALUES("mainlocalinfo", "#{mainlocalinfo,jdbcType=VARCHAR}");
        }
        
        if (record.getMainsiteinfo() != null) {
            sql.VALUES("mainsiteinfo", "#{mainsiteinfo,jdbcType=VARCHAR}");
        }
        
        if (record.getMainarchitecture() != null) {
            sql.VALUES("mainarchitecture", "#{mainarchitecture,jdbcType=VARCHAR}");
        }
        
        if (record.getOtherinfo() != null) {
            sql.VALUES("otherinfo", "#{otherinfo,jdbcType=VARCHAR}");
        }
        
        if (record.getInfosource() != null) {
            sql.VALUES("infosource", "#{infosource,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Localdtl record) {
        SQL sql = new SQL();
        sql.UPDATE("localdtl");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getParentid() != null) {
            sql.SET("parentid = #{parentid,jdbcType=VARCHAR}");
        }
        
        if (record.getLocallevel() != null) {
            sql.SET("locallevel = #{locallevel,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getCountryid() != null) {
            sql.SET("countryid = #{countryid,jdbcType=VARCHAR}");
        }
        
        if (record.getCountryname() != null) {
            sql.SET("countryname = #{countryname,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceid() != null) {
            sql.SET("provinceid = #{provinceid,jdbcType=VARCHAR}");
        }
        
        if (record.getProvincename() != null) {
            sql.SET("provincename = #{provincename,jdbcType=VARCHAR}");
        }
        
        if (record.getCityid() != null) {
            sql.SET("cityid = #{cityid,jdbcType=VARCHAR}");
        }
        
        if (record.getCityname() != null) {
            sql.SET("cityname = #{cityname,jdbcType=VARCHAR}");
        }
        
        if (record.getCountyid() != null) {
            sql.SET("countyid = #{countyid,jdbcType=VARCHAR}");
        }
        
        if (record.getCountyname() != null) {
            sql.SET("countyname = #{countyname,jdbcType=VARCHAR}");
        }
        
        if (record.getRegionid() != null) {
            sql.SET("regionid = #{regionid,jdbcType=VARCHAR}");
        }
        
        if (record.getRegionname() != null) {
            sql.SET("regionname = #{regionname,jdbcType=VARCHAR}");
        }
        
        if (record.getLocaltionfixurl() != null) {
            sql.SET("localtionfixurl = #{localtionfixurl,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            sql.SET("area = #{area,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getMainshortname() != null) {
            sql.SET("mainshortname = #{mainshortname,jdbcType=VARCHAR}");
        }
        
        if (record.getMainbeforename() != null) {
            sql.SET("mainbeforename = #{mainbeforename,jdbcType=VARCHAR}");
        }
        
        if (record.getMainothername() != null) {
            sql.SET("mainothername = #{mainothername,jdbcType=VARCHAR}");
        }
        
        if (record.getMainoriginofname() != null) {
            sql.SET("mainoriginofname = #{mainoriginofname,jdbcType=VARCHAR}");
        }
        
        if (record.getMainmeanofname() != null) {
            sql.SET("mainmeanofname = #{mainmeanofname,jdbcType=VARCHAR}");
        }
        
        if (record.getMainhistoryevolution() != null) {
            sql.SET("mainhistoryevolution = #{mainhistoryevolution,jdbcType=VARCHAR}");
        }
        
        if (record.getMainlocalinfo() != null) {
            sql.SET("mainlocalinfo = #{mainlocalinfo,jdbcType=VARCHAR}");
        }
        
        if (record.getMainsiteinfo() != null) {
            sql.SET("mainsiteinfo = #{mainsiteinfo,jdbcType=VARCHAR}");
        }
        
        if (record.getMainarchitecture() != null) {
            sql.SET("mainarchitecture = #{mainarchitecture,jdbcType=VARCHAR}");
        }
        
        if (record.getOtherinfo() != null) {
            sql.SET("otherinfo = #{otherinfo,jdbcType=VARCHAR}");
        }
        
        if (record.getInfosource() != null) {
            sql.SET("infosource = #{infosource,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("locationid = #{locationid,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}