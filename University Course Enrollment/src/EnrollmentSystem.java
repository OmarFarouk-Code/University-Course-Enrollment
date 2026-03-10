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

    public void registerStudent ( Student student )
    {
        allStudents.add(student);
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
            if ( student.getID() == ID )
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
            if ( course.getCourseCode() == code )
            {
                return course;
            }
        }
        return null;
    }

}
