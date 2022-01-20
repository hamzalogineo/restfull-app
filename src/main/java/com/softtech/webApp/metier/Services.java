package com.softtech.webApp.metier;

import com.softtech.webApp.entities.Clients;
import com.softtech.webApp.entities.Postes;

import java.util.List;

public interface Services {

    // manage client :

    public Clients saveClient(Clients client) ;
    public Clients updateClient(Clients clients , Long id) ;
    public Clients getClient(Long id) ;
    public String deleteClient(Long id) ;
    public List<Clients> getAllClient() ;
    public Clients getClientByLogin(String login) ;


  //  manage poste :

    public Postes savePoste(Postes postes) ;
    public Postes updatePoste(Postes postes , Long ref) ;
    public Postes getPoste(Long ref) ;
    public String deletePoste(Long ref) ;
    public List<Postes> getAllPoste() ;
    // public List<Postes> getAllPosteCl(Integer id) ;


}
