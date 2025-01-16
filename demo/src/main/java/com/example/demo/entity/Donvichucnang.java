package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    @Column(name = "VERSION", nullable = true)
    private Integer version = 0;
	
    @OneToMany(mappedBy = "donvichucnang",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bomon> boMons;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "donvichucnang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Canbo> canBos = new ArrayList<>();

    @OneToMany(mappedBy = "donvichucnang")
    private List<Hopdongcanbo> hopdongcanbos = new ArrayList<>();

    @OneToMany(mappedBy = "donvichucnang",fetch = FetchType.LAZY)
    private List<Quyetdinhkyluat> quyetdinhkyluats = new ArrayList<>();

}
