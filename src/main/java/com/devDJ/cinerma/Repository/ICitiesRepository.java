package com.devDJ.cinerma.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devDJ.cinerma.Entities.Cities;

@Repository
public interface ICitiesRepository extends JpaRepository<Cities,Long> {


}
