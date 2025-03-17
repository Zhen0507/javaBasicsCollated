import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PreparedStatement示例
 * 演示PreparedStatement的使用
 */
public class PreparedStatementDemo {
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
            
            // 创建表（如果不存在）
            String createTableSQL = "CREATE TABLE IF NOT EXISTS students " +
                                   "(id INT PRIMARY KEY AUTO_INCREMENT, " +
                                   " name VARCHAR(50), " +
                                   " age INT, " +
                                   " grade VARCHAR(20))";
            pstmt = conn.prepareStatement(createTableSQL);
            pstmt.executeUpdate();
            
            // 插入数据
            String insertSQL = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);
            
            // 设置参数
            pstmt.setString(1, "李四");
            pstmt.setInt(2, 22);
            pstmt.setString(3, "大二");
            
            // 执行插入
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("插入了 " + rowsAffected + " 行数据");
            
            // 批量插入
            pstmt.setString(1, "王五");
            pstmt.setInt(2, 21);
            pstmt.setString(3, "大一");
            pstmt.addBatch();
            
            pstmt.setString(1, "赵六");
            pstmt.setInt(2, 23);
            pstmt.setString(3, "大三");
            pstmt.addBatch();
            
            int[] batchResults = pstmt.executeBatch();
            System.out.println("批量插入了 " + batchResults.length + " 行数据");
            
            // 查询数据
            String selectSQL = "SELECT * FROM students WHERE age > ?";
            pstmt = conn.prepareStatement(selectSQL);
            pstmt.setInt(1, 20);
            
            rs = pstmt.executeQuery();
            
            // 处理结果集
            System.out.println("查询结果:");
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String grade = rs.getString("grade");
                
                System.out.println("ID: " + id + ", 姓名: " + name + 
                                  ", 年龄: " + age + ", 年级: " + grade);
            }
            
            // 更新数据
            String updateSQL = "UPDATE students SET grade = ? WHERE name = ?";
            pstmt = conn.prepareStatement(updateSQL);
            pstmt.setString(1, "研究生");
            pstmt.setString(2, "李四");
            
            rowsAffected = pstmt.executeUpdate();
            System.out.println("更新了 " + rowsAffected + " 行数据");
            
            // 删除数据
            String deleteSQL = "DELETE FROM students WHERE name = ?";
            pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setString(1, "赵六");
            
            rowsAffected = pstmt.executeUpdate();
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
} 