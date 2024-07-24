package com.example.mybatis.mapper;

import com.example.mybatis.model.PersonDynamicSqlSupport;
import com.example.mybatis.model.PersonRecord;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mybatis.dynamic.sql.SqlBuilder.isIn;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;

@Mapper
public interface PersonMapper  {

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "PersonResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "first_name", property = "firstName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "last_name", property = "lastName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "birth_date", property = "birthDate", jdbcType = JdbcType.DATE),
            @Result(column = "employed", property = "employed", jdbcType = JdbcType.VARCHAR),
            @Result(column = "occupation", property = "occupation", jdbcType = JdbcType.VARCHAR),
            @Result(column = "address_id", property = "addressId", jdbcType = JdbcType.INTEGER)
    })
    List<PersonRecord> selectMany(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("PersonResult")
    Optional<PersonRecord> selectOne(SelectStatementProvider selectStatement);

    default List<PersonRecord> findPersonsByLastNames(Set<String> lastNames) {
        SelectDSLCompleter completer = c -> c
                .where(PersonDynamicSqlSupport.lastName, isIn(lastNames));

        QueryExpressionDSL<SelectModel> start = select(
                PersonDynamicSqlSupport.id, PersonDynamicSqlSupport.firstName,
                PersonDynamicSqlSupport.lastName, PersonDynamicSqlSupport.birthDate,
                PersonDynamicSqlSupport.employed, PersonDynamicSqlSupport.occupation,
                PersonDynamicSqlSupport.addressId
        ).from(PersonDynamicSqlSupport.person);

        // Use the custom selectList method
        return MyBatis3Utils.selectList(
                this::selectMany,  // Method reference to selectMany
                start,  // QueryExpressionDSL<SelectModel>
                completer  // SelectDSLCompleter
        );
    }

}
