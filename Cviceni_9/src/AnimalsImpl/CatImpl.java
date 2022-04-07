package src.AnimalsImpl;

import src.*;

public class CatImpl implements Animal {
    
    private byte age;

    public CatImpl(byte age)
    {
        this.age = age;
    }
    @Override public String sound()
    {
        return "Meow";
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
