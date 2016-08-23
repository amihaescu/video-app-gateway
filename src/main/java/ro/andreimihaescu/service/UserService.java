package ro.andreimihaescu.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;
import ro.andreimihaescu.dto.UserRequest;
import ro.andreimihaescu.repository.RoleRepository;
import ro.andreimihaescu.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private TextEncryptor textEncryptor;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    private final static Logger LOGGER = Logger.getLogger(UserService.class);

    public String authenticateUser(UserRequest userRequest){
        LOGGER.info(String.format("Attempted to authenticate user with %s", userRequest.getUsername()));
        Boolean isUserAuthenticated = userRepository.authenticateUser(userRequest);
        return isUserAuthenticated ? textEncryptor.encrypt(userRequest.getUsername()):  "";
    }

    public String checkUser(String hash){
        LOGGER.info("Connected user: "+textEncryptor.decrypt(hash));
        return "ok";
    }

    public String createUser(UserRequest userRequest){
        LOGGER.info(String.format("Attempted to create user %s", userRequest.getUsername()));
        Boolean aBoolean = userRepository.createUser(userRequest);
        LOGGER.info(String.format("User creation was successful %s", aBoolean));
        return aBoolean ? textEncryptor.encrypt(userRequest.getUsername()): "";
    }
}
