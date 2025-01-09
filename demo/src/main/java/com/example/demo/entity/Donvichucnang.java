package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;


@Entity
@Data
@Table(name = "donvichucnang")
public class Donvichucnang implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String maDonVi;
    private String tenDonVi;
    @Version
    @Column(name = "VERSION", nullable = false)
    private Integer version = 0;
	
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "donvichucnang",fetch = FetchType.LAZY)
    private Set<Bomon> boMons = new HashSet<>();

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "donvichucnang", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Canbo> canBos = new HashSet<>();

}
