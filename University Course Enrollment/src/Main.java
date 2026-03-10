import java.util.Scanner;

public class Main 
{
    public static void main ( String args[] )
    {
        EnrollmentSystem enrollmentSystem = new EnrollmentSystem();
        Scanner input = new Scanner(System.in);
        Instructor defaultInstructor = new Instructor("dr.smith@university.edu", "Dr. Smith", "INS001", "Computer Science");

        while (true)
        {
            System.out.println("\n--- University Enrollment System ---");
            System.out.println("1. Register Student");
            System.out.println("2. Create Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Drop Student from Course");
            System.out.println("5. View Student Details");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();
            input.nextLine();
            while ( choice < 0 || choice > 5)
            {
                System.out.println("Invalid Choice, Please Enter a Valid Choice :");
                choice = input.nextInt();
                input.nextLine();
            }

            switch (choice)
            {
                case 1 :
                    System.out.print("Enter Student Name: ");
                    String sName = input.nextLine();
                    System.out.print("Enter Student ID: ");
                    String sID = input.nextLine();
                    System.out.print("Enter Student Email: ");
                    String sEmail = input.nextLine();
                    enrollmentSystem.registerStudent(new Student(sEmail, sName, sID));
                    System.out.println("Student registered successfully.");
                    break;

                case 2 :
                    System.out.print("Enter Course Title: ");
                    String cTitle = input.nextLine();
                    System.out.print("Enter Course Code: ");
                    String cCode = input.nextLine();
                    System.out.print("Enter Max Capacity: ");
                    int cCap = input.nextInt();
                    input.nextLine();
                    enrollmentSystem.addCourse(new Course(cCode, cTitle, cCap, defaultInstructor));
                    System.out.println("Course created successfully.");
                    break;

                case 3 :
                    System.out.print("Enter Student ID: ");
                    String enrollSID = input.nextLine();
                    System.out.print("Enter Course Code: ");
                    String enrollCCode = input.nextLine();
                    Student student = enrollmentSystem.findStudentById(enrollSID);
                    Course course = enrollmentSystem.findCourseByCode(enrollCCode);
                    if (student != null && course != null) {
                        course.enrollStudent(student);
                    } else {
                        System.out.println("Error: Student or Course not found.");
                    }
                    break;

                case 4 : 
                    System.out.print("Enter Student ID: ");
                    String dropSID = input.nextLine();
                    System.out.print("Enter Course Code: ");
                    String dropCCode = input.nextLine();
                    Student dstudent = enrollmentSystem.findStudentById(dropSID);
                    Course dcourse = enrollmentSystem.findCourseByCode(dropCCode);
                    if (dstudent != null && dcourse != null) 
                    {
                        dcourse.dropStudent(dropSID);
                    } 
                    else 
                    {
                        System.out.println("Error: Student or Course not found.");
                    }
                    break;
                
                case 5 :
                    System.out.print("Enter Student ID: ");
                    String viewSID = input.nextLine();
                    Student viewStudent = enrollmentSystem.findStudentById(viewSID);
                    
                    if (viewStudent != null) {
                        viewStudent.displayDetails();
                    } else {
                        System.out.println("Error: Student not found.");
                    }
                    break;

                case 0 :
                    System.out.println("Exiting system...");
                    input.close();
                    System.exit(0);

                default :
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
