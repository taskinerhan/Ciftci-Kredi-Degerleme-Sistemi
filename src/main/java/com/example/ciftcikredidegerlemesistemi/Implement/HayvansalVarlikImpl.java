package com.example.ciftcikredidegerlemesistemi.Implement;

import com.example.ciftcikredidegerlemesistemi.Entity.GayrimenkulTipi;
import com.example.ciftcikredidegerlemesistemi.Entity.GayrimenkulVarlikDeger;
import com.example.ciftcikredidegerlemesistemi.Repository.GayrimenkulVarlikRepository;
import com.example.ciftcikredidegerlemesistemi.Service.HayvansalVarlikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class HayvansalVarlikImpl implements HayvansalVarlikService {
    @Override
    public List<GayrimenkulVarlikDeger> findByGayrimenkulTip(GayrimenkulTipi gayrimenkulTipi) {
        return null;
    }
}
