package com.example.ciftcikredidegerlemesistemi.Repository;

import com.example.ciftcikredidegerlemesistemi.Entity.Cinsiyet;
import com.example.ciftcikredidegerlemesistemi.Entity.HayvansalVarlikDeger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HayvansalVarlikRepository extends JpaRepository<HayvansalVarlikDeger,Long> {
    public HayvansalVarlikDeger findByHayvanIrkIdAndCinsiyet(Long id, Cinsiyet cinsiyet);

}
