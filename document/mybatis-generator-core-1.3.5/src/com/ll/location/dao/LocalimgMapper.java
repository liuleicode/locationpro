package com.ll.location.dao;

import com.ll.location.model.Localimg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface LocalimgMapper {
    @Delete({
        "delete from localimg",
        "where localimgid = #{localimgid,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long localimgid);

    @Insert({
        "insert into localimg (localimgid, imgtypeid, ",
        "imgtype, status, ",
        "imgurl)",
        "values (#{localimgid,jdbcType=BIGINT}, #{imgtypeid,jdbcType=VARCHAR}, ",
        "#{imgtype,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, ",
        "#{imgurl,jdbcType=VARCHAR})"
    })
    int insert(Localimg record);

    @InsertProvider(type=LocalimgSqlProvider.class, method="insertSelective")
    int insertSelective(Localimg record);

    @Select({
        "select",
        "localimgid, imgtypeid, imgtype, status, imgurl",
        "from localimg",
        "where localimgid = #{localimgid,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="localimgid", property="localimgid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="imgtypeid", property="imgtypeid", jdbcType=JdbcType.VARCHAR),
        @Result(column="imgtype", property="imgtype", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="imgurl", property="imgurl", jdbcType=JdbcType.VARCHAR)
    })
    Localimg selectByPrimaryKey(Long localimgid);

    @UpdateProvider(type=LocalimgSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Localimg record);

    @Update({
        "update localimg",
        "set imgtypeid = #{imgtypeid,jdbcType=VARCHAR},",
          "imgtype = #{imgtype,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "imgurl = #{imgurl,jdbcType=VARCHAR}",
        "where localimgid = #{localimgid,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Localimg record);
}