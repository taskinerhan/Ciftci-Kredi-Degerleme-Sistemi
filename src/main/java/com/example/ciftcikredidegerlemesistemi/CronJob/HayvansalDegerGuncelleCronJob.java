package com.example.ciftcikredidegerlemesistemi.CronJob;
import com.example.ciftcikredidegerlemesistemi.Entity.HayvansalVarlikDeger;
import com.example.ciftcikredidegerlemesistemi.Repository.HayvansalVarlikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
@Component
public class HayvansalDegerGuncelleCronJob {
    @Autowired
    private HayvansalVarlikRepository hayvansalVarlikRepository;
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
