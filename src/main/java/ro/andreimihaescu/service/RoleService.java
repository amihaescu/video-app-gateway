package ro.andreimihaescu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.andreimihaescu.dto.RoleRequest;
import ro.andreimihaescu.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public boolean addRoleForUserId(RoleRequest roleRequest){
        return roleRepository.addRoleForUserId(roleRequest);
    }

}
