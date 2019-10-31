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