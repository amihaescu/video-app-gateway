package ro.andreimihaescu.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ro.andreimihaescu.dto.RoleRequest;

@Repository
public class RoleRepository {

    @Autowired
    private RestTemplate restTemplate;

    public boolean addRoleForUserId(RoleRequest roleRequest){
        return restTemplate.postForEntity("http://user-service/users/create", roleRequest, Boolean.class).getBody();
    }
}
