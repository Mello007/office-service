package ru.office.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter @Setter
@Entity @Table(name = "Education")
public class Education extends BaseEntity {
    private String nameOfAdvocate;
    private String education;
    private String date;
}
