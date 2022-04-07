package src.Animals;

import src.AbstractAnimal;

public class Dog extends AbstractAnimal{
    
    public Dog(byte age)
    {
        super(age);
    }
    @Override public String sound()
    {
        return "Woof";
    }

}