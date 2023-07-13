package com.example.ciftcikredidegerlemesistemi.Repository;
import com.example.ciftcikredidegerlemesistemi.Entity.GayrimenkulTipi;
import com.example.ciftcikredidegerlemesistemi.Entity.GayrimenkulVarlikDeger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GayrimenkulVarlikRepository extends JpaRepository<GayrimenkulVarlikDeger,Long> {
    List<GayrimenkulVarlikDeger> findByGayrimenkulTipi(@Param("gayrimenkulTipi") GayrimenkulTipi gayrimenkulTipi);

}

