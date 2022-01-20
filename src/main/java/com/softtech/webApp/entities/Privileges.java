package com.softtech.webApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Privileges implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_priv")
    private Long idPriv ;

    private String libelle ;


    @OneToMany
    @JoinColumn(name = "privilege_id", referencedColumnName = "id_priv")
    private List<Rp> rps ;

    public Privileges() {
    }



    public Privileges(String libelle) {

        this.libelle = libelle;
    }

    public Long getIdPriv() {
        return idPriv;
    }

    public void setIdPriv(Long idPriv) {
        this.idPriv = idPriv;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Rp> getRps() {
        return rps;
    }

    public void setRps(List<Rp> rps) {
        this.rps = rps;
    }
}
