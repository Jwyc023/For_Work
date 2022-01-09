package setdi;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ClazzServiceImpl implements ClazzService {

    //需要组件 依赖组件  //set方式注入
    private ClazzDAO clazzDAO;
    //SET注入语法
    private String name;
    private Integer age;
    private Boolean sex;
    private Double price;
    private Float counts;
    private Date bir;

    //注入数组
    private String[] qqs;
    private ClazzDAO[] clazzDAOS;

    //注入list集合
    private List<String> habbys;
    private List<ClazzDAO> clazzDAOList;

    //注入map
    private Map<String,String> maps;

    //properties
    private Properties properties;


    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setClazzDAOList(List<ClazzDAO> clazzDAOList) {
        this.clazzDAOList = clazzDAOList;
    }

    public void setHabbys(List<String> habbys) {
        this.habbys = habbys;
    }

    public void setClazzDAOS(ClazzDAO[] clazzDAOS) {
        this.clazzDAOS = clazzDAOS;
    }

    public void setQqs(String[] qqs) {
        this.qqs = qqs;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCounts(Float counts) {
        this.counts = counts;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    //提供set方法
    public void setClazzDAO(ClazzDAO clazzDAO) {
        this.clazzDAO = clazzDAO;
    }

    @Override
    public void save(String name) {
        System.out.println("Service name = " + name);
        clazzDAO.save(name);
        System.out.println("Name : "+ this.name);
        System.out.println("age = " + age);
        System.out.println("sex = " + sex);
        System.out.println("price = " + price);
        System.out.println("counts = " + counts);
        System.out.println("bir = " + bir);
        System.out.println("=========遍历数组==========");
        for (String qq : qqs) {
            System.out.println(qq);
        }
        for (ClazzDAO dao : clazzDAOS) {
            System.out.println(dao);
        }
        System.out.println("=========遍历集合==========");
        habbys.forEach(habby-> System.out.println("habby = " + habby));
        clazzDAOList.forEach(clazzDAO-> System.out.println("clazzDAO = " + clazzDAO));
        maps.forEach((key,value)-> System.out.println("key:" + key+"  value:"+value));
        System.out.println("=========遍历properties集合==========");
        properties.forEach((key,value)->System.out.println("key: "+key+" value:"+value));
    }
}
