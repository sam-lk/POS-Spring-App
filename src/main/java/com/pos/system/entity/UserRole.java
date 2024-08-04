package com.pos.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name="user_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @Id
    @Column(name="role_id", length = 80)
    private String roleId;

    @Column(name="role_name", unique = true, nullable = false)
    private String roleName;

    //Creating many-to-many relation with ApplicationUser.java & UserRole.java
    @ManyToMany(mappedBy = "userRoles")
    private Set<ApplicationUser> applicationUsers= new HashSet<>();
}
