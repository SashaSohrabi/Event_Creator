package com.shahab.mateAcademy.SpringBoot.dao;

import com.shahab.mateAcademy.SpringBoot.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EventDao extends JpaRepository<Event, Integer> {


}
