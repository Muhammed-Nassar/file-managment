package com.digi.filemanagement.entity;

import com.digi.filemanagement.enumeration.ItemTypeEnum;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@Entity
@Table(name = "item" ,catalog = "", schema = "")
public class ItemEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ItemTypeEnum type;

    @Column(name = "name")
    private String name;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "permission_group_id")
    private PermissionGroupEntity permissionGroupEntity;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private ItemEntity parentId;

}

