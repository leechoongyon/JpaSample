package com.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class GroupTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "GROUP_ID")
    private Long groupId;

    private String groupName;

    @OneToMany(mappedBy = "groupTable")
    private List<Member> members = new ArrayList<>();
}
