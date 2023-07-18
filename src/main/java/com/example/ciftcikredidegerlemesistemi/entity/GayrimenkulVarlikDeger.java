package com.example.ciftcikredidegerlemesistemi.entity;

import com.example.ciftcikredidegerlemesistemi.enums.GayrimenkulTipi;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GayrimenkulVarlikDeger")
public class GayrimenkulVarlikDeger extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private GayrimenkulTipi gayrimenkulTipi;
    private BigDecimal Deger;
}