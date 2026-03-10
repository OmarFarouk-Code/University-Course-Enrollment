import java.util.ArrayList;

public class Instructor extends Person 
{
    private String specialization;
    private ArrayList <Course> assignedCourses;

    public Instructor ( String email , String name , String ID , String specialization )
    {
        super(email, name, ID);
        this.specialization = specialization;
        this.assignedCourses = new ArrayList<>();
    }

    public String getSpecialization()
    {
        return specialization;
    }

    public void setSpecialization( String specialization )
    {
        this.specialization = specialization;
    }

    public void assignCourse ( Course course )
    {
        this.assignedCourses.add( course );
    }

}
