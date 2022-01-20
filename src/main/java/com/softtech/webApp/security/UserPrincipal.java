package com.softtech.webApp.security;

// import com.example.polls.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.softtech.webApp.entities.Clients;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private Long idUtil ;
    private String nom ;
    private String prenom ;
    private String login ; // use for connexion
    private String mp ;    // use for connexion

    private Collection<? extends GrantedAuthority> authorities ;



    public UserPrincipal(Long idUtil, String nom, String prenom, String login, String mp, Collection<? extends GrantedAuthority> authorities) {

        this.idUtil = idUtil;
        this.nom = nom;
        this.prenom = prenom;

        this.login = login;
        this.mp = mp;

        this.authorities = authorities;
    }

    public static UserPrincipal create(Clients user) {
        List<GrantedAuthority> authorities = user.getRolesListe().stream().map(role ->
                new SimpleGrantedAuthority(role.getLibelle())
        ).collect(Collectors.toList());

        return new UserPrincipal(
                user.getId(),
                user.getNom(),
                user.getPrenom(),
                user.getLogin(),
                user.getMp(),
                authorities
        );
    }

    public Long getId() {
        return idUtil;
    }

    public String getName() {
        return nom;
    }

    @Override
    public String getUsername() {
        return prenom;
    }

    @Override
    public String getPassword() {
        return mp;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(idUtil, that.idUtil);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUtil);
    }
}
