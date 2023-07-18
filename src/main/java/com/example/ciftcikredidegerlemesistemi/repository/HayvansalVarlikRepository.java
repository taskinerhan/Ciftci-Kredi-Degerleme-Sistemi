package com.example.ciftcikredidegerlemesistemi.repository;
import com.example.ciftcikredidegerlemesistemi.enums.Cinsiyet;
import com.example.ciftcikredidegerlemesistemi.entity.HayvanIrk;
import com.example.ciftcikredidegerlemesistemi.entity.HayvansalVarlikDeger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HayvansalVarlikRepository extends JpaRepository<HayvansalVarlikDeger,Long> {
     HayvansalVarlikDeger findByHayvanIrkIdAndCinsiyet(Long id, Cinsiyet cinsiyet);
     List<HayvansalVarlikDeger> findAll();
     List<HayvansalVarlikDeger> findByHayvanIrk(HayvanIrk hayvanIrk);

}
