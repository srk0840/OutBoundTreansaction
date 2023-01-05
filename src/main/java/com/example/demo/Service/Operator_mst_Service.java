package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Operator_mst;
import com.example.demo.Repo.Operator_mst_Repo;

@Service
public class Operator_mst_Service {
	
	@Autowired
	private Operator_mst_Repo operator_mst_Repo;
	
	
	public List<Operator_mst> getAll(){
		return this.operator_mst_Repo.findAll();
	}

}
