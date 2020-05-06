package com.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "MEMBER")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @ManyToOne
    @JoinColumn(name="GROUP_ID")
    private GroupTable groupTable;

    public void setGroupTable(GroupTable groupTable) {
        this.groupTable = groupTable;
    }
}