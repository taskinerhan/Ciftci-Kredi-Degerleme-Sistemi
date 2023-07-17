package com.example.ciftcikredidegerlemesistemi.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.math.BigDecimal;
@Data
@Entity
public class GayrimenkulVarlikDeger extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private GayrimenkulTipi gayrimenkulTipi;
    private BigDecimal Deger;
}