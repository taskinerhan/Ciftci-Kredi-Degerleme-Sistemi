package com.example.ciftcikredidegerlemesistemi.cronjob;

import com.example.ciftcikredidegerlemesistemi.entity.GayrimenkulVarlikDeger;
import com.example.ciftcikredidegerlemesistemi.repository.GayrimenkulVarlikRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
@Component
public class GayrimenkulDegerGuncelleCronJob {

    private final GayrimenkulVarlikRepository gayrimenkulVarlikRepository;
    public GayrimenkulDegerGuncelleCronJob(GayrimenkulVarlikRepository gayrimenkulVarlikRepository) {
        this.gayrimenkulVarlikRepository = gayrimenkulVarlikRepository;
    }
    @Scheduled(cron = "*/5 0-12 * * *")
    public void guncelleGayrimenkulDeger(){
        Random random = new Random();
        List<GayrimenkulVarlikDeger> gayrimenkulVarlikDegerList=gayrimenkulVarlikRepository.findAll();
        for (GayrimenkulVarlikDeger varlik : gayrimenkulVarlikDegerList) {
            int randomDeger = random.nextInt(1000000);
            varlik.setDeger(new BigDecimal(randomDeger));
            gayrimenkulVarlikRepository.save(varlik);
        }

    }
}
