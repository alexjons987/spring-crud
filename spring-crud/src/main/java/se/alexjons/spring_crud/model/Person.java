package se.alexjons.spring_crud.model;

public class Person {
    private final int id;
    private final String name;
    private final int age;
    private final String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public String toString() {
        return String.format("[%d] %s (%d) - %s", this.id, this.name, this.age, this.occupation);
    }
}