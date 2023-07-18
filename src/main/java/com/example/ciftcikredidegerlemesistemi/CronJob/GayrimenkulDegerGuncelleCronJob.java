package com.example.ciftcikredidegerlemesistemi.CronJob;

import com.example.ciftcikredidegerlemesistemi.Entity.GayrimenkulVarlikDeger;
import com.example.ciftcikredidegerlemesistemi.Repository.GayrimenkulVarlikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Component
public class GayrimenkulDegerGuncelleCronJob {
    @Autowired
    private GayrimenkulVarlikRepository gayrimenkulVarlikRepository;
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
