package com.devDJ.cinerma.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devDJ.cinerma.Entities.Cinemas;

@Repository
public interface ICinemasRepository  extends JpaRepository<Cinemas,Long>{


}
