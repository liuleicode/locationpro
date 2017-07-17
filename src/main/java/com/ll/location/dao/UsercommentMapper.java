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

import java.util.List;

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
            "commenttype, createtime)",
            "values (#{usercommentid,jdbcType=VARCHAR}, #{userid,jdbcType=VARCHAR}, ",
            "#{localdtlid,jdbcType=VARCHAR}, #{comment,jdbcType=VARCHAR}, ",
            "#{commenttype,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP})"
    })
    int insert(Usercomment record);

    @InsertProvider(type=UsercommentSqlProvider.class, method="insertSelective")
    int insertSelective(Usercomment record);

    @Select({
            "select",
            "usercommentid, userid, localdtlid, comment, commenttype, createtime",
            "from usercomment",
            "where usercommentid = #{usercommentid,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="usercommentid", property="usercommentid", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="userid", property="userid", jdbcType=JdbcType.VARCHAR),
            @Result(column="localdtlid", property="localdtlid", jdbcType=JdbcType.VARCHAR),
            @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
            @Result(column="commenttype", property="commenttype", jdbcType=JdbcType.VARCHAR),
            @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP)
    })
    Usercomment selectByPrimaryKey(String usercommentid);

    @UpdateProvider(type=UsercommentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Usercomment record);

    @Update({
            "update usercomment",
            "set userid = #{userid,jdbcType=VARCHAR},",
            "localdtlid = #{localdtlid,jdbcType=VARCHAR},",
            "comment = #{comment,jdbcType=VARCHAR},",
            "commenttype = #{commenttype,jdbcType=VARCHAR},",
            "createtime = #{createtime,jdbcType=TIMESTAMP}",
            "where usercommentid = #{usercommentid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Usercomment record);


    @Select({
            "select",
            "usercommentid, userid, localdtlid, comment, commenttype, createtime",
            "from usercomment",
            "where usercommentid in(select usercommentid where commenttype=#{2} order by creatime desc limit #{0},#{1} )"
    })
    @Results({
            @Result(column="usercommentid", property="usercommentid", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="userid", property="userid", jdbcType=JdbcType.VARCHAR),
            @Result(column="localdtlid", property="localdtlid", jdbcType=JdbcType.VARCHAR),
            @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
            @Result(column="commenttype", property="commenttype", jdbcType=JdbcType.VARCHAR),
            @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Usercomment> selectByCommenttypeByPage(Integer firstitem, Integer pagesize, String commenttype);
}