package com.adelacebal.fullstackappangularspringboot.repository;

import com.adelacebal.fullstackappangularspringboot.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<RoomEntity, Long>{

    RoomEntity findById(Long id);
}
