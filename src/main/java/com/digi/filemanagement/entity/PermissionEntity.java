package com.digi.filemanagement.entity;

import com.digi.filemanagement.dto.common.PermissionDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Entity
@Table(name = "permission")
@NoArgsConstructor
public class PermissionEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "permission_level")
    private String permissionLevel;

    @ManyToOne(fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private PermissionGroupEntity group;

    // Getters and setters

    public PermissionEntity(PermissionDTO permissionDTO) {
        super();
        this.userEmail=permissionDTO.getUserEmail();
        this.permissionLevel=permissionDTO.getPermissionLevel();
    }
}

