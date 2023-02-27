package com.ais.techstore.service;


import com.ais.techstore.model.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);
    void deleteById(long id);
    List<Role> getRoles();
    Role getRoleByName(String name);
}
