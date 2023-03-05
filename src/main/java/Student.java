import lombok.Data;

/**
 *
 * @Author kurt
 * @Version 1.0
 * @Description 表示student实体与MySQL的student
 * @Date 0:17 2023/3/1
 */

@Data
public class Student {
    private int id;//与student表得id对应
    private String name;//与student表得name对应
    private int age;//年龄与student表得age对应
    private int high;//身高与student表high对应

    //带id构造方法(查询时使用)
    public Student(int id, String name, int age, int high) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.high = high;
    }

    //不带id得构造方法(插入时候使用)
    public Student(String name, int age, int high) {
        this.name = name;
        this.age = age;
        this.high = high;
    }

    //toString()方法，控制台打印测试使用
    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", high=" + high +
                "}\n";
    }
}
