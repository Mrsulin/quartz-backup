package com.quartz.dao;

import com.quartz.entity.EhUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (EhUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-13 18:52:13
 */
@Mapper
public interface EhUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EhUser queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EhUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param ehUser 实例对象
     * @return 对象列表
     */
    List<EhUser> queryAll(EhUser ehUser);

    /**
     * 新增数据
     *
     * @param ehUser 实例对象
     * @return 影响行数
     */
    int insert(EhUser ehUser);

    /**
     * 修改数据
     *
     * @param ehUser 实例对象
     * @return 影响行数
     */
    int update(EhUser ehUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}