package com.softtech.webApp.metier;


import com.softtech.webApp.dao.RolesRepository;
import com.softtech.webApp.entities.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceRoles {
    @Autowired
    private RolesRepository rolesRepository ;

    public Roles createRole(Roles roles){
        return rolesRepository.save(roles);
    }

    public boolean updateRole(Long id, Roles roles){
        roles.setIdRol(id);
        rolesRepository.save(roles) ;
        return true ;
    }

    public String deleteRole(Long id){
        rolesRepository.delete(rolesRepository.getOne(id));
        return "Suppression reussit " ;
    }

    public Roles getAllRole(Long id){
        return rolesRepository.getOne(id) ;
    }
    public List<Roles> getAllRle(){
        return rolesRepository.findAll();
    }




}
