package ru.sbt.orlov.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.sbt.orlov.model.FatPerson;
import ru.sbt.orlov.model.Person;

/**
 *
 * @author r.orlov
 */
public class StreamsTest {
    
    List<Person> personList;
    
    public StreamsTest() {
    }
    
    @Before
    public void setUp() {
        List<Person> personModifableList = new ArrayList<>();
        personModifableList.add(new FatPerson("Bob", 21));
        personModifableList.add(new Person("Masha", 12));
        personModifableList.add(new FatPerson("Olga", 35));
        personModifableList.add(new FatPerson("Taras", 56));
        personModifableList.add(new Person("Anna", 23));
        personModifableList.add(new FatPerson("StrangeCreature", 101));
        personModifableList.add(new FatPerson("Piter", 26));
        personModifableList.add(new Person("Applejack", 31));
        personModifableList.add(new FatPerson("Ivan", 16));
        personModifableList.add(new FatPerson("Vovan", 41));
        personModifableList.add(new Person("Nastya", 26));
        personModifableList.add(new Person("Kali", 23));
        personList = Collections.unmodifiableList(personModifableList);
    }
    
    @Test
    public void testSomeMethod() {
        try {
            Map<String,String> map = Streams.of(personList)
                    .filter(person -> person.getName().length()<=4)
                    .transform(person -> person.copyPersonWithNewAge(person,person.getAge()+20))
                    .toMap( p-> p.getName().toLowerCase(), p -> p.toString());
            assertTrue(map.containsKey("masha"));
            assertTrue(map.containsKey("taras"));
            assertTrue(map.containsKey("strangecreature"));
            assertTrue(map.containsKey("piter"));
            assertTrue(map.containsKey("applejack"));
            assertTrue(map.containsKey("vovan"));
            assertTrue(map.containsKey("nastya"));
            map.keySet().forEach(key-> System.out.println(key+" "+map.get(key)));
        } catch (UnsupportedOperationException ex) {
            fail("Collection must be unmodifable!");
        }
    }
    
}
