package com.example.ciftcikredidegerlemesistemi.entity;
import com.example.ciftcikredidegerlemesistemi.enums.Cinsiyet;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HayvansalVarlikDeger")
public class HayvansalVarlikDeger extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private Cinsiyet cinsiyet;
    private BigDecimal deger;
    @ManyToOne
    @JoinColumn(name = "hayvan_irk_id")
    private HayvanIrk hayvanIrk;

}