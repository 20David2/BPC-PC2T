package src;

public abstract class AbstractAnimal {
 
    protected abstract String sound();

    private byte age;

    public byte getAge()
    {
        return this.age;
    }

    public void setAge(byte age)
    {
        this.age = age;
    }

    public AbstractAnimal(byte age)
    {
        this.age = age;
    }
    
    public String toString()
    {
        return sound();
    }
}
