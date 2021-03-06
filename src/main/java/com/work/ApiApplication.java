package com.work;

import com.work.api.domain.User;
import com.work.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userRepository.save(new User("member1",bCryptPasswordEncoder.encode("member1!")));
        userRepository.save(new User("member2",bCryptPasswordEncoder.encode("member2!")));
        userRepository.save(new User("member3",bCryptPasswordEncoder.encode("member3!")));
    }
}
