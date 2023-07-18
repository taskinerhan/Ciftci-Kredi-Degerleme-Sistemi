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


@Component
public class HayvansalDegerCronJob {
    @Autowired
    private HayvansalVarlikRepository hayvansalVarlikRepository;
    @Autowired
    private HayvanIrkRepository hayvanIrkRepository;
    @Scheduled(cron = "0 0/5 0-12 * * ?")
    public void ekleHayvansalDegerCronJob(){
        List<HayvanIrk> hayvanIrkList = hayvanIrkRepository.findAll();
        boolean erkekDurum ;
        boolean disiDurum ;
        for (HayvanIrk hayvanIrk : hayvanIrkList) {
            List<HayvansalVarlikDeger> hayvansalVarlikDegerList = hayvansalVarlikRepository.findByHayvanIrk(hayvanIrk);
            if(!hayvansalVarlikDegerList.isEmpty()){
                for (HayvansalVarlikDeger hayvansalVarlikDeger : hayvansalVarlikDegerList) {
                    erkekDurum = false;
                    disiDurum = false;
                    if (hayvansalVarlikDeger.getCinsiyet() == Cinsiyet.Erkek) {
                        erkekDurum = true;
                    } else if (hayvansalVarlikDeger.getCinsiyet() == Cinsiyet.Disi) {
                        disiDurum = true;
                    }
                    if (!erkekDurum) {
                        HayvansalVarlikDeger erkekDeger = new HayvansalVarlikDeger();
                        erkekDeger.setCinsiyet(Cinsiyet.Erkek);
                        erkekDeger.setDeger(BigDecimal.ZERO);
                        erkekDeger.setHayvanIrk(hayvanIrk);
                        hayvansalVarlikRepository.save(erkekDeger);
                    }
                    if (!disiDurum) {
                        HayvansalVarlikDeger disiDeger = new HayvansalVarlikDeger();
                        disiDeger.setCinsiyet(Cinsiyet.Disi);
                        disiDeger.setDeger(BigDecimal.ZERO);
                        disiDeger.setHayvanIrk(hayvanIrk);
                        hayvansalVarlikRepository.save(disiDeger);
                    }
                }
            }
            else{
                HayvansalVarlikDeger erkekDeger = new HayvansalVarlikDeger();
                erkekDeger.setCinsiyet(Cinsiyet.Erkek);
                erkekDeger.setDeger(BigDecimal.ZERO);
                erkekDeger.setHayvanIrk(hayvanIrk);
                hayvansalVarlikRepository.save(erkekDeger);

                HayvansalVarlikDeger disiDeger = new HayvansalVarlikDeger();
                disiDeger.setCinsiyet(Cinsiyet.Disi);
                disiDeger.setDeger(BigDecimal.ZERO);
                disiDeger.setHayvanIrk(hayvanIrk);
                hayvansalVarlikRepository.save(disiDeger);
            }
        }


    }
}
