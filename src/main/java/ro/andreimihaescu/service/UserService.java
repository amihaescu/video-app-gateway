package ro.andreimihaescu.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;
import ro.andreimihaescu.dto.RoleRequest;
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
        Long userId = userRepository.createUser(userRequest);
        LOGGER.info(String.format("User creation was successfully created with id %s", userId));
        Boolean returnValue = false;
        if (userId != 0){
            returnValue = roleRepository.addRoleForUserId(new RoleRequest(userId, userRequest));
        }
        LOGGER.info(String.format("User role was successful %s", returnValue));
        return returnValue ? textEncryptor.encrypt(userRequest.getUsername()): "";
    }
}
