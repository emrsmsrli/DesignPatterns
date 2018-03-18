package hospitalmanagement.util;

import hospitalmanagement.people.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

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

    public void clear() {
        people.clear();
    }

    public int size() {
        return people.size();
    }

    public void forEach(Consumer<T> consumer) {
        for(T t : people) {
            consumer.accept(t);
        }
    }

    public T first(Predicate<? super T> predicate) {
        for(T t : people)
            if(predicate.test(t))
                return t;
        return null;
    }

    @Override
    public String toString() {
        return people.toString();
    }
}
