package com.ami_coding_pari_na.ami_coding_pari_na.repo;

import com.ami_coding_pari_na.ami_coding_pari_na.model.KhojData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KhojRepo extends JpaRepository<KhojData, Long> {
    List<KhojData> findAllByuserid(long i);
}
