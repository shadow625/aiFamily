package com.model.entity;

import lombok.Data;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "t_user")
public class User
{
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private Date create_time;
}
