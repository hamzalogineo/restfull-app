package com.softtech.webApp.metier;



import com.softtech.webApp.dao.RpRepository;
import com.softtech.webApp.entities.Rp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceRp {
    @Autowired
    private RpRepository rpRepository;

    public Rp createRp(Rp rp){
       return rpRepository.save(rp);
    }

    public boolean updateRp(Long id, Rp rp){
        rp.setIdRp(id);
        rpRepository.save(rp);
        return true ;
    }

    public String deleteRp(Long id){
        rpRepository.deleteById(id) ;
        return "suppression reussit" ;
    }

    public Rp getOneRp(Long id){
        return rpRepository.getOne(id) ;
    }

    public List<Rp> getAllRp(){
        return rpRepository.findAll() ;
    }




}
