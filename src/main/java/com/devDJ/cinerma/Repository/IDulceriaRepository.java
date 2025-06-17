package com.devDJ.cinerma.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devDJ.cinerma.Entities.Dulceria;

@Repository
public interface IDulceriaRepository extends JpaRepository<Dulceria,Long> {

} 