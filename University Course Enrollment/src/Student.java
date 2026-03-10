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

   public ArrayList<Course> getEnrolledCourses()
   {
        return enrolledCourses;
   }

   public void displayDetails()
   {
        System.out.println("\n+----------------------------------------+");
        System.out.println("|            STUDENT PROFILE             |");
        System.out.println("+----------------------------------------+");
        System.out.printf("| %-12s : %-23s |\n", "Full Name", getName());
        System.out.printf("| %-12s : %-23s |\n", "Student ID", getID());
        System.out.printf("| %-12s : %-23s |\n", "Email", getEmail());
        System.out.println("+----------------------------------------+");
        System.out.printf("| %-12s : %-23d |\n", "Enrollments", enrolledCourses.size());
        System.out.println("+----------------------------------------+");
   }

}
