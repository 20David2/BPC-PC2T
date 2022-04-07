package src;

public class Secretarian extends Employee
{
    private int age;    

    public Secretarian(String nickname, String email, char[] password, int age)
    {
		super(nickname, email, password);
        this.age = age;
	}

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
