package com.ll.location.dao;

import com.ll.location.model.Local;
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
public interface LocalMapper {
    @Delete({
        "delete from local",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into local (id, localno, ",
        "localname, province, ",
        "city, street, origin, ",
        "meaning, evolution, ",
        "position, story, ",
        "image)",
        "values (#{id,jdbcType=BIGINT}, #{localno,jdbcType=VARCHAR}, ",
        "#{localname,jdbcType=VARCHAR}, #{province,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{street,jdbcType=VARCHAR}, #{origin,jdbcType=VARCHAR}, ",
        "#{meaning,jdbcType=VARCHAR}, #{evolution,jdbcType=VARCHAR}, ",
        "#{position,jdbcType=VARCHAR}, #{story,jdbcType=VARCHAR}, ",
        "#{image,jdbcType=VARCHAR})"
    })
    int insert(Local record);

    @InsertProvider(type=LocalSqlProvider.class, method="insertSelective")
    int insertSelective(Local record);

    @Select({
        "select",
        "id, localno, localname, province, city, street, origin, meaning, evolution, ",
        "position, story, image",
        "from local",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="localno", property="localno", jdbcType=JdbcType.VARCHAR),
        @Result(column="localname", property="localname", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="street", property="street", jdbcType=JdbcType.VARCHAR),
        @Result(column="origin", property="origin", jdbcType=JdbcType.VARCHAR),
        @Result(column="meaning", property="meaning", jdbcType=JdbcType.VARCHAR),
        @Result(column="evolution", property="evolution", jdbcType=JdbcType.VARCHAR),
        @Result(column="position", property="position", jdbcType=JdbcType.VARCHAR),
        @Result(column="story", property="story", jdbcType=JdbcType.VARCHAR),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR)
    })
    Local selectByPrimaryKey(Long id);

    @UpdateProvider(type=LocalSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Local record);

    @Update({
        "update local",
        "set localno = #{localno,jdbcType=VARCHAR},",
          "localname = #{localname,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "street = #{street,jdbcType=VARCHAR},",
          "origin = #{origin,jdbcType=VARCHAR},",
          "meaning = #{meaning,jdbcType=VARCHAR},",
          "evolution = #{evolution,jdbcType=VARCHAR},",
          "position = #{position,jdbcType=VARCHAR},",
          "story = #{story,jdbcType=VARCHAR},",
          "image = #{image,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Local record);



    @Select({
            "select",
            "id, localno, localname, province, city, street, origin, meaning, evolution, ",
            "position, story, image",
            "from local",
            "where localno = #{localno,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="localno", property="localno", jdbcType=JdbcType.VARCHAR),
            @Result(column="localname", property="localname", jdbcType=JdbcType.VARCHAR),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
            @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
            @Result(column="street", property="street", jdbcType=JdbcType.VARCHAR),
            @Result(column="origin", property="origin", jdbcType=JdbcType.VARCHAR),
            @Result(column="meaning", property="meaning", jdbcType=JdbcType.VARCHAR),
            @Result(column="evolution", property="evolution", jdbcType=JdbcType.VARCHAR),
            @Result(column="position", property="position", jdbcType=JdbcType.VARCHAR),
            @Result(column="story", property="story", jdbcType=JdbcType.VARCHAR),
            @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR)
    })
    Local selectByLocalno(String localno);
}