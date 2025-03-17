# Java 系列教程

该仓库为Java系列教程源码，包含Java基础、Java集合、多线程、IO流、网络编程、Spring全家桶等内容。如果该系列教程对您有帮助的话，还请点个star支持一下！⭐️

## 项目结构 
java-learning/
├── README.md
├── basic/
│   ├── 01_environment/
│   │   └── HelloWorld.java
│   ├── 02_datatype/
│   │   └── DataTypeDemo.java
│   ├── 03_operator/
│   │   └── OperatorDemo.java
│   ├── 04_control/
│   │   ├── IfDemo.java
│   │   ├── SwitchDemo.java
│   │   └── LoopDemo.java
│   ├── 05_array/
│   │   └── ArrayDemo.java
│   ├── 06_oop/
│   │   └── Student.java
│   ├── 07_inheritance/
│   │   ├── Person.java
│   │   ├── Student.java
│   │   ├── Teacher.java
│   │   └── PolymorphismDemo.java
│   └── 08_abstract/
│       ├── Shape.java
│       ├── Circle.java
│       ├── Rectangle.java
│       ├── Drawable.java
│       └── AbstractDemo.java
├── collection/
│   ├── 01_collection/
│   │   └── CollectionDemo.java
│   ├── 02_list/
│   │   └── ListDemo.java
│   ├── 03_set/
│   │   └── SetDemo.java
│   ├── 04_map/
│   │   └── MapDemo.java
│   ├── 05_iterator/
│   │   └── IteratorDemo.java
│   └── 06_collections/
│       └── CollectionsDemo.java
├── thread/
│   ├── 01_basics/
│   │   ├── ThreadDemo.java
│   │   └── ThreadLifecycleDemo.java
│   ├── 02_sync/
│   │   ├── SynchronizedDemo.java
│   │   └── DeadlockDemo.java
│   ├── 03_communication/
│   │   └── WaitNotifyDemo.java
│   ├── 04_threadpool/
│   │   └── ThreadPoolDemo.java
│   ├── 05_concurrent/
│   │   └── ConcurrentCollectionDemo.java
│   └── 06_lock/
│       └── LockDemo.java
├── io/
│   ├── 01_file/
│   │   └── FileDemo.java
│   ├── 02_bytestream/
│   │   └── ByteStreamDemo.java
│   ├── 03_charstream/
│   │   └── CharStreamDemo.java
│   ├── 04_buffered/
│   │   └── BufferedStreamDemo.java
│   ├── 05_convert/
│   │   └── ConvertStreamDemo.java
│   └── 06_serialization/
│       ├── Student.java
│       └── SerializationDemo.java
├── network/
│   ├── 01_basics/
│   │   └── InetAddressDemo.java
│   ├── 02_tcp/
│   │   ├── TCPServer.java
│   │   └── TCPClient.java
│   ├── 03_udp/
│   │   ├── UDPServer.java
│   │   └── UDPClient.java
│   └── 04_url/
│       └── URLDemo.java
├── database/
│   ├── 01_jdbc/
│   │   ├── JDBCDemo.java
│   │   ├── PreparedStatementDemo.java
│   │   └── TransactionDemo.java
│   ├── 02_connection_pool/
│   │   ├── ConnectionPoolDemo.java
│   │   └── DBCPDemo.java
│   └── 03_mysql/
│       └── MySQLDemo.java
└── spring/
    ├── 01_ioc/
    │   ├── model/
    │   │   ├── Student.java
    │   │   └── Teacher.java
    │   ├── config/
    │   │   └── AppConfig.java
    │   ├── SpringIoCDemo.java
    │   ├── JavaConfigDemo.java
    │   └── applicationContext.xml
    ├── 02_aop/
    │   ├── service/
    │   │   ├── Calculator.java
    │   │   └── CalculatorImpl.java
    │   ├── aspect/
    │   │   └── LoggingAspect.java
    │   ├── SpringAopDemo.java
    │   └── aop-context.xml
    ├── 03_mvc/
    │   ├── controller/
    │   │   └── HelloController.java
    │   ├── model/
    │   │   └── User.java
    │   ├── views/
    │   │   ├── hello.jsp
    │   │   ├── greeting.jsp
    │   │   ├── userForm.jsp
    │   │   └── userResult.jsp
    │   ├── web.xml
    │   └── spring-mvc.xml
    └── 04_boot/
        ├── controller/
        │   ├── HelloController.java
        │   └── UserController.java
        ├── model/
        │   └── User.java
        ├── repository/
        │   └── UserRepository.java
        ├── service/
        │   └── UserService.java
        ├── SpringBootDemoApplication.java
        └── application.properties

