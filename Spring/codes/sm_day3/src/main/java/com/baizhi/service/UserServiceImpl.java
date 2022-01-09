package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements  UserService {

    private UserDAO userDAO;

    //生成事务管理器
//    private PlatformTransactionManager platformTransactionManager;
//    public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
//        this.platformTransactionManager = platformTransactionManager;
//    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void save(User user) {
        //处理业务
        user.setId(UUID.randomUUID().toString());
        //调用业务
        userDAO.save(user);  //userDAO 方法小事务 方便测试DAO  当外部存在事务时 小事务自动消失
        //int i = 1/0;
//        //创建事务配置对象
//        TransactionDefinition transactionDefinition =  new DefaultTransactionDefinition();
//        //获取事务状态
//        TransactionStatus status = platformTransactionManager.getTransaction(transactionDefinition);
//        try {
//            //处理业务
//            user.setId(UUID.randomUUID().toString());
//            //调用业务
//            userDAO.save(user);  //userDAO 方法小事务 方便测试DAO  当外部存在事务时 小事务自动消失
//            platformTransactionManager.commit(status);
//        }catch (Exception e){
//            e.printStackTrace();
//            platformTransactionManager.rollback(status);
//        }
    }



    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }
}
