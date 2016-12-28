package ru.office.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter @Setter
@Entity @Table(name = "Court")
public class Court extends BaseEntity {
    private String name;
    private String location;
}
