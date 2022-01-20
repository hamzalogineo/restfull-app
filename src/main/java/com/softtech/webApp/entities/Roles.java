package com.softtech.webApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Roles implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol ;

    private String libelle ;



    @Column(name = "client")
    private Long client ;



    @OneToMany
    @JoinColumn(name = "role", referencedColumnName = "id_rol")
    private List<Rp> rps ;

    public Roles() {
    }

    public Roles(String libelle , Long client)
    {
        this.libelle = libelle;
        this.client = client;
    }


    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Long getUtilisateursId() {
        return client;
    }

    public void setUtilisateursId(Long utilisateursId) {
        this.client = utilisateursId;
    }

    public List<Rp> getRps() {
        return rps;
    }

    public void setRps(List<Rp> rps) {
        this.rps = rps;
    }


}
