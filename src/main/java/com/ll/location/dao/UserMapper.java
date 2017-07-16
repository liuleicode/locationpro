package com.ll.location.dao;

import com.ll.location.model.User;
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
public interface UserMapper {
    @Delete({
        "delete from user",
        "where userid = #{userid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String userid);

    @Insert({
        "insert into user (userid, createtime, ",
        "lastsignintime)",
        "values (#{userid,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{lastsignintime,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @Select({
        "select",
        "userid, createtime, lastsignintime",
        "from user",
        "where userid = #{userid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="userid", property="userid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastsignintime", property="lastsignintime", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(String userid);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set createtime = #{createtime,jdbcType=TIMESTAMP},",
          "lastsignintime = #{lastsignintime,jdbcType=TIMESTAMP}",
        "where userid = #{userid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);
}