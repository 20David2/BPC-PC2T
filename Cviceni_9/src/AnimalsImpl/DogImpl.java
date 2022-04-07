package src.AnimalsImpl;

import src.*;

public class DogImpl implements Animal {
    
    private byte age;

    public DogImpl(byte age)
    {
        this.age = age;
    }
    @Override public String sound()
    {
        return "Woof";
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
