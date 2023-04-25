package com.bange.commodity.mapper;

import com.bange.mall.entity.commodity.Attribute;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.bange.commodity.mapper.AttributeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface AttributeMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, attrName);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Attribute> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Attribute> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AttributeResult")
    Optional<Attribute> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AttributeResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="attr_name", property="attrName", jdbcType=JdbcType.VARCHAR)
    })
    List<Attribute> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, attribute, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, attribute, completer);
    }

    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    default int insert(Attribute record) {
        return MyBatis3Utils.insert(this::insert, record, attribute, c ->
            c.map(id).toProperty("id")
            .map(attrName).toProperty("attrName")
        );
    }

    default int insertMultiple(Collection<Attribute> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, attribute, c ->
            c.map(id).toProperty("id")
            .map(attrName).toProperty("attrName")
        );
    }

    default int insertSelective(Attribute record) {
        return MyBatis3Utils.insert(this::insert, record, attribute, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(attrName).toPropertyWhenPresent("attrName", record::getAttrName)
        );
    }

    default Optional<Attribute> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, attribute, completer);
    }

    default List<Attribute> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, attribute, completer);
    }

    default List<Attribute> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, attribute, completer);
    }

    default Optional<Attribute> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, attribute, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(Attribute record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(attrName).equalTo(record::getAttrName);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(Attribute record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(attrName).equalToWhenPresent(record::getAttrName);
    }

    default int updateByPrimaryKey(Attribute record) {
        return update(c ->
            c.set(attrName).equalTo(record::getAttrName)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(Attribute record) {
        return update(c ->
            c.set(attrName).equalToWhenPresent(record::getAttrName)
            .where(id, isEqualTo(record::getId))
        );
    }
}