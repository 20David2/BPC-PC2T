package src.Animals;

import src.AbstractAnimal;

public class Cow extends AbstractAnimal{
    
    public Cow(byte age)
    {
        super(age);
    }
    @Override public String sound()
    {
        return "Mooo";
    }

}