package com.example.my_batis.mapper;

import com.example.my_batis.model.TODO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ToDoMapper {
    @Select("select * from TBL_TODO")
    List<TODO> findAll();

    @Select("SELECT * FROM TBL_TODO WHERE id = #{id}")
    TODO findById(@Param("id") Long id);

    @Delete("DELETE FROM TBL_TODO WHERE id = #{id}")
    int deleteById(@Param("id") Long id);

    @Insert("INSERT INTO TBL_TODO(id, title, body) " +
            " VALUES (#{id}, #{title}, #{body})")
    int createNew(TODO item);

    @Update("Update TBL_TODO set title=#{title}, " +
            " body=#{body} where id=#{id}")
    int update(TODO item);
}
