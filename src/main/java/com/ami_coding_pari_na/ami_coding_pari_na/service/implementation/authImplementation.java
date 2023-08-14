package com.ami_coding_pari_na.ami_coding_pari_na.service.implementation;
import com.ami_coding_pari_na.ami_coding_pari_na.DTO.AuthDTO;
import com.ami_coding_pari_na.ami_coding_pari_na.DTO.KhojDTO;
import com.ami_coding_pari_na.ami_coding_pari_na.model.KhojData;
import com.ami_coding_pari_na.ami_coding_pari_na.model.User;
import com.ami_coding_pari_na.ami_coding_pari_na.repo.KhojRepo;
import com.ami_coding_pari_na.ami_coding_pari_na.repo.RegistrationRepo;
import com.ami_coding_pari_na.ami_coding_pari_na.response.AuthResponse;
import com.ami_coding_pari_na.ami_coding_pari_na.response.KhojResponse;
import com.ami_coding_pari_na.ami_coding_pari_na.response.UserActivityDetailsResponse;
import com.ami_coding_pari_na.ami_coding_pari_na.service.authService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class authImplementation implements authService {
    @Autowired(required = true)
    private RegistrationRepo registrationRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired(required = true)
    private KhojRepo khojRepo;

    @Override
    public AuthResponse login(AuthDTO authDTO) {
        User user1 = registrationRepo.findByEmail(authDTO.getEmail());
        System.out.println("your username and password : " + user1);
         //If user not null.
        if(user1 != null){ //If user not null
            String password = authDTO.getPassword();
            String encodedPassword = user1.getPassword(); //find out the encoded password.user
            Long userId = user1.getId();
            String userEmail = user1.getEmail();
            Boolean isPwdRight = passwordEncoder.matches(password,encodedPassword);
            if (isPwdRight){
                Optional<User> user = registrationRepo.findOneByEmailAndPassword(authDTO.getEmail(), encodedPassword);
                if(user.isPresent()){
                    return new AuthResponse(true, "Login Success ",userId, userEmail);
                }else {
                    return  new AuthResponse(false, "Login Failed");
                }
            }else{
                return  new AuthResponse(false, "Passwords do not match, please retype");
            }
        }else {
            return new AuthResponse(false, "Email does not exist");
        }
    }

    @Override
    public AuthResponse registration(AuthDTO authDTO) {
        //Passing the user DTO value to the domain object (JPA Entity)
        try{
            User existUser = registrationRepo.findByEmail(authDTO.getEmail());
            if(existUser == null){
                User newUser = new User(
                        authDTO.getEmail(),
                        this.passwordEncoder.encode(authDTO.getPassword())
                );
                registrationRepo.save(newUser);
                return new AuthResponse(true, "Registration Successful");
            }else {
                return new AuthResponse(false, "Your email already exist!");
            }
        }catch (NullPointerException e){
            System.out.println("null pointer exception occurred");
            return new AuthResponse(false, "Contact with your api provider");
        }
    }

    @Override
    public KhojResponse khojSubmit(KhojDTO khojDTO) {
        System.out.println("Your khoj data "+ khojDTO);
        KhojData khuj = new KhojData(
                khojDTO.getId(),
            khojDTO.getInputArray(),
            khojDTO.getUserid(),
            khojDTO.getTimeStamp()
        );
        khojRepo.save(khuj);
        return new KhojResponse(true, "data submitted success");
    }

    @Override
    public UserActivityDetailsResponse activityDetails(KhojDTO khojDTO) {
        long user = khojDTO.getUserid();
        List<KhojData> obj = khojRepo.findAllByuserid(user);
//        //catch the last one and first one.
        ArrayList<List<KhojData>> StackFirstLastData = new ArrayList<>();
        List<KhojData> firstActivity = Collections.singletonList(obj.get(0));
        List<KhojData> lastActivity = Collections.singletonList(obj.get(obj.size()-1));
        StackFirstLastData.add(firstActivity);
        StackFirstLastData.add(lastActivity);
        return new UserActivityDetailsResponse("Success", user , StackFirstLastData);
    }
}