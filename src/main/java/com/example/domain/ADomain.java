package com.example.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ADomain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String testKey;

    @OneToMany
    @JoinColumn(name = "testKey", referencedColumnName = "testKey")
    private List<BDomain> b = new ArrayList<>();
}
