package ru.office.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter @Setter
@Entity @Table(name = "ServiceOffice")
public class ServiceOffice extends BaseEntity{
    private String name;
    private String price;

}
