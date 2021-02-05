package com.example.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String testKey;
}