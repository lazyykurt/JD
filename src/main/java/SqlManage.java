import java.sql.*;

/**
 * @Author kurt
 * @Version 1.0
 * @Description sql相关语句
 * @Date 0:17 2023/3/1
 */

public class SqlManage {
    public Connection con;//数据库连接，从DriverManager的方法获得，用以产生执行sql的PreparedStatement

    public SqlManage() throws SQLException, ClassNotFoundException {
        //step1 加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("数据库驱动加载成功");
        //step2 连接数据库
        this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false", "root", "zwj229");
        System.out.println("数据库连接成功");
    }

    public void close() throws SQLException {
        this.con.close();
    }
}
