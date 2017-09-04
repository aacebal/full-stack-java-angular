package com.adelacebal.fullstackappangularspringboot.repository;

import com.adelacebal.fullstackappangularspringboot.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<RoomEntity, Long>{

    List<RoomEntity> finById(Long id);
}
