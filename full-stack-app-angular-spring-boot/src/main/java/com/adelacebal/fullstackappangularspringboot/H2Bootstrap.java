package com.adelacebal.fullstackappangularspringboot;

import com.adelacebal.fullstackappangularspringboot.entity.RoomEntity;
import com.adelacebal.fullstackappangularspringboot.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class H2Bootstrap implements CommandLineRunner{

    @Autowired
    RoomRepository roomRepository;

    @Override
    public void run(String... args) throws Exception {
        roomRepository.save(new RoomEntity(405, "200"));
        roomRepository.save(new RoomEntity(406, "210"));
        roomRepository.save(new RoomEntity(406, "220"));

        Iterable<RoomEntity> itr = roomRepository.findAll();

        for (RoomEntity room: itr) {
            System.out.println(room.getRoomNumber());
        }
    }
}
