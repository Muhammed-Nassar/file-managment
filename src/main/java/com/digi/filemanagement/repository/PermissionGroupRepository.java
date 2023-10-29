package com.digi.filemanagement.repository;


import com.digi.filemanagement.entity.ItemEntity;
import com.digi.filemanagement.entity.PermissionGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionGroupRepository extends JpaRepository<PermissionGroupEntity,Long> {

     Optional<PermissionGroupEntity> findByGroupName(String name);

}