## 教程目录

### Java基础教程
1. [Java开发环境搭建](docs/basic/01.环境搭建.md)
2. [Java基本数据类型](docs/basic/02.基本数据类型.md)
3. [Java运算符](docs/basic/03.运算符.md)
4. [流程控制语句](docs/basic/04.流程控制.md)
5. [数组详解](docs/basic/05.数组.md)
6. [面向对象基础](docs/basic/06.面向对象基础.md)
7. [继承与多态](docs/basic/07.继承与多态.md)
8. [接口与抽象类](docs/basic/08.接口与抽象类.md)
9. [异常处理机制](docs/basic/09.异常处理.md)
10. [常用类库](docs/basic/10.常用类库.md)

### Java集合框架教程
1. [Collection集合体系](docs/collection/01.Collection体系.md)
2. [List集合详解](docs/collection/02.List集合.md)
3. [Set集合详解](docs/collection/03.Set集合.md)
4. [Map集合详解](docs/collection/04.Map集合.md)
5. [Iterator与增强for循环](docs/collection/05.迭代器.md)
6. [Collections工具类](docs/collection/06.Collections工具类.md)

### Java多线程教程
1. [线程基础](docs/thread/01.线程基础.md)
2. [线程同步](docs/thread/02.线程同步.md)
3. [线程通信](docs/thread/03.线程通信.md)
4. [线程池](docs/thread/04.线程池.md)
5. [并发集合](docs/thread/05.并发集合.md)
6. [锁机制](docs/thread/06.锁机制.md)

### Java IO流教程
1. [File类详解](docs/io/01.File类.md)
2. [字节流操作](docs/io/02.字节流.md)
3. [字符流操作](docs/io/03.字符流.md)
4. [缓冲流](docs/io/04.缓冲流.md)
5. [转换流](docs/io/05.转换流.md)
6. [序列化](docs/io/06.序列化.md)

### 网络编程教程
1. [网络编程基础](docs/network/01.网络编程基础.md)
2. [TCP编程](docs/network/02.TCP编程.md)
3. [UDP编程](docs/network/03.UDP编程.md)
4. [URL编程](docs/network/04.URL编程.md)

### 数据库操作教程
1. [JDBC基础](docs/database/01.JDBC基础.md)
2. [数据库连接池](docs/database/02.数据库连接池.md)
3. [MySQL实战](docs/database/03.MySQL实战.md)

### Spring框架教程
1. [Spring IOC](docs/spring/01.SpringIOC.md)
2. [Spring AOP](docs/spring/02.SpringAOP.md)
3. [Spring MVC](docs/spring/03.SpringMVC.md)
4. [Spring Boot](docs/spring/04.SpringBoot.md)

## 特点
- 每个知识点都配备完整的示例代码
- 代码中包含详细的注释说明
- 提供课后练习和实战项目
- 循序渐进的学习路线

## 使用说明
1. 克隆仓库到本地：
```bash
git clone https://github.com/your-username/java-learning.git
```

2. 使用IDE导入项目（推荐使用IntelliJ IDEA）

3. 按照教程目录顺序学习，每个知识点都有相应的代码示例

## 学习建议
1. 建议按照教程目录顺序循序渐进地学习
2. 每个示例代码都要自己动手敲一遍
3. 完成每个章节的课后练习
4. 多思考，多实践，举一反三

## 参与贡献
1. Fork 本仓库
2. 新建分支 
3. 提交代码
4. 新建 Pull Request


