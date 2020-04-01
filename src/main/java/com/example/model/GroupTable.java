package com.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class GroupTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "GROUP_ID")
    private Long groupId;

    private String groupName;

    @OneToMany(mappedBy = "groupTable")
    private List<Member> list;
}
