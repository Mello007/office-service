package ru.office.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter @Setter
@Entity @Table(name = "CaseService")
public class CaseService extends BaseEntity {
    private String kindOfCase;
    private String advocate;
    private String serviceOffice;
    private String court;
}
