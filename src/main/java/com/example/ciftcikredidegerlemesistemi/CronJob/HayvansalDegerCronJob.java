package com.example.ciftcikredidegerlemesistemi.CronJob;
import com.example.ciftcikredidegerlemesistemi.Entity.Cinsiyet;
import com.example.ciftcikredidegerlemesistemi.Entity.HayvanIrk;
import com.example.ciftcikredidegerlemesistemi.Entity.HayvansalVarlikDeger;
import com.example.ciftcikredidegerlemesistemi.Repository.HayvanIrkRepository;
import com.example.ciftcikredidegerlemesistemi.Repository.HayvansalVarlikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class HayvansalDegerCronJob {
    @Autowired
    private HayvansalVarlikRepository hayvansalVarlikRepository;
    @Autowired
    private HayvanIrkRepository hayvanIrkRepository;
    @Scheduled(cron = "0 0/5 0-12 * * ?")
    public void ekleHayvansalDegerCronJob(){
       List<HayvanIrk> hayvanIrkList = hayvanIrkRepository.findAll();

       for(HayvanIrk hayvanIrk:hayvanIrkList){
           List<HayvansalVarlikDeger> hayvansalVarlikDegerList =hayvansalVarlikRepository.findByHayvanIrk(hayvanIrk);

           Set<Cinsiyet> cinsiyetSet = hayvansalVarlikDegerList.stream()
                   .map(HayvansalVarlikDeger::getCinsiyet)
                   .collect(Collectors.toSet());

           for(Cinsiyet cinsiyet:Cinsiyet.values()){
               if(Cinsiyet.Tumu.equals(cinsiyet)) continue;
            if(cinsiyetSet.contains(cinsiyet)){
                HayvansalVarlikDeger hayvansalVarlikDeger = new HayvansalVarlikDeger();
                hayvansalVarlikDeger.setCinsiyet(cinsiyet);
                hayvansalVarlikDeger.setDeger(BigDecimal.ZERO);
                hayvansalVarlikDeger.setHayvanIrk(hayvanIrk);
                hayvansalVarlikRepository.save(hayvansalVarlikDeger);
            }
           }
       }
    }
}
