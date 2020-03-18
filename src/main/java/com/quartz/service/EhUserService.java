package com.quartz.service;

import com.quartz.entity.EhUser;
import java.util.List;

/**
 * (EhUser)表服务接口
 *
 * @author makejava
 * @since 2020-02-13 18:52:18
 */
public interface EhUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EhUser queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EhUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param ehUser 实例对象
     * @return 实例对象
     */
    EhUser insert(EhUser ehUser);

    /**
     * 修改数据
     *
     * @param ehUser 实例对象
     * @return 实例对象
     */
    EhUser update(EhUser ehUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}