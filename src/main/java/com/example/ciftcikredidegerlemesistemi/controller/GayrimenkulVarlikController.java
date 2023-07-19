package com.example.ciftcikredidegerlemesistemi.controller;
import com.example.ciftcikredidegerlemesistemi.enums.GayrimenkulTipi;
import com.example.ciftcikredidegerlemesistemi.entity.GayrimenkulVarlikDeger;
import com.example.ciftcikredidegerlemesistemi.repository.GayrimenkulVarlikRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
@RestController
@RequiredArgsConstructor
public class GayrimenkulVarlikController {
    private final GayrimenkulVarlikRepository gayrimenkulVarlikRepository;

    @GetMapping("/gayrimenkul-varlik-deger-yonetimi/{gayrimenkulTipi}")
    public ResponseEntity<?> GayrimenkulVarlikDeger(@PathVariable(name = "gayrimenkulTipi") GayrimenkulTipi gayrimenkulTipi) {
        if(gayrimenkulTipi==null){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body((gayrimenkulTipi) +" bilgisiyle veri bulunulmadı");
        }
        GayrimenkulVarlikDeger varlikDeger = gayrimenkulVarlikRepository.findByGayrimenkulTipi(gayrimenkulTipi);
        if (varlikDeger == null) {
            throw new ResponseStatusException(HttpStatus.OK, "Belirtilen değere ait veri bulunamadı");
        }
        return new ResponseEntity(varlikDeger, HttpStatus.OK);
    }

}
