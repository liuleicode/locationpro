package com.ll.location.dao;

import com.ll.location.model.Usercomment;
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
public interface UsercommentMapper {
    @Delete({
        "delete from usercomment",
        "where usercommentid = #{usercommentid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String usercommentid);

    @Insert({
        "insert into usercomment (usercommentid, userid, ",
        "localdtlid, comment, ",
        "commenttype)",
        "values (#{usercommentid,jdbcType=VARCHAR}, #{userid,jdbcType=VARCHAR}, ",
        "#{localdtlid,jdbcType=VARCHAR}, #{comment,jdbcType=VARCHAR}, ",
        "#{commenttype,jdbcType=VARCHAR})"
    })
    int insert(Usercomment record);

    @InsertProvider(type=UsercommentSqlProvider.class, method="insertSelective")
    int insertSelective(Usercomment record);

    @Select({
        "select",
        "usercommentid, userid, localdtlid, comment, commenttype",
        "from usercomment",
        "where usercommentid = #{usercommentid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="usercommentid", property="usercommentid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.VARCHAR),
        @Result(column="localdtlid", property="localdtlid", jdbcType=JdbcType.VARCHAR),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="commenttype", property="commenttype", jdbcType=JdbcType.VARCHAR)
    })
    Usercomment selectByPrimaryKey(String usercommentid);

    @UpdateProvider(type=UsercommentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Usercomment record);

    @Update({
        "update usercomment",
        "set userid = #{userid,jdbcType=VARCHAR},",
          "localdtlid = #{localdtlid,jdbcType=VARCHAR},",
          "comment = #{comment,jdbcType=VARCHAR},",
          "commenttype = #{commenttype,jdbcType=VARCHAR}",
        "where usercommentid = #{usercommentid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Usercomment record);
}