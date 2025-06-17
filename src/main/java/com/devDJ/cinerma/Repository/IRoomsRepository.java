package com.devDJ.cinerma.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devDJ.cinerma.Entities.Rooms;

@Repository
public interface IRoomsRepository extends JpaRepository<Rooms,Long> {

}
