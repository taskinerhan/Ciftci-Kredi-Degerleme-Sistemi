package com.example.ciftcikredidegerlemesistemi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;
@MappedSuperclass
public class BaseEntity {
    @Column(name = "kayit_tarihi")
    private Date kayitTarihi;
    @Column(name = "guncelleme_tarihi")
    private Date guncellemeTarihi;

}

