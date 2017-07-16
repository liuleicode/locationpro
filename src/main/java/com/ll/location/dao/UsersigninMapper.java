package com.ll.location.dao;

import com.ll.location.model.Usersignin;
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

import java.util.List;

@Repository
public interface UsersigninMapper {
    @Delete({
            "delete from usersignin",
            "where usersigninid = #{usersigninid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String usersigninid);

    @Insert({
            "insert into usersignin (usersigninid, userid, ",
            "localdtlid, createtime, ",
            "updatetime, signincount)",
            "values (#{usersigninid,jdbcType=VARCHAR}, #{userid,jdbcType=VARCHAR}, ",
            "#{localdtlid,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
            "#{updatetime,jdbcType=TIMESTAMP}, #{signincount,jdbcType=BIGINT})"
    })
    int insert(Usersignin record);

    @InsertProvider(type = UsersigninSqlProvider.class, method = "insertSelective")
    int insertSelective(Usersignin record);

    @Select({
            "select",
            "usersigninid, userid, localdtlid, createtime, updatetime, signincount",
            "from usersignin",
            "where usersigninid = #{usersigninid,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "usersigninid", property = "usersigninid", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "userid", property = "userid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "localdtlid", property = "localdtlid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "createtime", property = "createtime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "updatetime", property = "updatetime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "signincount", property = "signincount", jdbcType = JdbcType.BIGINT)
    })
    Usersignin selectByPrimaryKey(String usersigninid);

    @UpdateProvider(type = UsersigninSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Usersignin record);

    @Update({
            "update usersignin",
            "set userid = #{userid,jdbcType=VARCHAR},",
            "localdtlid = #{localdtlid,jdbcType=VARCHAR},",
            "createtime = #{createtime,jdbcType=TIMESTAMP},",
            "updatetime = #{updatetime,jdbcType=TIMESTAMP},",
            "signincount = #{signincount,jdbcType=BIGINT}",
            "where usersigninid = #{usersigninid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Usersignin record);


    @Select({
            "select",
            "usersigninid, userid, localdtlid, createtime, updatetime, signincount",
            "from usersignin",
            "where localdtlid = #{0} and userid=#{1}"
    })
    @Results({
            @Result(column = "usersigninid", property = "usersigninid", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "userid", property = "userid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "localdtlid", property = "localdtlid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "createtime", property = "createtime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "updatetime", property = "updatetime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "signincount", property = "signincount", jdbcType = JdbcType.BIGINT)
    })
    Usersignin selectByLocalidAndUserid(String localdtlid, String userid);

    List<Usersignin> selectByUseridByPage(String userid,Integer firstitem,Integer limititem);
}