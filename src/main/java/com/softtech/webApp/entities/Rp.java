package com.softtech.webApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Rp implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_rp")
    private Long idRp ;

     // @JsonIgnore
    // @ManyToOne

    @Column(name = "role")
    private Long rolesId ;

   // @JsonIgnore
   // @ManyToOne

    @Column(name = "privilege_id")
    private Long privilegesId ;

    public Rp() {
    }

    public Rp(Long rolesId, Long privilegesId) {
        this.rolesId = rolesId;
        this.privilegesId = privilegesId;
    }

    public Long getIdRp() {
        return idRp;
    }

    public void setIdRp(Long idRp) {
        this.idRp = idRp;
    }

    public Long getRoles() {
        return rolesId;
    }

    public void setRoles(Long rolesId) {
        this.rolesId = rolesId;
    }

    public Long getPrivileges() {
        return privilegesId;
    }

    public void setPrivileges(Long privilegesId) {
        this.privilegesId = privilegesId;
    }
}
