package dev.darshan.productservice.inheritancedemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_student")
@DiscriminatorValue(value = "2")
public class Student extends User {

    private double psp;
    private double attendance;
}
