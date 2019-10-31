# 完成了利用JPA进行增删该查的操作

## 可能会遇到的问题：
- 日志包依赖冲突：SLF4J: Class path contains multiple SLF4J bindings.
   解决方法：修改xml文件
     ```xml
  <dependency>
        <groupId>net.sf.dozer</groupId>
        <artifactId>dozer</artifactId>
        <version>5.4.0</version>
        <exclusions>
          <exclusion>
            <artifactId>slf4j-log4j12</artifactId>
            <groupId>org.slf4j</groupId>
          </exclusion>
        </exclusions>
      </dependency>
      ```
- jar冲突： org.hibernate.cfg.annotations.EntityBinder.processComplementaryTableDefinitions(EntityBinder.java:1236)
   解决方法：删除lib/javax.persistence.jar 参考[博客](https://blog.csdn.net/AYZXX/article/details/90230203)

#JPA+atomikos实现分布式事务

利用atomikos配置多数据源的分布式事务,

在ServiceImp里人为制造一个除0错误，观察数据库是否提交

分布式的每一个配置源一般需要这么几样东西(资源管理器)：
- DataSource
- EntityManager
- EntityManagerFactory
- TranscationsManager

然后事务管理器来管理和调度每一个资源管理器。

另外，config下配置代码都是很形式化的东西，按需求改成自己的包名就可以了。