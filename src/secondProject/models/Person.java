package secondProject.models;

import secondProject.models.enums.Position;

public class Person {
    private Long id;
    private int age;
    private String name;
    private Double salary;
    private Position position;

    public Person() {
    }
    public Person(Long id, int age, String name, Double salary, Position position) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "\n{"+
                id + ", " +
                age + ", " +
                name + ", " +
                salary + ", " +
                position + "}";
    }
}
