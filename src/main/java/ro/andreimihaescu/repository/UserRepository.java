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
        //srestTemplate.postForEntity("",userRequest, Boolean.class);
        return true;
    }

}
