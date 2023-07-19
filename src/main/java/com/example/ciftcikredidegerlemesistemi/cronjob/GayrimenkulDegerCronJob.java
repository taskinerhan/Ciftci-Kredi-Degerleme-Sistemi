package com.example.ciftcikredidegerlemesistemi.cronjob;

import com.example.ciftcikredidegerlemesistemi.service.GayrimenkulDegerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GayrimenkulDegerCronJob {
    private final GayrimenkulDegerService gayrimenkulDegerService;

    @Scheduled(cron = "0 0/5 0-12 * * *")
    public void ekleGayrimenkulDegeri() {
        gayrimenkulDegerService.ekleGayrimenkulDegeri();
    }


}
