package DefiningClassesExercises.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private Company company;
    private Car car;
    private List <Parent> parents;
    private List <Child> children;
    private List <Pokemon> pokemons;

    public Person () {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();

    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public String toString () {
        StringBuilder builder = new StringBuilder();
        builder.append("Company:").append("\n");
        if (company != null) {
            builder.append(company.toString()).append("\n");
        }
        builder.append("Car:").append("\n");
        if (car != null) {
            builder.append(car.toString()).append("\n");
        }
        builder.append("Pokemon:").append("\n");
        for (Pokemon pokemon : pokemons) {
            builder.append(pokemon.toString()).append("\n");
        }
        builder.append("Parents:").append("\n");
        for (Parent parent : parents) {
            builder.append(parent.toString()).append("\n");
        }
        builder.append("Children:").append("\n");
        for (Child child : children) {
            builder.append(child.toString()).append("\n");
        }
        return builder.toString();
    }
}
