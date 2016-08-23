package ru.sbt.orlov.model;

/**
 *
 * @author r.orlov
 */
public class FatPerson extends Person {
    
    Double howFat = Double.POSITIVE_INFINITY;
    
    public FatPerson(String name, Integer age) {
        super(name, age);
    }

    public Double getHowFat() {
        return howFat;
    }

    public void setHowFat(Double howFat) {
        this.howFat = howFat;
    }

    @Override
    public Person copyPersonWithNewAge(Person person,int age) {
        return new FatPerson(name, age);
    }
    
    

    @Override
    public String toString() {
        return name+" has problems with weight";
    }
    
    
}
