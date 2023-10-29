package com.digi.filemanagement.repository;


import com.digi.filemanagement.entity.FileEntity;
import com.digi.filemanagement.entity.ItemEntity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity,Long> {

    @Modifying
    @Query(value = "insert into file (content,item_id) VALUES (:content,:item_id)", nativeQuery = true)
    @Transactional
    void saveFile(@Param("content") byte[] content, @Param("item_id") Long item_id);

}
