package com.bange.commodity.mapper;

import com.bange.mall.entity.commodity.Classify;
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

import static com.bange.commodity.mapper.ClassifyDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface ClassifyMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, classifyName, parentId);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Classify> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Classify> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ClassifyResult")
    Optional<Classify> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ClassifyResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="classify_name", property="classifyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER)
    })
    List<Classify> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, classify, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, classify, completer);
    }

    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    default int insert(Classify record) {
        return MyBatis3Utils.insert(this::insert, record, classify, c ->
            c.map(id).toProperty("id")
            .map(classifyName).toProperty("classifyName")
            .map(parentId).toProperty("parentId")
        );
    }

    default int insertMultiple(Collection<Classify> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, classify, c ->
            c.map(id).toProperty("id")
            .map(classifyName).toProperty("classifyName")
            .map(parentId).toProperty("parentId")
        );
    }

    default int insertSelective(Classify record) {
        return MyBatis3Utils.insert(this::insert, record, classify, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(classifyName).toPropertyWhenPresent("classifyName", record::getClassifyName)
            .map(parentId).toPropertyWhenPresent("parentId", record::getParentId)
        );
    }

    default Optional<Classify> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, classify, completer);
    }

    default List<Classify> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, classify, completer);
    }

    default List<Classify> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, classify, completer);
    }

    default Optional<Classify> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, classify, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(Classify record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(classifyName).equalTo(record::getClassifyName)
                .set(parentId).equalTo(record::getParentId);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(Classify record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(classifyName).equalToWhenPresent(record::getClassifyName)
                .set(parentId).equalToWhenPresent(record::getParentId);
    }

    default int updateByPrimaryKey(Classify record) {
        return update(c ->
            c.set(classifyName).equalTo(record::getClassifyName)
            .set(parentId).equalTo(record::getParentId)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(Classify record) {
        return update(c ->
            c.set(classifyName).equalToWhenPresent(record::getClassifyName)
            .set(parentId).equalToWhenPresent(record::getParentId)
            .where(id, isEqualTo(record::getId))
        );
    }
}