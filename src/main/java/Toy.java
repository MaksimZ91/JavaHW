import java.util.Objects;
import java.util.UUID;

public class Toy implements Cloneable {
    private String id;
    private String description;
    private int count;
    private int weight;

    public Toy(String description, int count, int weight) {
        this.id = UUID.randomUUID().toString();;
        this.description = description;
        this.count = count;
        this.weight = weight;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", count=" + count +
                ", weight=" + weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toy)) return false;
        Toy toy = (Toy) o;
        return getId().equals(toy.getId()) && getDescription().equals(toy.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription());
    }

    @Override
    protected Toy clone() throws CloneNotSupportedException {
        return (Toy) super.clone();
    }
}
