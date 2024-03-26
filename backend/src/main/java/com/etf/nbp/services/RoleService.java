package com.etf.nbp.services;

import com.etf.nbp.domains.Role;
import com.etf.nbp.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Gets all roles from database
     *
     * @return list of {@link Role}
     */
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    /**
     * Gets the role that have the provided id
     *
     * @param id id of the role
     * @return found {@link Role}
     */
    public Role findById(int id) {
        return roleRepository.findById(id);
    }

    /**
     * Gets the role that have the provided name
     *
     * @param name name of the role
     * @return found {@link Role}
     */
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    /**
     * Saves or updates provided role to database
     *
     * @param role provided role
     * @return saved {@link Role}
     */
    public Role saveOrUpdate(Role role) {
        return roleRepository.saveAndFlush(role);
    }

}
