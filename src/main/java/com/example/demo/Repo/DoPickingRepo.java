package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Do_picking;

@Repository
public interface DoPickingRepo extends JpaRepository<Do_picking, Integer>{
	
	Do_picking findBystatus(String status);
	Do_picking findById(int picking_id);
	
	List<Do_picking> findByoperatorEmpCode(String operatorEmpCode);
}
