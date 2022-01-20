package com.softtech.webApp.dao;

import com.softtech.webApp.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Clients , Long> {

    @Query("select C from Clients C where C.nom like :x")
    public List<Clients> getUserByNom(@Param("x") String nom);

    @Query("select C from Clients C where C.prenom like :x")
    public List<Clients> getUserByPrenom(@Param("x") String prenom);

    @Query("select C from Clients C where C.nom=:x")
    public List<Clients> getUserByNomU(@Param("x") String nom) ;

    @Query("select C from Clients C where C.login =:x and C.mp =:y")
    public Clients findByLoginAndMpIgnoreCase(@Param("x") String login , @Param("y") String mp);

    @Query("select C from Clients C where C.login=:x")
    public Clients findByLogin(@Param("x") String login) ;


}
