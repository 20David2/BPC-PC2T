package src.Animals;

import src.AbstractAnimal;

public class Cat extends AbstractAnimal{
    
    public Cat(byte age)
    {
        super(age);
    }
    @Override public String sound()
    {
        return "Meow";
    }

}