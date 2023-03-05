import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class Text {

    @Test
    public void funStudent() {
        Student student1 = new Student("xiaomi", 22, 180);
        Student student2 = new Student("donging", 21, 165);
        System.out.println(student1.getAge());
        System.out.println(student2);
    }

    @Test
    public void insertTest() throws ClassNotFoundException, SQLException {
        SqlOperation sqlOperation = new SqlOperation();
        sqlOperation.insertStudent(new Student("biogas", 22, 180));
        sqlOperation.insertStudent(new Student("began", 21, 165));
        sqlOperation.insertStudent(new Student("dodo", 20, 160));
    }

    public void insertStudentsTest() throws SQLException, ClassNotFoundException {
        SqlOperation sqlOperation = new SqlOperation();
        Student[] students =new Student[5];
        for(int i=0;i<students.length;i++)
        {
            students[i]=new Student("路人"+i,12,156);
        }
        sqlOperation.insertStudents(students);
    }

    @Test
    public void selectTest() throws SQLException, ClassNotFoundException {
        SqlOperation sqlOperation = new SqlOperation();
        List<Student> list = sqlOperation.getAllStudent();
        System.out.println(list.toString());
    }

    @Test
    public void updateTest() throws SQLException, ClassNotFoundException {
        SqlOperation sqlOperation = new SqlOperation();
        sqlOperation.update();
    }

    @Test
    public  void deleteTest() throws SQLException, ClassNotFoundException {
        SqlOperation sqlOperation = new SqlOperation();
        sqlOperation.deleteById(1);
    }
}
