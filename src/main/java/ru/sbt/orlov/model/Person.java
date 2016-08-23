package ru.sbt.orlov.model;

/**
 *
 * @author r.orlov
 */
public class Person {
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Person copyPersonWithNewAge(Person person,int age) {
        return new Person(person.getName(),age);
    }

    @Override
    public String toString() {
        if (name.equals("Applejack")) {
            return name+" is a horse (or whiskey)";
        }
        return name+" just normal people"; 
    }
    
    
}
