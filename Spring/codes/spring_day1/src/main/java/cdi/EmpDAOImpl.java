package cdi;

import java.util.Date;
import java.util.List;

//构造注入
public class EmpDAOImpl implements EmpDAO {

    //构造注入语法
    private String name;
    private Integer age;
    private Date bir;
    private String[] qqs;

    private List<String> habbys;

    public EmpDAOImpl() {
    }

    public EmpDAOImpl(String name) {
        this.name = name;
    }


    public EmpDAOImpl(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public EmpDAOImpl(String name, Date bir) {
        this.name = name;
        this.bir = bir;
    }

    public EmpDAOImpl(Integer age) {
        this.age = age;
    }

    public EmpDAOImpl(Date bir) {
        this.bir = bir;
    }

    public EmpDAOImpl(String name, Integer age, Date bir) {
        this.name = name;
        this.age = age;
        this.bir = bir;
    }


    public EmpDAOImpl(String name, Integer age, Date bir, String[] qqs) {
        this.name = name;
        this.age = age;
        this.bir = bir;
        this.qqs = qqs;
    }

    public EmpDAOImpl(String name, Integer age, Date bir, String[] qqs, List<String> habbys) {
        this.name = name;
        this.age = age;
        this.bir = bir;
        this.qqs = qqs;
        this.habbys = habbys;
    }

    @Override
    public void save(String name) {
        System.out.println("name = " + name);
        System.out.println("this.name = " + this.name);
        System.out.println("this.age = "+ this.age);
        System.out.println("this.bir = " + this.bir);
        System.out.println("遍历数组 ========================");
        for (String qq : qqs) {
            System.out.println(qq);
        }
        System.out.println("遍历list集合 ====================");
        habbys.forEach(habby-> System.out.println("habby = " + habby));

    }
}
