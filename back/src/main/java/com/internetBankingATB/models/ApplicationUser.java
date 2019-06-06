package com.internetBankingATB.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity(name = "USER")
@Getter
@Setter
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String userName;
    private String login;
    private String password;
    private String role;
    private String phoneNum;
    private String email;
    private Date creationDate;
    private Date updatedDate;

    private static final String ROLE_PREFIX = "ROLE_";

    @OneToMany(fetch = FetchType.LAZY)
    private List<Address> address;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Account> accounts;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Card> cards;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Checks> checks;

    @OneToMany(fetch = FetchType.LAZY)
    private List<ClientRequest> requests;

    public ApplicationUser() {
        super();
    }


    public ApplicationUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        Arrays.stream(role.split(",")).forEach(r -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + r)));

        // list.save(new SimpleGrantedAuthority(ROLE_PREFIX + role));

        return list;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
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


}
