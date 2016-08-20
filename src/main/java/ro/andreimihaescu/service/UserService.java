package ro.andreimihaescu.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;
import ro.andreimihaescu.dto.UserRequest;
import ro.andreimihaescu.repository.UserRepository;

import static org.bouncycastle.cms.RecipientId.password;

@Service
public class UserService {

    @Autowired
    private TextEncryptor textEncryptor;

    @Autowired
    private UserRepository userRepository;


    private final static Logger LOGGER = Logger.getLogger(UserService.class);

    public String authenticateUser(String username, String password){
        LOGGER.info(String.format("Attempted to authenticate user with %s and %s", username, password));
        return textEncryptor.encrypt(username);
    }

    public String checkUser(String hash){
        LOGGER.info("Connected user: "+textEncryptor.decrypt(hash));
        return "ok";
    }

    public String createUser(UserRequest userRequest){
        LOGGER.info(String.format("Attempted to create user with %s and %s", userRequest.getUsername(), userRequest.getPassword()));
        return userRepository.createUser(userRequest) ? textEncryptor.encrypt(userRequest.getUsername()): "";
    }
}
