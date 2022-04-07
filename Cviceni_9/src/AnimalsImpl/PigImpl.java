package src.AnimalsImpl;

import src.*;

public class PigImpl implements Animal {
    
    private byte age;

    public PigImpl(byte age)
    {
        this.age = age;
    }
    @Override public String sound()
    {
        return "Oink";
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
