import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 数据库连接池示例
 * 演示使用HikariCP连接池
 * 注意：需要添加HikariCP依赖
 */
public class ConnectionPoolDemo {
    public static void main(String[] args) {
        // 配置HikariCP连接池
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC");
        config.setUsername("root");
        config.setPassword("password");
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(30000);
        config.setConnectionTimeout(30000);
        config.setPoolName("MyHikariCP");
        
        // 创建数据源
        HikariDataSource dataSource = new HikariDataSource(config);
        
        // 使用连接池获取连接
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM students")) {
            
            System.out.println("连接池状态: " + dataSource.getHikariPoolMXBean().getTotalConnections() + " 个连接");
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", 姓名: " + name);
            }
            
            rs.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // 测试连接池性能
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < 100; i++) {
            try (Connection conn = dataSource.getConnection()) {
                // 只是获取连接然后释放
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("获取100次连接耗时: " + (endTime - startTime) + "ms");
        
        // 连接池配置信息
        System.out.println("\n连接池配置信息:");
        System.out.println("最大连接数: " + dataSource.getMaximumPoolSize());
        System.out.println("最小空闲连接: " + dataSource.getMinimumIdle());
        System.out.println("连接超时: " + dataSource.getConnectionTimeout() + "ms");
        System.out.println("空闲超时: " + dataSource.getIdleTimeout() + "ms");
        
        // 关闭数据源
        dataSource.close();
        System.out.println("连接池已关闭");
    }
} 