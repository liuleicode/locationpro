package com.ll.location.dao;

import com.ll.location.model.Usersignindtl;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UsersignindtlMapper {
    @Delete({
        "delete from usersignindtl",
        "where usersignindtlid = #{usersignindtlid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String usersignindtlid);

    @Insert({
        "insert into usersignindtl (usersignindtlid, usersignid, ",
        "userid, localdtlid, ",
        "localdtlname, createtime, ",
        "updatetime)",
        "values (#{usersignindtlid,jdbcType=VARCHAR}, #{usersignid,jdbcType=VARCHAR}, ",
        "#{userid,jdbcType=VARCHAR}, #{localdtlid,jdbcType=VARCHAR}, ",
        "#{localdtlname,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{updatetime,jdbcType=TIMESTAMP})"
    })
    int insert(Usersignindtl record);

    @InsertProvider(type=UsersignindtlSqlProvider.class, method="insertSelective")
    int insertSelective(Usersignindtl record);

    @Select({
        "select",
        "usersignindtlid, usersignid, userid, localdtlid, localdtlname, createtime, updatetime",
        "from usersignindtl",
        "where usersignindtlid = #{usersignindtlid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="usersignindtlid", property="usersignindtlid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="usersignid", property="usersignid", jdbcType=JdbcType.VARCHAR),
        @Result(column="userid", property="userid", jdbcType=JdbcType.VARCHAR),
        @Result(column="localdtlid", property="localdtlid", jdbcType=JdbcType.VARCHAR),
        @Result(column="localdtlname", property="localdtlname", jdbcType=JdbcType.VARCHAR),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updatetime", property="updatetime", jdbcType=JdbcType.TIMESTAMP)
    })
    Usersignindtl selectByPrimaryKey(String usersignindtlid);

    @UpdateProvider(type=UsersignindtlSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Usersignindtl record);

    @Update({
        "update usersignindtl",
        "set usersignid = #{usersignid,jdbcType=VARCHAR},",
          "userid = #{userid,jdbcType=VARCHAR},",
          "localdtlid = #{localdtlid,jdbcType=VARCHAR},",
          "localdtlname = #{localdtlname,jdbcType=VARCHAR},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "updatetime = #{updatetime,jdbcType=TIMESTAMP}",
        "where usersignindtlid = #{usersignindtlid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Usersignindtl record);
}