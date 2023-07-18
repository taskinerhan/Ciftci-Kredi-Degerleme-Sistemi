package com.example.ciftcikredidegerlemesistemi.repository;
import com.example.ciftcikredidegerlemesistemi.enums.GayrimenkulTipi;
import com.example.ciftcikredidegerlemesistemi.entity.GayrimenkulVarlikDeger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GayrimenkulVarlikRepository extends JpaRepository<GayrimenkulVarlikDeger,Long> {
    GayrimenkulVarlikDeger findByGayrimenkulTipi(@Param("gayrimenkulTipi") GayrimenkulTipi gayrimenkulTipi);
}

