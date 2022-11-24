package nl.belastingdienst.SpringBootSnow.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Instructor extends Person {
    private LicenceType licenceType;

    @OneToOne
    private Lesson lesson;

    public Instructor(String firstName, String lastName, LocalDate dob, LicenceType licenceType) {
        super(firstName, lastName, dob);
        this.licenceType = licenceType;
    }
}
