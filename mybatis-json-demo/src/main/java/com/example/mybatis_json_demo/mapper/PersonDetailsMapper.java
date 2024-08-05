package com.example.mybatis_json_demo.mapper;

import com.example.mybatis_json_demo.model.PersonData;
import com.example.mybatis_json_demo.model.PersonDetails;
import com.example.mybatis_json_demo.typeHandler.PersonDataTypeHandler;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonDetailsMapper {

    @Select("SELECT * from person_details WHERE person_id = #{personId}")
    @Result(property = "personId", column = "person_id")
    @Result(property = "personData", column = "person_data", typeHandler = PersonDataTypeHandler.class)
    PersonDetails getPersonDetailsById(int personId);

    @Select("SELECT  person_data from person_details")
    List<String> getPersonDataById();





}
