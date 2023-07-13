package com.example.ciftcikredidegerlemesistemi.Entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Data
@Entity
public class HayvanIrk extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ad;
    private HayvanTuru hayvanTuru;
    @OneToMany(mappedBy = "hayvanIrk", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HayvansalVarlikDeger> hayvansalVarlikDegerler;
}

