package com.example.ciftcikredidegerlemesistemi.Service;

import com.example.ciftcikredidegerlemesistemi.Entity.GayrimenkulTipi;
import com.example.ciftcikredidegerlemesistemi.Entity.GayrimenkulVarlikDeger;

import java.util.List;

public interface HayvansalVarlikService{

    List<GayrimenkulVarlikDeger> findByGayrimenkulTip(GayrimenkulTipi gayrimenkulTipi);
}
