# Spring_day4

## 1.Spring整合Struts2框架

### 1.引入依赖

> 需要引入:  `struts2`   `Spring` `Struts2-Spring-plugin`

```xml

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context-support</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aop</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-expression</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aspects</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-tx</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>

```

### 2.配置web.xml

> 1. `配置struts2核心控制器`

```xml
  <filter>
    <filter-name>struts2</filter-name>
    <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
  </filter>

  <filter-mapping>
    <filter-name>struts2</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
```

> 2. `配置spring启动工厂`

```xml
	<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
```

> 3. `加载工厂配置文件`

```xml
 <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:spring.xml</param-value>
  </context-param>
```

### 3.开发Action

```java
public class UserAction {
    public String findAll(){
        System.out.println("hello action~~ ");
        return Action.SUCCESS;
    }
}
```

### 4.工厂管理Action组件

```xml
  <!--管理Action-->
  <bean id="userAction" class="com.baizhi.action.UserAction"></bean>
```

### 5.配置struts.xml

```xml
<package name="user" extends="struts-default" namespace="/user">
  <action name="findAll"  class="userAction" method="findAll">
    <result name="success">/index.jsp</result>
  </action>
</package>
```

> `注意:``配置文件中书写的是工厂中管理的action的bean的id`

### 6.部署项目测试

---

## 2.Spring的注解式开发

### 1.开启注解扫描配置

```xml
	<!--开启注解扫描-->
  <context:component-scan base-package="com"/>
```

### 2.实例化相关注解

> `Spring自2.5版本以后提供了一些注解用来在使用spring时进行快速开发`

```markdown
# 1. @Component(value="beanid")
				修饰范围:    用在类上
				注解作用:    通用的创建实例的注解,用来创建当前这个类的实例
				value属性:	用来指定创建的对象在工厂中的唯一标识   如果不指定默认创建对象在工厂中的标识为类名首字母小写
				
# 2. @Repository 
				修饰范围:    用在类上
				注解作用:    @component的子类注解专用于DAO组件的创建,通常加在DAO组件上
				value属性:	用来指定创建的对象在工厂中的唯一标识   如果不指定默认创建对象在工厂中的标识为类名首字母小写

# 3. @Service
				修饰范围:    用在类上
				注解作用:    @component的子类注解专用于Service组件的创建,通常加在Service组件上
				value属性:	用来指定创建的对象在工厂中的唯一标识   如果不指定默认创建对象在工厂中的标识为类名首字母小写

# 4. @Controller
			  修饰范围:    用在类上
				注解作用:    @component的子类注解专用于Action组件的创建,通常加在Action组件上
				value属性:	用来指定创建的对象在工厂中的唯一标识   如果不指定默认创建对象在工厂中的标识为类名首字母小写
```

### 3.控制对象的创建次数的注解

```markdown
 # 1. @Scope(value="singleton|prototype")
 			  修饰范围:    用在类上
				注解作用:    用来控制这个实例在工厂中的创建次数
				value属性:	singleton为单例,prototype为多例   默认单例
```

### 4.注入相关的注解

```markdown
# 1. @Autowired(Spring提供)
				修饰范围:    用在成员变量或成员变量的GET/SET方法上
				注解作用:		 用来给类中成员变量赋值
				注入原则:    默认根据类型自动注入

# 2. @Resource(JAVAEE提供)
				修饰范围:    用在成员变量或成员变量的GET/SET方法上
				注解作用:		 用来给类中成员变量赋值
				注入原则:    默认根据名称自动注入名称找不到根据类型自动注入
```

### 5.控制事务的相关注解

```markdown
# 1. @Transactional
			  修饰范围:    用在类上主要用在业务层组件类上或者是方法上
				注解作用:		 用来给类中方法加入事务,当类上和方法上同时存在该注解时局部优先
				注解属性:    
							propagation  用来控制传播属性
							Isolation    用来控制隔离级别
							timeout      用来设置超时性
							rollback-for 用来设置什么异常回滚
							norollback-for 用来设置什么异常不会滚
							readonly     用来设置事务读写性
```

> `注意:如果要使用事务注解在配置文件中必须开启事务注解生效加入如下配置:`

```xml
    <tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>
```