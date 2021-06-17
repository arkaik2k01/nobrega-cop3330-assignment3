package Assignments.ex42;

public class Person
{
    //Holds a first name, a last name, and a salary
    String name, lastName;
    double salary;

    public Person(String name, String lastName, double salary)
    {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
    }
    //Holds get and setter methods for retrieval of class variables

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }
}
