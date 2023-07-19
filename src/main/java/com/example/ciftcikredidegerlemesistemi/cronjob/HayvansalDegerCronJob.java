package com.example.ciftcikredidegerlemesistemi.cronjob;

import com.example.ciftcikredidegerlemesistemi.service.HayvansalDegerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HayvansalDegerCronJob {
    private final HayvansalDegerService hayvansalDegerService;
    @Scheduled(cron = "0 0/5 0-12 * * ?")
    public void ekleHayvansalDegerCronJob() {
       hayvansalDegerService.ekleHayvansalDegerCronJob();
    }
}
