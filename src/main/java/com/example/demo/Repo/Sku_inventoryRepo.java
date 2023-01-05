package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Sku_inventory;
@Repository
public interface Sku_inventoryRepo extends JpaRepository<Sku_inventory, Integer>{

	public List<Sku_inventory> findByskuCode(String skuCode);
	
}
