package com.example.ciftcikredidegerlemesistemi.entity;
import com.example.ciftcikredidegerlemesistemi.enums.HayvanTuru;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HayvanIrk")
public class HayvanIrk extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ad;
    @Enumerated(EnumType.STRING)
    private HayvanTuru hayvanTuru;
    @OneToMany(mappedBy = "hayvanIrk", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HayvansalVarlikDeger> hayvansalVarlikDegerler;
}

