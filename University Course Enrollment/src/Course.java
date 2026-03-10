import java.util.ArrayList;

public class Course 
{
    private String courseCode;
    private String title;
    private int maxCapacity;
    private Instructor instructor;
    private ArrayList<Student> enrolledStudents;

    public Course ( String courseCode , String title , int maxCapacity , Instructor instructor )
    {
        this.courseCode = courseCode;
        this.title = title;
        this.maxCapacity = maxCapacity;
        this.instructor = instructor;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseCode()
    {
        return courseCode;
    }

    public void setCourseCode( String courseCode )
    {
        this.courseCode = courseCode;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public Instructor getInstructor()
    {
        return instructor;
    }

    public void setInstructor( Instructor instructor )
    {
        this.instructor = instructor;
    }

    public boolean isFull()
    {
        return enrolledStudents.size() >= maxCapacity;
    }

    public void enrollStudent( Student student )
    {
       if (!isFull()) 
        {
            enrolledStudents.add(student);
            student.addCourse(this);
            System.out.println("[SUCCESS] " + student.getName() + " has been added to " + this.title);
        } 
        else 
        {
            System.out.println("[ERROR] Cannot enroll: " + this.title + " is at maximum capacity (" + maxCapacity + ")");
        }
    }

    public void dropStudent ( String ID )
    {
        for ( int i = 0 ; i < enrolledStudents.size() ; i++ )
        {
            if ( enrolledStudents.get(i).getID().equals(ID) )
            {
                Student studentToDrop = enrolledStudents.get(i);
                studentToDrop.removeCourse(this);
                enrolledStudents.remove(i);
                System.out.println("Student dropped successfully.");
                return;
            }
        }
    }

    public void displayAllStudents()
    {
        int i = 1;
        for ( Student student : enrolledStudents )
        {
            System.out.println( i + ".Name : " + student.getName() );
            i++;
        }
    }

}
