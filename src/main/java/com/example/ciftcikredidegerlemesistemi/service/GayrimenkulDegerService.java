package com.example.ciftcikredidegerlemesistemi.service;

import com.example.ciftcikredidegerlemesistemi.entity.GayrimenkulVarlikDeger;
import com.example.ciftcikredidegerlemesistemi.enums.GayrimenkulTipi;
import com.example.ciftcikredidegerlemesistemi.repository.GayrimenkulVarlikRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
public class GayrimenkulDegerService {
    private final GayrimenkulVarlikRepository gayrimenkulVarlikRepository;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void ekleGayrimenkulDegeri(){
        for (GayrimenkulTipi tip : GayrimenkulTipi.values()) {
            GayrimenkulVarlikDeger varlikDeger = gayrimenkulVarlikRepository.findByGayrimenkulTipi(tip);
            if (varlikDeger == null) {
                varlikDeger = new GayrimenkulVarlikDeger();
                varlikDeger.setDeger(BigDecimal.ZERO);
                gayrimenkulVarlikRepository.save(varlikDeger);
            }
        }
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public  void guncelleGayrimenkulDeger()
    {
        Random random = new Random();
        List<GayrimenkulVarlikDeger> gayrimenkulVarlikDegerList = gayrimenkulVarlikRepository.findAll();
        for (GayrimenkulVarlikDeger varlik : gayrimenkulVarlikDegerList) {
            int randomDeger = random.nextInt(1000000);
            varlik.setDeger(new BigDecimal(randomDeger));
            gayrimenkulVarlikRepository.save(varlik);
        }
    }

}
