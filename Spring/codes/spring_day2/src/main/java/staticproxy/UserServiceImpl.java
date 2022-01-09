package staticproxy;

//原始业务逻辑对象
public class UserServiceImpl implements UserService {


    //开启事务  处理业务  调用dao
    @Override
    public void save(String name) {
        System.out.println("处理业务逻辑,调用saveDAO~~~");
    }

    @Override
    public void delete(String id) {
        System.out.println("处理业务逻辑,调用DAO~~~");
    }

    @Override
    public void update() {
        System.out.println("处理业务逻辑,调用DAO~~~");
    }

    @Override
    public String findAll(String name) {
        System.out.println("处理业务逻辑,调用findAll DAO~~~");
        return name;
    }

    @Override
    public String findOne(String id) {
        System.out.println("处理业务逻辑,调用DAO~~~");
        return id;
    }
}
