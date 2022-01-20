package com.softtech.webApp.metier;

import com.softtech.webApp.dao.ClientRepository;
import com.softtech.webApp.dao.PosteRepository;
import com.softtech.webApp.entities.Clients;
import com.softtech.webApp.entities.Postes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ServiceImpl implements Services{

    @Autowired
    private ClientRepository manageClient ;

    @Autowired
    private PosteRepository managePoste ;


    @Override
    public Clients saveClient(Clients client) {

        Clients clients = null ;

        clients = manageClient.save(client) ;

        return clients;
    }

    @Override
    public Clients updateClient(Clients clients, Long id) {

        Clients cl = null ;
        clients.setId(id) ;
        cl = manageClient.saveAndFlush(clients) ;

        return cl ;
    }

    @Override
    public Clients getClient(Long id) {

        Clients clients = null ;

        Optional<Clients> optionalClients = manageClient.findById(id) ;

        if(optionalClients.isPresent()){
            clients = optionalClients.get() ;
        }else{
            clients = null ;
        }

        return clients;
    }

    @Override
    public String deleteClient(Long id) {
        manageClient.deleteById(id) ;
        return new String("CLIENT DELETED SUCCESSFULL") ;
    }

    @Override
    public List<Clients> getAllClient() {
        return manageClient.findAll() ;
    }

    @Override
    public Clients getClientByLogin(String login) {

        Clients clients = null ;

        clients = manageClient.findByLogin(login) ;


        return clients;
    }

    @Override
    public Postes savePoste(Postes postes) {

        Postes pos = null ;

        pos = managePoste.save(postes) ;

        return pos;

    }

    @Override
    public Postes updatePoste(Postes postes, Long ref) {

        Postes pos = null ;

       postes.setRef(ref) ;

       pos = managePoste.saveAndFlush(postes) ;

        return pos ;
    }

    @Override
    public Postes getPoste(Long ref) {
        return managePoste.getById(ref) ;
    }

    @Override
    public String deletePoste(Long ref) {

        managePoste.deleteById(ref) ;

        return new String("POSTE DELETED SUCCESSFULL") ;
    }

    @Override
    public List<Postes> getAllPoste() {
        return managePoste.findAll();
    }




}
