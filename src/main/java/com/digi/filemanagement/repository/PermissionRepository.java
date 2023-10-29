package com.digi.filemanagement.repository;


import com.digi.filemanagement.entity.PermissionEntity;
import com.digi.filemanagement.entity.PermissionGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity,Long> {

     Optional<PermissionEntity> findByUserEmailAndPermissionLevel(String userEmail,String permission);
//     Optional<PermissionEntity> findByUserEmailAndPermissionLevelAndGroup(String userEmail,String permission,Long permissionGroup);

}
