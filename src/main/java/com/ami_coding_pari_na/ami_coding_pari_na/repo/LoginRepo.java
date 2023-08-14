package com.ami_coding_pari_na.ami_coding_pari_na.repo;

import com.ami_coding_pari_na.ami_coding_pari_na.model.User;

import java.util.Optional;

public interface LoginRepo {
    Optional<User> findOneByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
