package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {

    //保存用户
    int save(User user);

    //更新方法
    int update(User user);

    //删除方法
    int delete(Integer id);

    //查询所有方法
    List<User> queryAll();

    //根据id查询一个用户
    User queryById(Integer id);

    //模糊查询
    List<User> queryLikeByName(String name);

    //分页查询 //参数1:起始位置  参数2:每页显示记录数
    List<User> queryByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    //查询总条数
    Long queryTotalCounts();

}
