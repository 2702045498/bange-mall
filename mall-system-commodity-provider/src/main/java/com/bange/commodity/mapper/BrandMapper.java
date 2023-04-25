package com.bange.commodity.mapper;

import com.bange.mall.entity.commodity.Brand;
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

import static com.bange.commodity.mapper.BrandDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface BrandMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, brandName);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Brand> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Brand> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BrandResult")
    Optional<Brand> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BrandResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="brand_name", property="brandName", jdbcType=JdbcType.VARCHAR)
    })
    List<Brand> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, brand, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, brand, completer);
    }

    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    default int insert(Brand record) {
        return MyBatis3Utils.insert(this::insert, record, brand, c ->
            c.map(id).toProperty("id")
            .map(brandName).toProperty("brandName")
        );
    }

    default int insertMultiple(Collection<Brand> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, brand, c ->
            c.map(id).toProperty("id")
            .map(brandName).toProperty("brandName")
        );
    }

    default int insertSelective(Brand record) {
        return MyBatis3Utils.insert(this::insert, record, brand, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(brandName).toPropertyWhenPresent("brandName", record::getBrandName)
        );
    }

    default Optional<Brand> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, brand, completer);
    }

    default List<Brand> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, brand, completer);
    }

    default List<Brand> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, brand, completer);
    }

    default Optional<Brand> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, brand, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(Brand record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(brandName).equalTo(record::getBrandName);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(Brand record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(brandName).equalToWhenPresent(record::getBrandName);
    }

    default int updateByPrimaryKey(Brand record) {
        return update(c ->
            c.set(brandName).equalTo(record::getBrandName)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(Brand record) {
        return update(c ->
            c.set(brandName).equalToWhenPresent(record::getBrandName)
            .where(id, isEqualTo(record::getId))
        );
    }
}