package org.example;

import org.example.CollectionMap.Employee;
import org.example.CollectionMap.RecordBook;
import org.example.CollectionMap.Trainee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        RecordBook recordBook1 = new RecordBook(30, 1, "University A", Arrays.asList(5.0, 5.0, 5.0, 4.0, 5.0));
        RecordBook recordBook2 = new RecordBook(35, 2, "University B", Arrays.asList(4.0, 5.0, 5.0, 4.0, 5.0));
        RecordBook recordBook3 = new RecordBook(40, 3, "University C", Arrays.asList(3.0, 3.0, 4.0, 4.0, 5.0));
        RecordBook recordBook4 = new RecordBook(50, 5, "University E", Arrays.asList(4.0, 3.0, 4.0, 5.0, 4.0));
        RecordBook recordBook5 = new RecordBook(55, 6, "РГСУ", Arrays.asList(4.0, 3.0, 5.0, 4.0, 2.0));
        RecordBook recordBook6 = new RecordBook(60, 7, "РГСУ", Arrays.asList(2.0, 2.0, 5.0, 4.0, 3.0));
        RecordBook recordBook7 = new RecordBook(70, 9, "РГСУ", Arrays.asList(3.0, 5.0, 2.0, 4.0, 2.0));
        RecordBook recordBook8 = new RecordBook(75, 10, "University J", Arrays.asList(2.0, 2.0, 5.0, 4.0, 3.0));

        employees.add(new Employee(1, "John", "Doe", 5000.0, new Trainee(1, "Jane", "Doe", recordBook1)));
        employees.add(new Employee(2, "Jane", "Smith", 6000.0, new Trainee(2, "Bob", "Johnson", recordBook2)));
        employees.add(new Employee(3, "Michael", "Williams", 7000.0, new Trainee(3, "Alice", "Brown", recordBook3)));
        employees.add(new Employee(4, "Emily", "Davis", 5500.0, null));
        employees.add(new Employee(5, "David", "Martinez", 6500.0, new Trainee(5, "Sarah", "Lee", recordBook4)));
        employees.add(new Employee(6, "Olivia", "Hernandez", 6000.0, new Trainee(6, "Juan", "Diaz", recordBook5)));
        employees.add(new Employee(7, "Daniel", "Sanchez", 7500.0, new Trainee(7, "Maria", "Morales", recordBook6)));
        employees.add(new Employee(8, "Isabella", "Ramirez", 5800.0, null));
        employees.add(new Employee(9, "Lucas", "Jimenez", 6800.0, new Trainee(9, "Sophia", "Reyes", recordBook7)));
        employees.add(new Employee(10, "Mia", "Molina", 7200.0, new Trainee(10, "Miguel", "Castillo", recordBook8)));

        //Вывод тех сотрудников у которых есть стажеры
        List<Employee> haveTrainee = employees.stream()
                .filter(e -> e.getTrainee() != null)
                .collect(Collectors.toList());

        System.out.println(haveTrainee);

        // Вывод всех сотрудников у которых стажеры обучаются более 30 дней

        List<Employee> moreThan30Days = employees.stream()
                .filter(employee -> employee.getTrainee() != null && employee.getTrainee().getRecordBook().getInternshipExperienceDay() > 30)
                .collect(Collectors.toList());
        System.out.println();
        System.out.println(moreThan30Days);
        System.out.println();

        //всех сотрудников у которых стажеры из института РГСУ

        List<Employee> rgsu = employees.stream()
                .filter(employee -> employee.getTrainee() != null && employee.getTrainee().getRecordBook().getNameInstitute().equals("РГСУ"))
                .collect(Collectors.toList());
        System.out.println(rgsu);
        System.out.println();

        //получить новый лист сотрудников  стажеры которых учатся на  среднюю оценку 4-5


        List<Employee> averageRatingFrom4To5 = employees.stream()
                .filter(employee -> employee.getTrainee() != null && employee.getTrainee()
                        .getRecordBook()
                        .getGrades()
                        .stream()
                        .mapToDouble(Double::doubleValue).average().getAsDouble() > 4
                        && employee.getTrainee()
                        .getRecordBook()
                        .getGrades()
                        .stream()
                        .mapToDouble(Double::doubleValue).average().getAsDouble() < 5).collect(Collectors.toList());

        System.out.println(averageRatingFrom4To5);
        System.out.println();

        //получить массив из всех стажеров

                List <Trainee> traineeList = employees.stream()
                        .map(employee -> employee.getTrainee())
                        .collect(Collectors.toList());

                Trainee [] trainees = new Trainee[traineeList.size()];
                traineeList.toArray(trainees);

        System.out.println(Arrays.toString(trainees));


    }

}
