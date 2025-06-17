package com.devDJ.cinerma.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devDJ.cinerma.Entities.Schedule;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule,Long> {

}
