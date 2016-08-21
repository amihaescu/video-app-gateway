package ro.andreimihaescu.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ro.andreimihaescu.dto.UserRequest;

@Repository
public class UserRepository {

    @Autowired
    private RestTemplate restTemplate;

    public Boolean createUser(UserRequest userRequest) {
        return restTemplate.postForEntity("http://user-service/users/create", userRequest, Boolean.class).getBody();
    }

    public Boolean authenticateUser(UserRequest userRequest){
        return restTemplate.postForEntity("http://user-service/users/authenticate", userRequest, Boolean.class).getBody();
    }

}
