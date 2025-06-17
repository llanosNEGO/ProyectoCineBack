package com.devDJ.cinerma.Repository;

import com.devDJ.cinerma.Entities.Dulceria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDulceriaRepository extends JpaRepository<Dulceria, Long> {
}