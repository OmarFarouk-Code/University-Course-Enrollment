import java.util.ArrayList;

public class EnrollmentSystem 
{
    private ArrayList <Student> allStudents;
    private ArrayList <Course> allCourses;
    private ArrayList <Instructor> allInstructors;

    public EnrollmentSystem()
    {
        this.allStudents = new ArrayList<>();
        this.allCourses = new ArrayList<>();
        this.allInstructors = new ArrayList<>();
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

    public void registerInstructor(Instructor instructor) 
    {
        allInstructors.add(instructor);
    }

    // Add a search method for instructors
    public Instructor findInstructorById(String ID) 
    {
        for (Instructor instructor : allInstructors) 
        {
            if (instructor.getID().equals(ID)) 
            {
                return instructor;
            }
        }
        return null;
    }

    public void initializedDatabase() 
    {
        // Create specific Instructors
        Instructor drAhmed = new Instructor("ahmed.cse@asu.edu.eg", "Dr. Ahmed", "INS101", "Software Engineering");
        Instructor drLaila = new Instructor("laila.math@asu.edu.eg", "Dr. Laila", "INS102", "Mathematics");
        Instructor drHassan = new Instructor("hassan.phy@asu.edu.eg", "Dr. Hassan", "INS103", "Physics");

        // Register them in the system
        this.registerInstructor(drAhmed);
        this.registerInstructor(drLaila);
        this.registerInstructor(drHassan);

        // Assign them to your specific courses
        this.addCourse(new Course("CSE142", "Introduction to Software Engineering", 40, drAhmed));
        this.addCourse(new Course("CSE241", "Object-Oriented Computer Programming", 40, drAhmed));
        this.addCourse(new Course("PHM112", "Mathematics (2)", 60, drLaila));
        this.addCourse(new Course("PHM113", "Probability and Statistics", 60, drLaila));
        this.addCourse(new Course("PHM121", "Vibration and Waves", 50, drHassan));
        this.addCourse(new Course("PHM123", "Introduction to Physical Electronics", 50, drHassan));
        
        System.out.println("Instructors and Courses initialized for database.");
    }

}
