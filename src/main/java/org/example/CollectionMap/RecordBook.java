package org.example.CollectionMap;

import java.util.ArrayList;
import java.util.List;

public class RecordBook {
    private int id;
    private int internshipExperienceDay;
    private String nameInstitute;
    private List<Double> grades = new ArrayList<>();


    public RecordBook(int internshipExperienceDay, int id, String nameInstitute, List<Double> grades) {
        this.internshipExperienceDay = internshipExperienceDay;
        this.id = id;
        this.nameInstitute = nameInstitute;
        this.grades = grades;
    }

    public String getNameInstitute() {
        return nameInstitute;
    }

    public int getInternshipExperienceDay() {
        return internshipExperienceDay;
    }

    public List<Double> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "RecordBook{" +
                "id=" + id +
                ", internshipExperienceDay=" + internshipExperienceDay +
                ", nameInstitute='" + nameInstitute + '\'' +
                ", grades=" + grades +
                '}';
    }
}
