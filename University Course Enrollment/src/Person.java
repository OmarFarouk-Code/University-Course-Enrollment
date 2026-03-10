public class Person
{
    private String email;
    private String name;
    private String ID;

    public Person ( String email , String name , String ID )
    {
        this.email = email;
        this.name = name;
        this.ID = ID;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getID()
    {
        return ID;
    }

    public void setID( String ID )
    {
        this.ID = ID;
    }

    public void displayDetails()
    {
        System.out.println( "ID : " + ID );
        System.out.println( "Name : " + name );
        System.out.println( "Email : " + email);   
    }

}
