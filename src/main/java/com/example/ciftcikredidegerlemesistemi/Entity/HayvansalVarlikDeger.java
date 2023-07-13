package com.example.ciftcikredidegerlemesistemi.Entity;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
@Data
@Entity
public class HayvansalVarlikDeger extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Cinsiyet cinsiyet;
    private BigDecimal deger;
    @ManyToOne
    @JoinColumn(name = "hayvan_irk_id")
    private HayvanIrk hayvanIrk;
}