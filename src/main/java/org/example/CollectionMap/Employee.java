package org.example.CollectionMap;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private double salary;
    private Trainee trainee;

    public Employee(int id, String name, String surname, double salary, Trainee trainee) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.trainee = trainee;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", trainee=" + trainee +"\n"+
                '}';
    }
}
