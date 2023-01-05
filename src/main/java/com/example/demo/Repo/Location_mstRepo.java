package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Location_details;
import com.example.demo.Entity.Location_mst;
@Repository
public interface Location_mstRepo extends JpaRepository<Location_mst, Integer>{

	public List<Location_mst> findBylocationId(int locationId);
}
