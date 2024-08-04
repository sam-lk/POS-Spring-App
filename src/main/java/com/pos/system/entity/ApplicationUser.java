package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name="application_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUser {
    @Id
    @Column(name="user_id", length = 80)
    private String userID;
    @Column(name="user_name")
    private String userName;
    @Column(name="full_name")
    private String fullName;
    @Column(name="is_account_non_expired", columnDefinition = "TINYINT")
    private boolean isAccountNonExpired;
    @Column(name="is_crendentials_non_expired", columnDefinition = "TINYINT")
    private boolean isCrendentialsNonExpired;
    @Column(name="is_account_non_locked", columnDefinition = "TINYINT")
    private boolean isAccountNonLocked;
    @Column(name="is_enabled", columnDefinition = "TINYINT")
    private boolean isEnabled;

    //Creating many-to-many relation with ApplicationUser.java & UserRole.java
    @ManyToMany
    @JoinTable(
            name = "user_has_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<UserRole> userRoles = new HashSet<>();

    //Creating relation with ApplicationUser.java & Batch.java
    @OneToMany(mappedBy = "createdBy")
    private Set<Batch> batchList= new HashSet<>();

    @OneToMany(mappedBy = "verifiedPerson")
    private Set<Refund> refunds;
}
