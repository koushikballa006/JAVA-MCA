import com.educationalplatform.courses.Course;
import com.educationalplatform.users.Student;

public class Main {
    public static void main(String[] args) {
        Course mathCourse = new Course("Mathematics", 101);
        Student student1 = new Student("Alice", 1);
        student1.enrollCourse(mathCourse.getCourseId());
        student1.viewCourseProgress(mathCourse.getCourseId());
    }
}
