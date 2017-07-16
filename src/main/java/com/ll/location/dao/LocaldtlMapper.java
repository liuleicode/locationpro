package com.ll.location.dao;

import com.ll.location.model.Localdtl;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;


@Repository
public interface LocaldtlMapper {
    @Delete({
        "delete from localdtl",
        "where locationid = #{locationid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String locationid);

    @Insert({
        "insert into localdtl (locationid, name, ",
        "parentid, locallevel, ",
        "status, countryid, ",
        "countryname, provinceid, ",
        "provincename, cityid, ",
        "cityname, countyid, ",
        "countyname, regionid, ",
        "regionname, localtionfixurl, ",
        "area, type, mainshortname, ",
        "mainbeforename, mainothername, ",
        "mainoriginofname, mainmeanofname, ",
        "mainhistoryevolution, mainlocalinfo, ",
        "mainsiteinfo, mainarchitecture, ",
        "otherinfo, infosource)",
        "values (#{locationid,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{parentid,jdbcType=VARCHAR}, #{locallevel,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{countryid,jdbcType=VARCHAR}, ",
        "#{countryname,jdbcType=VARCHAR}, #{provinceid,jdbcType=VARCHAR}, ",
        "#{provincename,jdbcType=VARCHAR}, #{cityid,jdbcType=VARCHAR}, ",
        "#{cityname,jdbcType=VARCHAR}, #{countyid,jdbcType=VARCHAR}, ",
        "#{countyname,jdbcType=VARCHAR}, #{regionid,jdbcType=VARCHAR}, ",
        "#{regionname,jdbcType=VARCHAR}, #{localtionfixurl,jdbcType=VARCHAR}, ",
        "#{area,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, #{mainshortname,jdbcType=VARCHAR}, ",
        "#{mainbeforename,jdbcType=VARCHAR}, #{mainothername,jdbcType=VARCHAR}, ",
        "#{mainoriginofname,jdbcType=VARCHAR}, #{mainmeanofname,jdbcType=VARCHAR}, ",
        "#{mainhistoryevolution,jdbcType=VARCHAR}, #{mainlocalinfo,jdbcType=VARCHAR}, ",
        "#{mainsiteinfo,jdbcType=VARCHAR}, #{mainarchitecture,jdbcType=VARCHAR}, ",
        "#{otherinfo,jdbcType=VARCHAR}, #{infosource,jdbcType=VARCHAR})"
    })
    int insert(Localdtl record);

    @InsertProvider(type=LocaldtlSqlProvider.class, method="insertSelective")
    int insertSelective(Localdtl record);

    @Select({
        "select",
        "locationid, name, parentid, locallevel, status, countryid, countryname, provinceid, ",
        "provincename, cityid, cityname, countyid, countyname, regionid, regionname, ",
        "localtionfixurl, area, type, mainshortname, mainbeforename, mainothername, mainoriginofname, ",
        "mainmeanofname, mainhistoryevolution, mainlocalinfo, mainsiteinfo, mainarchitecture, ",
        "otherinfo, infosource",
        "from localdtl",
        "where locationid = #{locationid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="locationid", property="locationid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="parentid", property="parentid", jdbcType=JdbcType.VARCHAR),
        @Result(column="locallevel", property="locallevel", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="countryid", property="countryid", jdbcType=JdbcType.VARCHAR),
        @Result(column="countryname", property="countryname", jdbcType=JdbcType.VARCHAR),
        @Result(column="provinceid", property="provinceid", jdbcType=JdbcType.VARCHAR),
        @Result(column="provincename", property="provincename", jdbcType=JdbcType.VARCHAR),
        @Result(column="cityid", property="cityid", jdbcType=JdbcType.VARCHAR),
        @Result(column="cityname", property="cityname", jdbcType=JdbcType.VARCHAR),
        @Result(column="countyid", property="countyid", jdbcType=JdbcType.VARCHAR),
        @Result(column="countyname", property="countyname", jdbcType=JdbcType.VARCHAR),
        @Result(column="regionid", property="regionid", jdbcType=JdbcType.VARCHAR),
        @Result(column="regionname", property="regionname", jdbcType=JdbcType.VARCHAR),
        @Result(column="localtionfixurl", property="localtionfixurl", jdbcType=JdbcType.VARCHAR),
        @Result(column="area", property="area", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="mainshortname", property="mainshortname", jdbcType=JdbcType.VARCHAR),
        @Result(column="mainbeforename", property="mainbeforename", jdbcType=JdbcType.VARCHAR),
        @Result(column="mainothername", property="mainothername", jdbcType=JdbcType.VARCHAR),
        @Result(column="mainoriginofname", property="mainoriginofname", jdbcType=JdbcType.VARCHAR),
        @Result(column="mainmeanofname", property="mainmeanofname", jdbcType=JdbcType.VARCHAR),
        @Result(column="mainhistoryevolution", property="mainhistoryevolution", jdbcType=JdbcType.VARCHAR),
        @Result(column="mainlocalinfo", property="mainlocalinfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="mainsiteinfo", property="mainsiteinfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="mainarchitecture", property="mainarchitecture", jdbcType=JdbcType.VARCHAR),
        @Result(column="otherinfo", property="otherinfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="infosource", property="infosource", jdbcType=JdbcType.VARCHAR)
    })
    Localdtl selectByPrimaryKey(String locationid);

    @UpdateProvider(type=LocaldtlSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Localdtl record);

    @Update({
        "update localdtl",
        "set name = #{name,jdbcType=VARCHAR},",
          "parentid = #{parentid,jdbcType=VARCHAR},",
          "locallevel = #{locallevel,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "countryid = #{countryid,jdbcType=VARCHAR},",
          "countryname = #{countryname,jdbcType=VARCHAR},",
          "provinceid = #{provinceid,jdbcType=VARCHAR},",
          "provincename = #{provincename,jdbcType=VARCHAR},",
          "cityid = #{cityid,jdbcType=VARCHAR},",
          "cityname = #{cityname,jdbcType=VARCHAR},",
          "countyid = #{countyid,jdbcType=VARCHAR},",
          "countyname = #{countyname,jdbcType=VARCHAR},",
          "regionid = #{regionid,jdbcType=VARCHAR},",
          "regionname = #{regionname,jdbcType=VARCHAR},",
          "localtionfixurl = #{localtionfixurl,jdbcType=VARCHAR},",
          "area = #{area,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "mainshortname = #{mainshortname,jdbcType=VARCHAR},",
          "mainbeforename = #{mainbeforename,jdbcType=VARCHAR},",
          "mainothername = #{mainothername,jdbcType=VARCHAR},",
          "mainoriginofname = #{mainoriginofname,jdbcType=VARCHAR},",
          "mainmeanofname = #{mainmeanofname,jdbcType=VARCHAR},",
          "mainhistoryevolution = #{mainhistoryevolution,jdbcType=VARCHAR},",
          "mainlocalinfo = #{mainlocalinfo,jdbcType=VARCHAR},",
          "mainsiteinfo = #{mainsiteinfo,jdbcType=VARCHAR},",
          "mainarchitecture = #{mainarchitecture,jdbcType=VARCHAR},",
          "otherinfo = #{otherinfo,jdbcType=VARCHAR},",
          "infosource = #{infosource,jdbcType=VARCHAR}",
        "where locationid = #{locationid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Localdtl record);
}