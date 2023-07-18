package com.example.ciftcikredidegerlemesistemi.cronjob;

import com.example.ciftcikredidegerlemesistemi.enums.GayrimenkulTipi;
import com.example.ciftcikredidegerlemesistemi.entity.GayrimenkulVarlikDeger;
import com.example.ciftcikredidegerlemesistemi.repository.GayrimenkulVarlikRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class GayrimenkulDegerCronJob {
    private final GayrimenkulVarlikRepository gayrimenkulVarlikRepository;

    public GayrimenkulDegerCronJob(GayrimenkulVarlikRepository gayrimenkulVarlikRepository) {
        this.gayrimenkulVarlikRepository = gayrimenkulVarlikRepository;
    }

    @Scheduled(cron = "0 0/5 0-12 * * *")
    public void ekleGayrimenkulDegeri() {
        GayrimenkulTipi[] gayrimenkulTipleri = GayrimenkulTipi.values();
        for (GayrimenkulTipi tip : gayrimenkulTipleri) {
            GayrimenkulVarlikDeger varlikDeger = gayrimenkulVarlikRepository.findByGayrimenkulTipi(tip);
            if (varlikDeger == null) {
                varlikDeger = new GayrimenkulVarlikDeger();
                varlikDeger.setDeger(BigDecimal.ZERO);
                gayrimenkulVarlikRepository.save(varlikDeger);
            }
        }
    }
}
