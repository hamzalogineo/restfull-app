package com.softtech.webApp.controller;

import com.softtech.webApp.entities.*;
import com.softtech.webApp.metier.ServiceImpl;
import com.softtech.webApp.metier.ServicePrivileges;
import com.softtech.webApp.metier.ServiceRoles;
import com.softtech.webApp.metier.ServiceRp;
import com.softtech.webApp.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

 // @Valid
//  import javax.validation.Valid ;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiRestFull {

    @Autowired
    private ServiceImpl services ;

    @Autowired
    private ServicePrivileges servicePrivileges ;

    @Autowired
    private ServiceRoles serviceRoles ;

    @Autowired
    private ServiceRp serviceRp ;


    @Autowired
    AuthenticationManager authenticationManager ;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    // fin pour la declaration des instances .

    // -------------------------------- connexion ------------------------------------

    // sign-in : pour authentification :

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(jwt) ;
    }

    // fin de generation de mon token :


    //----------------------------------------------------------------------------------




    // end :

    // Gestion des privileges
    @PostMapping("/createprivil")
    public Privileges createPrivi(@RequestBody Privileges privileges){
        return  servicePrivileges.createPrivi(privileges) ;
    }
    @PutMapping("/updateprivil/{id}")
    public boolean updatePrivi(@PathVariable Long id , @RequestBody Privileges privileges){

        return servicePrivileges.updatePrivi(id, privileges) ;

    }
    @DeleteMapping("/deleteprivil/{id}")
    public String deletePrivil(@PathVariable Long id){

        return servicePrivileges.deletePrivi(id) ;

    }

    @GetMapping("/getoneprivi/{id}")
    public Privileges getOnePrivi(@PathVariable Long id){

        return servicePrivileges.getPrivi(id) ;

    }

    @GetMapping("/allprivilege")
    public List<Privileges> getAllPrivi(){
        return servicePrivileges.getPrivis();
    }

    // -------------------------------------------------------------------------------------------------------------------


    // Gestion des roles :
    @PostMapping("/createrole")
    public Roles createRole(@RequestBody Roles roles) {
        return  serviceRoles.createRole(roles) ;
    }
    @PutMapping("/updateroles/{id}")
    public boolean updateRole(@PathVariable Long id, @RequestBody Roles roles){
        return serviceRoles.updateRole(id, roles);
    }
    @DeleteMapping("/deleterole/{id}")
    public String deleteRoles(@PathVariable Long id){
        return serviceRoles.deleteRole(id) ;
    }
    @GetMapping("/getonerole/{id}")
    public Roles getOneRole(@PathVariable Long id){
        return serviceRoles.getAllRole(id);
    }
    @GetMapping("/allroles")
    public List<Roles> getAllRole(){
        return serviceRoles.getAllRle();
    }
    // ---------------------------------------------------------------------------------------------------------
    // gestion roles et privileges :
    @PostMapping("/createrp")
    public Rp createRp(@RequestBody Rp rp){

        return serviceRp.createRp(rp) ;
    }
    @PutMapping("/updateRp/{id}")
    public boolean updateRp(@PathVariable Long id, @RequestBody Rp rp){
        return serviceRp.updateRp(id, rp);
    }
    @DeleteMapping("/deleterp/{id}")
    public String deleterp(@PathVariable Long id){
        return serviceRp.deleteRp(id) ;
    }
    @GetMapping("/getonerp/{id}")
    public Rp getOneRp(@PathVariable Long id){

        return serviceRp.getOneRp(id) ;
    }
    @GetMapping("/getallrp")
    public List<Rp> getAllRp(){
        return serviceRp.getAllRp() ;
    }

    // -----------------------------------------------------------------------------------------------------------


    // Gestion Clients :

    @RequestMapping(value = "/clients" , method = RequestMethod.GET)
    public List<Clients> getAllClient(){
        return services.getAllClient() ;
    }

    @RequestMapping(value = "/clients/{id}" , method = RequestMethod.GET)
    public Clients getOneClient(@PathVariable("id") Long id){

        return services.getClient(id) ;

    }


    @RequestMapping(value = "/clients_/{login}" , method = RequestMethod.GET)
    public Clients getClientByLogin(@PathVariable("login") String login){

        return services.getClientByLogin(login) ;

        }


    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public Clients saveClient(@RequestBody Clients clients ){

        return services.saveClient(clients) ;

    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
    public Clients updateClient(@RequestBody Clients clients , @PathVariable("id") Long id){

        return services.updateClient(clients, id) ;

    }


    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    public String deleteClient(@PathVariable("id") Long id){

        return services.deleteClient(id) ;

      }


    // gestion des postes :

    @RequestMapping(value = "/postes" , method = RequestMethod.GET)
    public List<Postes> getAllPoste(){
        return services.getAllPoste() ;
    }

    @RequestMapping(value = "/postes/{id}" , method = RequestMethod.GET)
    public Postes getOnePoste(@PathVariable("id") Long id){

        return services.getPoste(id) ;

    }

    @RequestMapping(value = "/postes", method = RequestMethod.POST)
    public Postes savePoste(@RequestBody Postes postes ){

        return services.savePoste(postes) ;

    }

    @RequestMapping(value = "/postes/{id}", method = RequestMethod.PUT)
    public Postes updatePoste(@RequestBody Postes postes , @PathVariable("id") Long id){

        return services.updatePoste(postes, id) ;

    }


    @RequestMapping(value = "/postes/{id}", method = RequestMethod.DELETE)
    public String deletePoste(@PathVariable("id") Long id){

        return services.deletePoste(id) ;

    }



  // fin de notre micro service , web service , service restfull etc : OUr BACK-END : ENGINE MOTEUR JEE.

}
