package src.Animals;

import src.AbstractAnimal;

public class Goat extends AbstractAnimal{
    
    public Goat(byte age)
    {
        super(age);
    }
    @Override public String sound()
    {
        return "Maaah";
    }

}