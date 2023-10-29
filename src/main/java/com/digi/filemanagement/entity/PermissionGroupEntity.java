package com.digi.filemanagement.entity;

import com.digi.filemanagement.enumeration.PermissionEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "permission_group")
@Builder
public class PermissionGroupEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @OneToMany(mappedBy = "group", cascade =CascadeType.ALL)
    private List<PermissionEntity> permissions;

}
