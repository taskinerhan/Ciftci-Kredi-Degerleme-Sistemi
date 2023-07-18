package com.example.ciftcikredidegerlemesistemi.Repository;

import com.example.ciftcikredidegerlemesistemi.Entity.HayvanIrk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HayvanIrkRepository extends JpaRepository<HayvanIrk,Long> {
    @Override
    List<HayvanIrk> findAll();

}
