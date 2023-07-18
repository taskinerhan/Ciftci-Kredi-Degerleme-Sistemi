package com.example.ciftcikredidegerlemesistemi.cronjob;
import com.example.ciftcikredidegerlemesistemi.entity.HayvansalVarlikDeger;
import com.example.ciftcikredidegerlemesistemi.repository.HayvansalVarlikRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
@Component
public class HayvansalDegerGuncelleCronJob {
    private final HayvansalVarlikRepository hayvansalVarlikRepository;

    public HayvansalDegerGuncelleCronJob(HayvansalVarlikRepository hayvansalVarlikRepository) {
        this.hayvansalVarlikRepository = hayvansalVarlikRepository;
    }

    @Scheduled(cron = "0 0/5 * * * ?")
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
