package com.softtech.webApp.dao;

import com.softtech.webApp.entities.Postes ;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository ;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PosteRepository extends JpaRepository<Postes , Long> {

    /*

    @Query("select p from Postes p where p.clients.CODE_CLI=:x order by jour desc")
    public List<Postes> toutLesPostesByClient(@Param("x") Integer id) ;
  */

  }
