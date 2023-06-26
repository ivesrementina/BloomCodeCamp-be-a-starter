package com.hcc.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "authority")
    private String authority;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Authority(String authority) {
        this.authority = authority;
    }

    public Long getId() {
        return  id;
    }

    public String getAuthority() {
        return authority;
    }

    public Authority setAuthority(String authority) {
        this.authority = authority;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Authority setUser(User user) {
        this.user = user;
        return this;
    }
}
