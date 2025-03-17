import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * DBCP连接池示例
 * 演示使用Apache DBCP连接池
 * 注意：需要添加Apache DBCP依赖
 */
public class DBCPDemo {
    public static void main(String[] args) {
        // 创建DBCP数据源
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        
        // 配置连接池
        dataSource.setInitialSize(5);  // 初始连接数
        dataSource.setMaxTotal(10);    // 最大连接数
        dataSource.setMaxIdle(5);      // 最大空闲连接数
        dataSource.setMinIdle(2);      // 最小空闲连接数
        dataSource.setMaxWaitMillis(10000);  // 最大等待时间
        
        // 使用连接池获取连接
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            
            System.out.println("连接池状态: " + dataSource.getNumActive() + " 个活动连接, " +
                              dataSource.getNumIdle() + " 个空闲连接");
            
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM students");
            
            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("学生总数: " + count);
            }
            
            rs.close();
            
            // 测试连接池性能
            long startTime = System.currentTimeMillis();
            
            for (int i = 0; i < 100; i++) {
                try (Connection testConn = dataSource.getConnection()) {
                    // 只是获取连接然后释放
                }
            }
            
            long endTime = System.currentTimeMillis();
            System.out.println("获取100次连接耗时: " + (endTime - startTime) + "ms");
            
            // 连接池配置信息
            System.out.println("\n连接池配置信息:");
            System.out.println("初始连接数: " + dataSource.getInitialSize());
            System.out.println("最大连接数: " + dataSource.getMaxTotal());
            System.out.println("最大空闲连接: " + dataSource.getMaxIdle());
            System.out.println("最小空闲连接: " + dataSource.getMinIdle());
            System.out.println("最大等待时间: " + dataSource.getMaxWaitMillis() + "ms");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // 关闭数据源
        try {
            dataSource.close();
            System.out.println("连接池已关闭");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
} 