package com.digi.filemanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;

@Data
@Entity
@Table(name = "file")

public class FileEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    //Column name "binary" is Postgres reserved word.
    @Column(name = "content",nullable = false, columnDefinition = "bytea")
    private Blob content;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private ItemEntity itemEntity;

//    public FileEntity(byte[] content, ItemEntity itemEntity)  {
//        super();
//        this.setContent( content);
//        this.itemEntity = itemEntity;
//    }

    public FileEntity() {

    }
}

