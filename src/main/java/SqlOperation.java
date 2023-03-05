import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlOperation {
    SqlManage sqlManage = new SqlManage();
    Connection con = sqlManage.con;

    public SqlOperation() throws SQLException, ClassNotFoundException {
    }

    public void insertStudent(Student student) throws SQLException {
        //创建sql语句
        String sql = "insert into students(name,age,high) value(?,?,?)";
        //PreparedStatement能够对SQL语句进行预编译，这样防止了   SQL注入 提高了安全性。
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, student.getName());
        ps.setInt(2, student.getAge());
        ps.setInt(3, student.getHigh());
        //执行 sql 因为这里插入操作就不对结处理
        ps.executeUpdate();
        ps.close();
    }

    public void insertStudents(Student[] students) throws SQLException {
        con.setAutoCommit(false);//不自动提交
        String sql="insert into student(name,age,high)value(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        for(int i=0;i<students.length;i++)
        {
            ps.setString(1,students[i].getName());
            ps.setInt(2,students[i].getAge());
            ps.setInt(3,students[i].getHigh());
            ps.addBatch();
            if(i%1000==0)
            {
                ps.executeBatch();
            }
        }
        ps.executeBatch();
        sqlManage.con.commit();
        ps.close();
    }

    public List<Student> getAllStudent() throws SQLException {
        List<Student> list = new ArrayList<>();//返回的结果
        String sql = "select * from students where age < 21";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();//结果集
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            int high = resultSet.getInt(4);
            list.add(new Student(id, name, age, high));
        }
        ps.close();
        return list;
    }

    public void update() throws SQLException {
        String sql = "update student set name='xiaoming' where age=12";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
    }

    public  void deleteById(int id) throws SQLException {
        String sql = "delete from student where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
        ps.close();
    }
}
