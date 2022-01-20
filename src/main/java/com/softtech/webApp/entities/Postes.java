package com.softtech.webApp.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
@Entity
public class Postes implements Serializable{


    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ref")
    private Long ref ;

    @Column(name = "message")
    private String message ;

    private String jour;

    @Column(name = "client")
    private Long client ;

    public Postes(){}


    public Postes(String message, String jour, Long clients) {
        this.message = message;
        this.jour = jour;
        this.client = clients;
    }


    public Long getRef() {
        return ref;
    }


    public void setRef(Long ref) {
        this.ref = ref;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public String getJour() {
        return jour;
    }


    public void setJour(String jour) {
        this.jour = jour;
    }


    public Long getClients() {
        return client;
    }


    public void setClients(Long clients) {
        this.client = clients;
    }

}
