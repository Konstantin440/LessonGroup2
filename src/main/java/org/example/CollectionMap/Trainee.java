package org.example.CollectionMap;

public class Trainee {
    private int id;
    private String name;
    private String surname;
    RecordBook recordBook;

    public Trainee(int id, String name, String surname, RecordBook recordBook) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.recordBook = recordBook;
    }

    public RecordBook getRecordBook() {
        return recordBook;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", recordBook=" + recordBook +
                '}';
    }
}
