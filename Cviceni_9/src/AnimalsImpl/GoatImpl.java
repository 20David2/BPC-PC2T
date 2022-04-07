package src.AnimalsImpl;

import src.*;

public class GoatImpl implements Animal {
    
    private byte age;

    public GoatImpl(byte age)
    {
        this.age = age;
    }
    @Override public String sound()
    {
        return "Maaah";
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
