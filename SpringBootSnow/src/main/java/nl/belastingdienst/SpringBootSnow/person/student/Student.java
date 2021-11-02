package nl.belastingdienst.SpringBootSnow.person.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.belastingdienst.SpringBootSnow.enums.Discipline;
import nl.belastingdienst.SpringBootSnow.gear.Gear;
import nl.belastingdienst.SpringBootSnow.lesson.Lesson;
import nl.belastingdienst.SpringBootSnow.person.Person;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Student extends Person {
    private int weeksOfExperience;
    private Discipline discipline;
    private boolean hasOwnGear;
    @ManyToOne
    private Lesson lesson;
    @OneToOne
    private Gear gear;

    public Student(String firstName, String lastName, LocalDate dob, int i, Discipline discipline, boolean hasOwnGear) {
        super(firstName, lastName, dob);
        this.weeksOfExperience = i;
        this.discipline = discipline;
        this.hasOwnGear = hasOwnGear;
    }
}
