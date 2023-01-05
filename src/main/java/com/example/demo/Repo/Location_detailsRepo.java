package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Location_details;
import com.example.demo.Entity.Sku_inventory;
@Repository
public interface Location_detailsRepo extends JpaRepository<Location_details, Integer> {
	
	public List<Location_details> findByskuCode(String skuCode);

}
