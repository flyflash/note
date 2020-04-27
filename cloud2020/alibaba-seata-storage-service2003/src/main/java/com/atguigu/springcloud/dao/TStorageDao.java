package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.TStorage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TStorage)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-17 16:27:32
 */

@Mapper
public interface TStorageDao {

    /**
     * @param code 商品码
     * @return TStorage 实例对象
     */
    TStorage queryById(@Param("code") String code);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TStorage> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tStorage 实例对象
     * @return 对象列表
     */
    List<TStorage> queryAll(TStorage tStorage);

    /**
     * 新增数据
     *
     * @param tStorage 实例对象
     * @return 影响行数
     */
    int insert(TStorage tStorage);

    /**
     * 修改数据
     *
     * @param code 商品码
     * @param count 扣减商品数量
     * @return 影响行数
     */
    int update(@Param("code") String code, @Param("count") int count);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}