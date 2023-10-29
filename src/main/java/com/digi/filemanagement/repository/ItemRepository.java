package com.digi.filemanagement.repository;


import com.digi.filemanagement.entity.ItemEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,Long> {

    @Override
    @NonNull
    Optional<ItemEntity> findById(@NonNull Long aLong);
}
