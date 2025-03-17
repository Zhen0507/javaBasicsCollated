import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 事务处理示例
 * 演示JDBC事务的使用
 */
public class TransactionDemo {
    // JDBC驱动和数据库URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
    
    // 数据库用户名和密码
    private static final String USER = "root";
    private static final String PASS = "password";
    
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // 注册JDBC驱动
            Class.forName(JDBC_DRIVER);
            
            // 打开连接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // 关闭自动提交
            conn.setAutoCommit(false);
            
            try {
                // 创建账户表
                String createTableSQL = "CREATE TABLE IF NOT EXISTS accounts " +
                                       "(id INT PRIMARY KEY AUTO_INCREMENT, " +
                                       " name VARCHAR(50), " +
                                       " balance DECIMAL(10,2))";
                pstmt = conn.prepareStatement(createTableSQL);
                pstmt.executeUpdate();
                
                // 插入测试数据
                String insertSQL = "INSERT INTO accounts (name, balance) VALUES (?, ?)";
                pstmt = conn.prepareStatement(insertSQL);
                
                pstmt.setString(1, "张三");
                pstmt.setDouble(2, 1000.00);
                pstmt.executeUpdate();
                
                pstmt.setString(1, "李四");
                pstmt.setDouble(2, 1000.00);
                pstmt.executeUpdate();
                
                // 转账操作
                // 1. 从张三账户减去500
                String updateSQL1 = "UPDATE accounts SET balance = balance - ? WHERE name = ?";
                pstmt = conn.prepareStatement(updateSQL1);
                pstmt.setDouble(1, 500.00);
                pstmt.setString(2, "张三");
                pstmt.executeUpdate();
                
                // 模拟异常
                // if (true) throw new SQLException("模拟异常");
                
                // 2. 向李四账户增加500
                String updateSQL2 = "UPDATE accounts SET balance = balance + ? WHERE name = ?";
                pstmt = conn.prepareStatement(updateSQL2);
                pstmt.setDouble(1, 500.00);
                pstmt.setString(2, "李四");
                pstmt.executeUpdate();
                
                // 提交事务
                conn.commit();
                System.out.println("事务提交成功");
                
            } catch (SQLException e) {
                // 发生异常，回滚事务
                System.out.println("发生异常，回滚事务");
                conn.rollback();
                e.printStackTrace();
            } finally {
                // 恢复自动提交
                conn.setAutoCommit(true);
            }
            
            // 查询结果
            String selectSQL = "SELECT * FROM accounts";
            pstmt = conn.prepareStatement(selectSQL);
            rs = pstmt.executeQuery();
            
            System.out.println("账户信息:");
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");
                
                System.out.println("ID: " + id + ", 姓名: " + name + 
                                  ", 余额: " + balance);
            }
            
            // 事务隔离级别
            System.out.println("\n当前事务隔离级别: " + getIsolationLevelName(conn.getTransactionIsolation()));
            
            // 设置事务隔离级别
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            System.out.println("设置事务隔离级别为: " + getIsolationLevelName(conn.getTransactionIsolation()));
            
        } catch(SQLException se) {
            // 处理JDBC错误
            se.printStackTrace();
        } catch(Exception e) {
            // 处理Class.forName错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if(rs != null) rs.close();
            } catch(SQLException se2) {
                // 不处理
            }
            try {
                if(pstmt != null) pstmt.close();
            } catch(SQLException se2) {
                // 不处理
            }
            try {
                if(conn != null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }
    
    // 获取事务隔离级别名称
    private static String getIsolationLevelName(int level) {
        switch (level) {
            case Connection.TRANSACTION_NONE:
                return "TRANSACTION_NONE";
            case Connection.TRANSACTION_READ_UNCOMMITTED:
                return "TRANSACTION_READ_UNCOMMITTED";
            case Connection.TRANSACTION_READ_COMMITTED:
                return "TRANSACTION_READ_COMMITTED";
            case Connection.TRANSACTION_REPEATABLE_READ:
                return "TRANSACTION_REPEATABLE_READ";
            case Connection.TRANSACTION_SERIALIZABLE:
                return "TRANSACTION_SERIALIZABLE";
            default:
                return "UNKNOWN";
        }
    }
} 