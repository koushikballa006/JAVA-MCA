abstract class EducationalProduct {
    final int id;
    String name;
    double price;

    public EducationalProduct(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract void display();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Course extends EducationalProduct {
    String instructor;
    int duration; // Duration of the course in weeks

    public Course(int id, String name, double price, String instructor, int duration) {
        super(id, name, price);
        this.instructor = instructor;
        this.duration = duration;
    }

    public void display() {
        System.out.println("Course ID: " + id);
        System.out.println("Course Name: " + name);
        System.out.println("Course Price: " + price);
        System.out.println("Course Instructor: " + instructor);
        System.out.println("Course Duration: " + duration + " weeks");
    }

    public String getInstructor() {
        return instructor;
    }

    public int getDuration() {
        return duration;
    }
}

class StudyMaterial extends EducationalProduct {
    String type; // e.g., book, PDF, video lectures

    public StudyMaterial(int id, String name, double price, String type) {
        super(id, name, price);
        this.type = type;
    }

    public void display() {
        System.out.println("Material ID: " + id);
        System.out.println("Material Name: " + name);
        System.out.println("Material Price: " + price);
        System.out.println("Material Type: " + type);
    }

    public String getType() {
        return type;
    }
}

public class EducationalPlatform {
    public static void main(String[] args) {
        Course course1 = new Course(101, "Java Programming", 199.99, "John Doe", 8);
        course1.display();
        StudyMaterial material1 = new StudyMaterial(201, "Mathematics Textbook", 49.99, "Book");
        material1.display();
    }
}
