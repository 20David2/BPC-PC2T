package src;

public class Employee implements Comparable<Employee>{
    
    private String nickname;
    private String email;
    private char[] password;

    enum EmployeeType{

        ACTIVE,
        INACTIVE,
        DELETED
    }

    public Employee(String nickname, String email, char[] password)
    {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public String getNickname()
    {
        return this.nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public char[] getPassword()
    {
        return this.password;
    }

    public void setPassword(char[] password)
    {
        this.password = password;
    }

    public String toString()
    {
        return this.nickname;
    }

    public int compareTo(Employee employee)
    {
        return this.email.compareTo(employee.email);
    }

}
