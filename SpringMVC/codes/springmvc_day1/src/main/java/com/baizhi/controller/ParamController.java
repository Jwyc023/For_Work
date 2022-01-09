package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.vo.CollectionVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用来测试参数接收的Controller
 */
@Controller
@RequestMapping("param")
public class ParamController {


    /**
     * 用来测试集合类型参数接收
     *  list set map
     *  注意:
     *      springmvc不能直接通过形参列表方式收集集合类型参数
     *      如果要接收集合类型的参数必须将集合放入对象中接收才可以 推荐放入vo对象中接收集合类型
     *      vo = value object  值对象
     *      //%27 = '
     *      //map http://localhost:9999/springmvc_day1/param/test3?maps[%27aaa%27]=xiaochen&maps[%27bbb%27]=xiaohei&maps[%27ccc%27]=%E7%99%BE%E7%9F%A5%E6%95%99%E8%82%B2
     */
    @RequestMapping("test3")
    public String test3(CollectionVO collectionVO){
        System.out.println("====================");
        collectionVO.getMaps().forEach((k,v)-> System.out.println("k= " + k+" v= "+v));
        return "index";
    }

    /**
     * 用来测试数组类型参数接收
     * 接收数组: 将要接收数组类型直接声明为方法的形参即可
     * 注意: 保证请求参数多个参数key与声明数组变量名一致,springmvc会自动放入同一个数组中
     * url: http://localhost:9999/springmvc_day1/param/test2?qqs=111&qqs=222&qqs=333
     * form: checkbox
     *      input   type="checkbox"  name="qqs" value="看书"
     *      input   type="checkbox"  name="qqs" value="卖报"
     *      input   type="checkbox"  name="qqs" value="吃饭"
     *      input   type="checkbox"  name="qqs" value="打豆豆"
     *      ....
     */
    @RequestMapping("test2")
    public String test2(String[] qqs){
        for (String qq : qqs) {
            System.out.println(qq);
        }
        return "index";
    }

    /**
     * 用来测试对象类型的参数接收
     * 接收对象类型: 也是直接将要接收对象作为控制器方法参数声明
     * 注意:springmvc封装对象时直接根据传递参数key与对象中属性名一致自动封装对象
     * url: http://localhost:9999/springmvc_day1/param/test1?id=21&name=zhangsan&age=23&bir=2012/12/12
     * form:
     *      input  name="id"
     *      input  name="name"
     *      input  name="age"
     *      ....
     */
    @RequestMapping("test1")//1 user 2name 3 都赋值  4 不赋值
    public String test1(User user,String name){
        System.out.println("user = " + user);
        System.out.println("name = " + name);
        return "index";
    }

    /**
     * 用来测试零散类型参数接收
     *  路径: http://localhost:9999/springmvc_day1/param/test?name=xiaochen
     *  默认日期格式:  yyyy/MM/dd HH:mm:ss
     * @return
     */
    @RequestMapping("test")
    public String test(String name, Integer age, Double price, Boolean sex, Date bir){
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("price = " + price);
        System.out.println("sex = " + sex);
        System.out.println("bir = " + bir);
        return "index";
    }
}
