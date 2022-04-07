package src.AnimalsImpl;

import src.*;

public class CowImpl implements Animal {
    
    private byte age;

    public CowImpl(byte age)
    {
        this.age = age;
    }
    @Override public String sound()
    {
        return "Mooo";
    }

    public byte getAge()
    {
        return this.age;
    }

    public void setAge(byte age)
    {
        this.age = age;
    }

    public String toString()
    {
        return sound();
    }
}
