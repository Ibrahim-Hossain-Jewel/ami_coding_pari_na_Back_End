package com.ami_coding_pari_na.ami_coding_pari_na.repo;
import com.ami_coding_pari_na.ami_coding_pari_na.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface RegistrationRepo extends JpaRepository<User, Long>, LoginRepo{

}
