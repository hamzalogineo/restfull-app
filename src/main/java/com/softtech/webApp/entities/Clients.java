package com.softtech.webApp.entities;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// import javax.validation.constraints.NotNull;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
@Entity
public class Clients implements Serializable{


    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    private String prenom;

   // @NotNull(message = "login")
    private String login;

   // @NotNull(message = "login")
    private String mp;


    @OneToMany
    @JoinColumn(name = "client" , referencedColumnName = "id")
    private Collection<Postes> postes ;

    @OneToMany
    @JoinColumn(name = "client" , referencedColumnName = "id")
    private List<Roles> rolesListe ;


    public Clients(){}

    public Clients(String nom, String prenom, String login, String mp) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mp = mp;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return prenom;
    }


    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public String getLogin() {
        return login;
    }


    public void setLogin(String login) {
        this.login = login;
    }


    public String getMp() {
        return mp;
    }


    public void setMp(String mp) {
        this.mp = mp;
    }


    public Collection<Postes> getPostes() {
        return postes;
    }


    public void setPostes(Collection<Postes> postes) {
        this.postes = postes;
    }

    public List<Roles> getRolesListe() {
        return rolesListe;
    }

    public void setRolesListe(List<Roles> rolesListe) {
        this.rolesListe = rolesListe;
    }
}
