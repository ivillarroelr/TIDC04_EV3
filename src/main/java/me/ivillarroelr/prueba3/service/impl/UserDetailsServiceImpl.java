package me.ivillarroelr.prueba3.service.impl;

import me.ivillarroelr.prueba3.model.Cliente;
import me.ivillarroelr.prueba3.model.Authority;
import me.ivillarroelr.prueba3.model.Usuario;
import me.ivillarroelr.prueba3.repo.IClienteRepo;
import me.ivillarroelr.prueba3.repo.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IUsuarioRepo repo;

    @Override
    public UserDetails loadUserByUsername(String rut) throws UsernameNotFoundException {

        //Buscar el usuario con el repositorio y si no existe lanzar una exepcion
        Usuario appUser = repo.findByRut(rut).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));

        //Mapear nuestra lista de Authority con la de spring security
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        for (Authority authority: appUser.getAuthority()) {
            // ROLE_USER, ROLE_ADMIN,..
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
            grantList.add(grantedAuthority);
        }

        //Crear El objeto UserDetails que va a ir en sesion y retornarlo.
        UserDetails user = (UserDetails) new User(appUser.getRut(), appUser.getClave(), grantList);
        return user;
    }
}