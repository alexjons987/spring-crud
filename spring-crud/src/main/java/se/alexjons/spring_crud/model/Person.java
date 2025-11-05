package se.alexjons.spring_crud.model;

public record Person(int id, String name, int age, String occupation) {

    @Override
    public String toString() {
        return String.format("[%d] %s (%d) - %s", this.id, this.name, this.age, this.occupation);
    }
}