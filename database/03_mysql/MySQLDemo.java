import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MySQL实战示例
 * 演示MySQL特有功能
 */
public class MySQLDemo {
    // 数据库连接信息
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
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
            
            // 创建产品表
            String createTableSQL = "CREATE TABLE IF NOT EXISTS products " +
                                   "(id INT PRIMARY KEY AUTO_INCREMENT, " +
                                   " name VARCHAR(100), " +
                                   " price DECIMAL(10,2), " +
                                   " category VARCHAR(50), " +
                                   " created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
            pstmt = conn.prepareStatement(createTableSQL);
            pstmt.executeUpdate();
            
            // 插入数据
            String insertSQL = "INSERT INTO products (name, price, category) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);
            
            // 批量插入产品
            String[][] products = {
                {"iPhone 13", "6999.00", "手机"},
                {"MacBook Pro", "12999.00", "电脑"},
                {"iPad Pro", "6299.00", "平板"},
                {"AirPods", "1299.00", "配件"},
                {"Apple Watch", "2999.00", "配件"}
            };
            
            for (String[] product : products) {
                pstmt.setString(1, product[0]);
                pstmt.setDouble(2, Double.parseDouble(product[1]));
                pstmt.setString(3, product[2]);
                pstmt.addBatch();
            }
            
            pstmt.executeBatch();
            System.out.println("产品数据已插入");
            
            // 使用聚合函数
            String aggregateSQL = "SELECT category, COUNT(*) as count, AVG(price) as avg_price, " +
                                 "MAX(price) as max_price, MIN(price) as min_price " +
                                 "FROM products GROUP BY category";
            pstmt = conn.prepareStatement(aggregateSQL);
            rs = pstmt.executeQuery();
            
            System.out.println("\n产品类别统计:");
            while (rs.next()) {
                String category = rs.getString("category");
                int count = rs.getInt("count");
                double avgPrice = rs.getDouble("avg_price");
                double maxPrice = rs.getDouble("max_price");
                double minPrice = rs.getDouble("min_price");
                
                System.out.println("类别: " + category);
                System.out.println("  数量: " + count);
                System.out.println("  平均价格: " + avgPrice);
                System.out.println("  最高价格: " + maxPrice);
                System.out.println("  最低价格: " + minPrice);
            }
            
            // 使用LIMIT和ORDER BY
            String limitSQL = "SELECT * FROM products ORDER BY price DESC LIMIT 3";
            pstmt = conn.prepareStatement(limitSQL);
            rs = pstmt.executeQuery();
            
            System.out.println("\n价格最高的3个产品:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                
                System.out.println("ID: " + id + ", 名称: " + name + 
                                  ", 价格: " + price + ", 类别: " + category);
            }
            
            // 使用JOIN
            // 创建订单表
            String createOrderTableSQL = "CREATE TABLE IF NOT EXISTS orders " +
                                        "(id INT PRIMARY KEY AUTO_INCREMENT, " +
                                        " product_id INT, " +
                                        " quantity INT, " +
                                        " order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                                        " FOREIGN KEY (product_id) REFERENCES products(id))";
            pstmt = conn.prepareStatement(createOrderTableSQL);
            pstmt.executeUpdate();
            
            // 插入订单数据
            String insertOrderSQL = "INSERT INTO orders (product_id, quantity) VALUES (?, ?)";
            pstmt = conn.prepareStatement(insertOrderSQL);
            
            // 添加一些订单
            int[][] orders = {
                {1, 2},
                {2, 1},
                {3, 3},
                {4, 5}
            };
            
            for (int[] order : orders) {
                pstmt.setInt(1, order[0]);
                pstmt.setInt(2, order[1]);
                pstmt.executeUpdate();
            }
            
            // 使用JOIN查询
            String joinSQL = "SELECT o.id as order_id, p.name as product_name, " +
                            "o.quantity, p.price, (o.quantity * p.price) as total " +
                            "FROM orders o " +
                            "JOIN products p ON o.product_id = p.id";
            pstmt = conn.prepareStatement(joinSQL);
            rs = pstmt.executeQuery();
            
            System.out.println("\n订单信息:");
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                String productName = rs.getString("product_name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                double total = rs.getDouble("total");
                
                System.out.println("订单ID: " + orderId);
                System.out.println("  产品: " + productName);
                System.out.println("  数量: " + quantity);
                System.out.println("  单价: " + price);
                System.out.println("  总价: " + total);
            }
            
            // 使用子查询
            String subquerySQL = "SELECT * FROM products WHERE price > " +
                                "(SELECT AVG(price) FROM products)";
            pstmt = conn.prepareStatement(subquerySQL);
            rs = pstmt.executeQuery();
            
            System.out.println("\n价格高于平均价格的产品:");
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                
                System.out.println(name + ": " + price);
            }
            
            // 使用事务和存储过程
            System.out.println("\n事务和存储过程示例请参考TransactionDemo.java");
            
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