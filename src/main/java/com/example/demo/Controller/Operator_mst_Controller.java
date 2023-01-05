package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Operator_mst;
import com.example.demo.Service.Operator_mst_Service;
@CrossOrigin("*")
@RestController
public class Operator_mst_Controller {
@Autowired
	private Operator_mst_Service operator_mst_Service;
	
	@GetMapping("/getOperatorList")
		public List<Operator_mst> getAll(){
			return this.operator_mst_Service.getAll();
		}
}
