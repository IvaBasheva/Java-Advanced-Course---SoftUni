package sanctuary;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private int capacity;
    private List <Elephant> data;

    public Habitat (int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add (Elephant elephant) {
        if (data.size() < capacity) {
            data.add(elephant);
        }
    }
    public boolean remove (String name ) {
        return data.removeIf(e -> e.getName().equals(name));
    }
    public Elephant getElephant (String retiredFrom) {
        for (Elephant elephant : data) {
            if (elephant.getRetiredFrom().equals(retiredFrom)) {
                return elephant;
            }
        }
        return null;
    }
    public Elephant getOldestElephant() {
        return Collections.max(data, Comparator.comparingInt(Elephant::getAge));
    }
    public int getAllElephants() {
        return data.size();
    }
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        builder.append("Saved elephants in the park:");
        for (Elephant elephant : data) {
            builder.append(System.lineSeparator()).append(elephant.getName())
                    .append(" came from: ").append(elephant.getRetiredFrom());
        }
        return builder.toString();
    }
}
