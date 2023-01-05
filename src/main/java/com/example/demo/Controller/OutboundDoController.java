package com.example.demo.Controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.OutboundDo;
import com.example.demo.Pojo.Read_GIN;
import com.example.demo.Service.OutboundDoService;
@CrossOrigin("*")
@RestController
public class OutboundDoController {

	@Autowired
	private OutboundDoService outboundDoService;
	
	@PostMapping("/post")
	public ResponseEntity<?> addData(@RequestBody Read_GIN read_gin ) throws FileNotFoundException {
		return this.outboundDoService.add(read_gin);
	}
	
	@GetMapping("/pendingOrder")
	public List<OutboundDo> getdata(){
		return this.outboundDoService.getdata();
	}
}
