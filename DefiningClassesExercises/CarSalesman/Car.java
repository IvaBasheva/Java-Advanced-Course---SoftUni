package DefiningClassesExercises.CarSalesman;


import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car (String model,Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String print() {
        return String.format("%s:" + "\n" + "  %s:\n" +
                "    Power: %s\n" +
                "    Displacement: %s\n" +
                "    Efficiency: %s\n" +
                "  Weight: %s\n" +
                "  Color: %s", this.model, getEngine().getModel(),
                getEngine().getPower(), getEngine().getDisplacement(), getEngine().getEfficiency(),
                this.weight, this.color);
    }
}
