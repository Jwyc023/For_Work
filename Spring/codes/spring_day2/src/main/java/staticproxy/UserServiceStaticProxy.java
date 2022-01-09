package staticproxy;

//注意: 这里为每一个业务层通过手动开发一个代理对象的过程称之为 静态代理对象
//代理对象: 保证原始功能不变情况下 完成业务逻辑中附加操作
public class UserServiceStaticProxy implements UserService {

    //依赖原始业务逻辑对象 //Target: 目标对象|被代理对象称之为目标对象 原始业务逻辑对象
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void save(String name) {
        try {
            System.out.println("开启事务");
            //调用原始业务逻辑对象的方法
            userService.save(name);
            System.out.println("提交事务");
        }catch (Exception e){
            System.out.println("回滚事务");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            System.out.println("开启事务");
            //?
            userService.delete(id);
            System.out.println("提交事务");
        }catch (Exception e){
            System.out.println("回滚事务");
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        try {
            System.out.println("开启事务");
            //?
            userService.update();
            System.out.println("提交事务");
        }catch (Exception e){
            System.out.println("回滚事务");
            e.printStackTrace();
        }
    }

    @Override
    public String findAll(String name) {
        try {
            System.out.println("开启事务");
            //?
            String all = userService.findAll(name);
            System.out.println("提交事务");
            return all;
        }catch (Exception e){
            System.out.println("回滚事务");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String findOne(String id) {
        try {
            System.out.println("开启事务");
            //?
            String one = userService.findOne(id);
            System.out.println("提交事务");
            return one;
        }catch (Exception e){
            System.out.println("回滚事务");
            e.printStackTrace();
        }
        return null;
    }
}
