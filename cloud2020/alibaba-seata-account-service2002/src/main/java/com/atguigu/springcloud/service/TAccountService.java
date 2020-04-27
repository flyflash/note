package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.TAccount;
import java.util.List;

/**
 * (TAccount)表服务接口
 *
 * @author makejava
 * @since 2020-04-17 16:23:11
 */
public interface TAccountService {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 用户id
     * @return 实例对象
     */
    TAccount queryById(String uid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TAccount> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tAccount 实例对象
     * @return 实例对象
     */
    TAccount insert(TAccount tAccount);

    /**
     * 修改数据
     *
     * @return 实例对象
     */
    TAccount update(String uid, double amount);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}