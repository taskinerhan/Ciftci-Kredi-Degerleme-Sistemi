package com.example.ciftcikredidegerlemesistemi.Repository;
import com.example.ciftcikredidegerlemesistemi.Entity.Cinsiyet;
import com.example.ciftcikredidegerlemesistemi.Entity.HayvanIrk;
import com.example.ciftcikredidegerlemesistemi.Entity.HayvansalVarlikDeger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HayvansalVarlikRepository extends JpaRepository<HayvansalVarlikDeger,Long> {
     HayvansalVarlikDeger findByHayvanIrkIdAndCinsiyet(Long id, Cinsiyet cinsiyet);
     List<HayvansalVarlikDeger> findAll();
     List<HayvansalVarlikDeger> findByHayvanIrk(HayvanIrk hayvanIrk);

}
