package com.ami_coding_pari_na.ami_coding_pari_na.service;

import com.ami_coding_pari_na.ami_coding_pari_na.DTO.AuthDTO;
import com.ami_coding_pari_na.ami_coding_pari_na.DTO.KhojDTO;
import com.ami_coding_pari_na.ami_coding_pari_na.response.AuthResponse;
import com.ami_coding_pari_na.ami_coding_pari_na.response.KhojResponse;
import com.ami_coding_pari_na.ami_coding_pari_na.response.UserActivityDetailsResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface authService {
    AuthResponse login(AuthDTO authDTO);
    AuthResponse registration(AuthDTO authDTO);
    KhojResponse khojSubmit(KhojDTO khojDTO);
    UserActivityDetailsResponse activityDetails(KhojDTO khojDTO);
}
