package com.example.ciftcikredidegerlemesistemi.cronjob;
import com.example.ciftcikredidegerlemesistemi.enums.Cinsiyet;
import com.example.ciftcikredidegerlemesistemi.entity.HayvanIrk;
import com.example.ciftcikredidegerlemesistemi.entity.HayvansalVarlikDeger;
import com.example.ciftcikredidegerlemesistemi.repository.HayvanIrkRepository;
import com.example.ciftcikredidegerlemesistemi.repository.HayvansalVarlikRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Component
public class HayvansalDegerCronJob {
    private final HayvansalVarlikRepository hayvansalVarlikRepository;
    private final HayvanIrkRepository hayvanIrkRepository;
    public HayvansalDegerCronJob(HayvansalVarlikRepository hayvansalVarlikRepository, HayvanIrkRepository hayvanIrkRepository) {
        this.hayvansalVarlikRepository = hayvansalVarlikRepository;
        this.hayvanIrkRepository = hayvanIrkRepository;
    }
    @Scheduled(cron = "0 0/5 0-12 * * ?")
    public void ekleHayvansalDegerCronJob(){
       List<HayvanIrk> hayvanIrkList = hayvanIrkRepository.findAll();

       for(HayvanIrk hayvanIrk:hayvanIrkList){
           List<HayvansalVarlikDeger> hayvansalVarlikDegerList =hayvansalVarlikRepository.findByHayvanIrk(hayvanIrk);

           Set<Cinsiyet> cinsiyetSet = hayvansalVarlikDegerList.stream()
                   .map(HayvansalVarlikDeger::getCinsiyet)
                   .collect(Collectors.toSet());

           for(Cinsiyet cinsiyet:Cinsiyet.values()){
               if(Cinsiyet.TUMU.equals(cinsiyet)) continue;
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
