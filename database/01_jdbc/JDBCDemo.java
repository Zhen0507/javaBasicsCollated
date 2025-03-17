import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC基础示例
 * 演示JDBC的基本操作
 */
public class JDBCDemo {
    // JDBC驱动和数据库URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
    
    // 数据库用户名和密码 - 实际应用中应该从配置文件读取
    private static final String USER = "root";
    private static final String PASS = "password";
    
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            // 注册JDBC驱动
            Class.forName(JDBC_DRIVER);
            
            // 打开连接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // 创建Statement对象
            stmt = conn.createStatement();
            
            // 创建表
            String createTableSQL = "CREATE TABLE IF NOT EXISTS students " +
                                   "(id INT PRIMARY KEY AUTO_INCREMENT, " +
                                   " name VARCHAR(50), " +
                                   " age INT, " +
                                   " grade VARCHAR(20))";
            stmt.executeUpdate(createTableSQL);
            System.out.println("表已创建");
            
            // 插入数据
            String insertSQL = "INSERT INTO students (name, age, grade) " +
                              "VALUES ('张三', 20, '大一')";
            stmt.executeUpdate(insertSQL);
            System.out.println("数据已插入");
            
            // 查询数据
            String selectSQL = "SELECT id, name, age, grade FROM students";
            rs = stmt.executeQuery(selectSQL);
            
            // 处理结果集
            System.out.println("查询结果:");
            while(rs.next()) {
                // 通过字段索引获取
                int id = rs.getInt(1);
                // 通过字段名获取
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String grade = rs.getString("grade");
                
                // 输出数据
                System.out.println("ID: " + id + ", 姓名: " + name + 
                                  ", 年龄: " + age + ", 年级: " + grade);
            }
            
            // 更新数据
            String updateSQL = "UPDATE students SET age = 21 WHERE name = '张三'";
            int rowsAffected = stmt.executeUpdate(updateSQL);
            System.out.println("更新了 " + rowsAffected + " 行数据");
            
            // 删除数据
            String deleteSQL = "DELETE FROM students WHERE name = '张三'";
            rowsAffected = stmt.executeUpdate(deleteSQL);
            System.out.println("删除了 " + rowsAffected + " 行数据");
            
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
                if(stmt != null) stmt.close();
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
} 