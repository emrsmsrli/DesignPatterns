package hospitalmanagement.util;

import hospitalmanagement.people.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PersonList<T extends Person> {
    private List<T> people;

    public PersonList() {
        people = new ArrayList<>();
    }

    public void add(T person) {
        people.add(person);
    }

    public void remove(T person) {
        people.remove(person);
    }

    public boolean contains(T person) {
        return people.contains(person);
    }

    public int size() {
        return people.size();
    }

    public void forEach(Consumer<T> consumer) {
        for(T t : people) {
            consumer.accept(t);
        }
    }

    @Override
    public String toString() {
        return people.toString();
    }
}
