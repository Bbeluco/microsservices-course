package com.devsuperior.hruser.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @ManyToMany
    @JoinTable(name = "tb_user_role",
            joinColumns = @JoinColumn(name = "fk_user_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_roles_id")
    )
    private Set<RoleEntity> roles = new HashSet<>();
}
