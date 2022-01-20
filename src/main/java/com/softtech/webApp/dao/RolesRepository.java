package com.softtech.webApp.dao;


import com.softtech.webApp.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RolesRepository extends JpaRepository<Roles, Long> {

    @Query("select r from Roles r where r.libelle =:x")
    public Roles findRolesByLibelle(@Param("x")String libelle);

}
