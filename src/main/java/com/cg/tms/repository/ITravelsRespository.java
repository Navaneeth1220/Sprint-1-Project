package com.cg.tms.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tms.entities.Booking;
import com.cg.tms.entities.Travels;

public interface ITravelsRespository extends JpaRepository<Travels,Integer> {
	


}
