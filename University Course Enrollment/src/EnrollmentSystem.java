import java.util.ArrayList;

public class EnrollmentSystem 
{
    private ArrayList <Student> allStudents;
    private ArrayList <Course> allCourses;

    public EnrollmentSystem()
    {
        this.allStudents = new ArrayList<>();
        this.allCourses = new ArrayList<>();
    }

    public void registerStudent(Student student) 
    {
    
        if (findStudentById(student.getID()) == null)
        {
            allStudents.add(student);
            System.out.println("Student registered successfully.");
        } 
        else 
        {
            System.out.println("Error: A student with ID " + student.getID() + " already exists!");
        }
    }

    public void addCourse ( Course course )
    {
        allCourses.add(course);
    }
    public void removeCourse ( Course course )
    {
        allCourses.remove (course);
    }

    public Student findStudentById(String ID )
    {
        for ( Student student : allStudents )
        {
            if ( student.getID().equals(ID) )
            {
                return student;
            }
        }
        return null;
    }

    public Course findCourseByCode(String code)
    {
        for ( Course course : allCourses )
        {
            if ( course.getCourseCode().equals(code) )
            {
                return course;
            }
        }
        return null;
    }

}
