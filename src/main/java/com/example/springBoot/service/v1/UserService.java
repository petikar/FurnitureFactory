package com.example.springBoot.service.v1;

import com.example.springBoot.model.v1.User;
import com.example.springBoot.repository.v1.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User findById(int id){
        return userRepository.getOne(id); //it's method use a lazy load operation. It's can using with @JsonIgnoreProperties({"hibernateLazyInitializer"})(class Material)
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }


}
