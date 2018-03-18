package hospitalmanagement.util.names;

public class Name {
    private String first;
    private String last;

    public Name(String f, String l) {
        first = f;
        last = l;
    }

    @Override
    public String toString() {
        return first + " " + last;
    }
}