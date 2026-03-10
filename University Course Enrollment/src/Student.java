import java.util.ArrayList;

public class Student extends Person
{
   private ArrayList <Course> enrolledCourses;
   
   public Student ( String email , String name , String ID )
   {
        super(email, name, ID);
        this.enrolledCourses = new ArrayList <>();
   }

   public void addCourse( Course course )
   {
        enrolledCourses.add(course);
   }

   public void removeCourse ( Course course )
    {
        enrolledCourses.remove(course);
    }

   public ArrayList getEnrolledCourses()
   {
        return enrolledCourses;
   }

   public void displayDetails()
   {
        System.out.println( "ID : " + getID() );
        System.out.println( "Name : " + getName() );
        System.out.println( "Email : " + getEmail() ); 
        System.out.println( "Number of Courses Enrolled in : " + enrolledCourses.size() );  
   }

}
