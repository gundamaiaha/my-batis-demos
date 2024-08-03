package com.example.mybatis_json_demo.typeHandler;

import com.example.mybatis_json_demo.model.PersonData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDataTypeHandler implements TypeHandler<PersonData> {

    private ObjectMapper objectMapper= new ObjectMapper();

    @SneakyThrows
    @Override
    public void setParameter(PreparedStatement ps, int i, PersonData parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("ps = " + ps);
        if(parameter == null){
            ps.setObject(i, null);
        } else {
            ps.setObject(i, objectMapper.writeValueAsString(parameter), jdbcType.TYPE_CODE);
        }

    }

    @Override
    public PersonData getResult(ResultSet rs, String columnName) throws SQLException {
        String json= rs.getString(columnName);
        return parseJson(json);
    }

    @Override
    public PersonData getResult(ResultSet rs, int columnIndex) throws SQLException {
        String json = rs.getString(columnIndex);
        return parseJson(json);
    }

    @Override
    public PersonData getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String json = cs.getString(columnIndex);
        return parseJson(json);
    }

    private PersonData parseJson(String json){
        try{
            return json==null ? null : objectMapper.readValue(json, PersonData.class);

        }catch (Exception e){
            throw new RuntimeException("Failed to parse JSON", e);
        }
    }
}
