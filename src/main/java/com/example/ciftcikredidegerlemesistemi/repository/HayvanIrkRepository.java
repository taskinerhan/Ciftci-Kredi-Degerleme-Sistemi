package com.example.ciftcikredidegerlemesistemi.repository;

import com.example.ciftcikredidegerlemesistemi.entity.HayvanIrk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HayvanIrkRepository extends JpaRepository<HayvanIrk,Long> {
    @Override
    List<HayvanIrk> findAll();

}
