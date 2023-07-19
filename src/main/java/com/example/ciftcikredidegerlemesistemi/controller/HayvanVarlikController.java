package com.example.ciftcikredidegerlemesistemi.controller;
import com.example.ciftcikredidegerlemesistemi.enums.Cinsiyet;
import com.example.ciftcikredidegerlemesistemi.entity.HayvansalVarlikDeger;
import com.example.ciftcikredidegerlemesistemi.repository.HayvansalVarlikRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public class HayvanVarlikController {
    private final HayvansalVarlikRepository hayvansalVarlikRepository;


    @GetMapping("/hayvansal-varlik-deger-yonetimi/{hayvanIrkId}/{cinsiyet}")
    public ResponseEntity<?> HayvansalVarlikDeger(@PathVariable(name="hayvanIrkId") Long hayvanIrkId, @PathVariable(name="cinsiyet")Cinsiyet cinsiyet) {
        if(hayvanIrkId==0 || cinsiyet==null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Not Found");
        }
        HayvansalVarlikDeger byHayvanIrkIdAndCinsiyet = hayvansalVarlikRepository.findByHayvanIrkIdAndCinsiyet(hayvanIrkId, cinsiyet);
        if (byHayvanIrkIdAndCinsiyet == null) {
            throw new ResponseStatusException(HttpStatus.OK, "Belirtilen değere ait veri bulunamadı");
        }
        return new ResponseEntity<>(byHayvanIrkIdAndCinsiyet.getDeger(), HttpStatus.OK);
   }


}