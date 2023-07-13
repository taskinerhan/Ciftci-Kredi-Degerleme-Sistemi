package com.example.ciftcikredidegerlemesistemi.Controller;
import com.example.ciftcikredidegerlemesistemi.Entity.Cinsiyet;
import com.example.ciftcikredidegerlemesistemi.Entity.GayrimenkulTipi;
import com.example.ciftcikredidegerlemesistemi.Entity.GayrimenkulVarlikDeger;
import com.example.ciftcikredidegerlemesistemi.Entity.HayvansalVarlikDeger;
import com.example.ciftcikredidegerlemesistemi.Repository.GayrimenkulVarlikRepository;
import com.example.ciftcikredidegerlemesistemi.Repository.HayvansalVarlikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    private HayvansalVarlikRepository hayvansalVarlikRepository;
    @Autowired
    private GayrimenkulVarlikRepository gayrimenkulVarlikRepository;
    @GetMapping("/hayvansal-varlik-deger-yonetimi/{hayvanIrkId}/{cinsiyet}")
    public ResponseEntity<?> HayvansalVarlikDeger(@PathVariable(name="hayvanIrkId") Long hayvanIrkId, @PathVariable(name="cinsiyet")Cinsiyet cinsiyet) {
        if(hayvanIrkId==0 || cinsiyet==null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Not Found");
        }
        HayvansalVarlikDeger byHayvanIrkIdAndCinsiyet = hayvansalVarlikRepository.findByHayvanIrkIdAndCinsiyet(hayvanIrkId, cinsiyet);

        return new ResponseEntity<>(byHayvanIrkIdAndCinsiyet.getDeger(), HttpStatus.OK);
   }
    @GetMapping("/gayrimenkul-varlik-deger-yonetimi/{gayrimenkulTipi}")
    public ResponseEntity<List<GayrimenkulVarlikDeger>> GayrimenkulVarlikDeger(@PathVariable(name = "gayrimenkulTipi") GayrimenkulTipi gayrimenkulTipi) {
        List<GayrimenkulVarlikDeger> varlikDegerList;
        varlikDegerList = gayrimenkulVarlikRepository.findByGayrimenkulTipi(gayrimenkulTipi);
        if(varlikDegerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(varlikDegerList, HttpStatus.OK);
    }

}