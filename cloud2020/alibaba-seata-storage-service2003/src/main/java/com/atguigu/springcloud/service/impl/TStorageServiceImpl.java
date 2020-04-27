package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.TStorage;
import com.atguigu.springcloud.dao.TStorageDao;
import com.atguigu.springcloud.service.TStorageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TStorage)表服务实现类
 *
 * @author makejava
 * @since 2020-04-17 16:27:33
 */
@Service(value = "tStorage")
@Transactional
public class TStorageServiceImpl implements TStorageService {

    @Resource
    private TStorageDao tStorageDao;

    @Override
    public TStorage queryById(String code) {
        return this.tStorageDao.queryById(code);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TStorage> queryAllByLimit(int offset, int limit) {
        return this.tStorageDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tStorage 实例对象
     * @return 实例对象
     */
    @Override
    public TStorage insert(TStorage tStorage) {
        this.tStorageDao.insert(tStorage);
        return tStorage;
    }

    /**
     * 修改数据
     *
     * @param code 商品码
     * @param count 购买商品数量
     */
    @Override
    public void update(String code, int count) {
        this.tStorageDao.update(code, count);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tStorageDao.deleteById(id) > 0;
    }
}