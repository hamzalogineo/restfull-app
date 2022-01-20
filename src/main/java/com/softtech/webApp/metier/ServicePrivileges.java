package com.softtech.webApp.metier;


import com.softtech.webApp.dao.PrivilegesRepository;
import com.softtech.webApp.entities.Privileges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServicePrivileges {
    @Autowired
    private PrivilegesRepository privilegesRepository ;

    public Privileges createPrivi(Privileges privileges){
        return privilegesRepository.save(privileges) ;
    }

    public boolean updatePrivi(Long id, Privileges privileges){
        privileges.setIdPriv(id);
        privilegesRepository.save(privileges) ;
        return true ;
    }

    public String deletePrivi(Long id){
        privilegesRepository.delete(privilegesRepository.getOne(id));
        return "suppression reussit" ;
    }

    public Privileges getPrivi(Long id){
        return privilegesRepository.getOne(id) ;
    }

    public List<Privileges> getPrivis(){
        return privilegesRepository.findAll() ;
    }


}
