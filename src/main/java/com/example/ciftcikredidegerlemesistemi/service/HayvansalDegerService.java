package com.example.ciftcikredidegerlemesistemi.service;

import com.example.ciftcikredidegerlemesistemi.entity.HayvanIrk;
import com.example.ciftcikredidegerlemesistemi.entity.HayvansalVarlikDeger;
import com.example.ciftcikredidegerlemesistemi.enums.Cinsiyet;
import com.example.ciftcikredidegerlemesistemi.repository.HayvanIrkRepository;
import com.example.ciftcikredidegerlemesistemi.repository.HayvansalVarlikRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HayvansalDegerService {
    private final HayvansalVarlikRepository hayvansalVarlikRepository;
    private final HayvanIrkRepository hayvanIrkRepository;

    public HayvansalDegerService(HayvansalVarlikRepository hayvansalVarlikRepository, HayvanIrkRepository hayvanIrkRepository) {
        this.hayvansalVarlikRepository = hayvansalVarlikRepository;
        this.hayvanIrkRepository = hayvanIrkRepository;
    }

    public void ekleHayvansalDegerCronJob() {
        List<HayvanIrk> hayvanIrkList = hayvanIrkRepository.findAll();

        for (HayvanIrk hayvanIrk : hayvanIrkList) {
            List<HayvansalVarlikDeger> hayvansalVarlikDegerList = hayvansalVarlikRepository.findByHayvanIrk(hayvanIrk);

            Set<Cinsiyet> cinsiyetSet = hayvansalVarlikDegerList.stream()
                    .map(HayvansalVarlikDeger::getCinsiyet)
                    .collect(Collectors.toSet());

            for (Cinsiyet cinsiyet : Cinsiyet.values()) {
                if (Cinsiyet.TUMU.equals(cinsiyet)) continue;
                if (!cinsiyetSet.contains(cinsiyet)) {
                    HayvansalVarlikDeger hayvansalVarlikDeger = new HayvansalVarlikDeger();
                    hayvansalVarlikDeger.setCinsiyet(cinsiyet);
                    hayvansalVarlikDeger.setDeger(BigDecimal.ZERO);
                    hayvansalVarlikDeger.setHayvanIrk(hayvanIrk);
                    hayvansalVarlikRepository.save(hayvansalVarlikDeger);
                }
            }
        }
    }

    public void guncelleHayvansalVarlikDeger() {
        Random random = new Random();
        List<HayvansalVarlikDeger> hayvansalVarlikDegerList = hayvansalVarlikRepository.findAll();
        for(HayvansalVarlikDeger hayvansalVarlikDeger: hayvansalVarlikDegerList) {
            int randomDeger = random.nextInt(1000000);
            hayvansalVarlikDeger.setDeger(new BigDecimal(randomDeger));
            hayvansalVarlikRepository.save(hayvansalVarlikDeger);
        }

    }

}
