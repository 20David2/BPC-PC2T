package src.Animals;

import src.AbstractAnimal;

public class Pig extends AbstractAnimal{
    
    public Pig(byte age)
    {
        super(age);
    }
    @Override public String sound()
    {
        return "Oink";
    }

}