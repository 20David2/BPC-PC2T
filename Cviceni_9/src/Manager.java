package src;

import java.util.*; // import everything including List and ArrayList

public class Manager <T extends Employee> extends Employee 
{
 
    private List<Employee> listOfEmployees = new ArrayList<Employee>();
    private List<T> listOfRelationships = new ArrayList<T>();

    public Manager(String nickname, String email, char[] password)
    {
		super(nickname, email, password);
	}

    public List<Employee> getListOfEmployees()
    {
        return listOfEmployees;
    }

    public void setListOfEmployees(List<Employee> listOfEmployees)
    {
        this.listOfEmployees = listOfEmployees;
    }

    public void setListOfRelationships(List<T> listOfRelationships)
    {
        this.listOfRelationships = listOfRelationships;
    }

    public List<T> getListOfRelationships()
    {
        return listOfRelationships;
    }

    public void addEmployee(Employee employee)
    {
        listOfEmployees.add(employee);
    }

    public void addRelationship(T relationship)
    {
        listOfRelationships.add(relationship);
    }


    
}
