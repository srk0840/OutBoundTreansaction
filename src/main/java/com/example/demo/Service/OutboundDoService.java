package com.example.demo.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Entity.Do_picking;
import com.example.demo.Entity.OutboundDo;
import com.example.demo.Exception.ResponseException;
import com.example.demo.Mapper.OutboundDoMapper;
import com.example.demo.Pojo.Read_GIN;
import com.example.demo.Repo.OutboundDoRepo;

@Service
public class OutboundDoService {
	@Autowired
	private OutboundDoRepo outboundDoRepo;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	int line_id;
	
	
	public ResponseEntity<?> add( Read_GIN body) throws FileNotFoundException 
	{
		String s=body.getFile_name();
		String ss=body.getFile_path();
		
		String path=ss+"/"+s;
		
		ResponseException response=new ResponseException();
		ResponseEntity<Object> entityRes=new ResponseEntity<>(response,HttpStatus.ACCEPTED);

	      File myObj = new File(path);
	      Scanner  myReader = new Scanner(myObj);
	      myReader.nextLine();
	      while (myReader.hasNextLine()) 
	      { 
		        String data = myReader.nextLine();

		        String arr[]=data.split(",");
		     
		        if(arr.length==6) {
		        OutboundDo gn=new OutboundDo();			        
		        gn.setDelivery_order_no(arr[0]); 
		       String date  []=arr[1].split("-");
		       System.out.println(date.length);
		       int y=Integer.parseInt(date[2]);
		       int m=Integer.parseInt(date[1]);
		       int d=Integer.parseInt(date[0]);
		       LocalDate localDate = LocalDate.of(y, m, d );
		      
		       gn.setDo_date(localDate);
		        line_id=Integer.parseInt(arr[2]);
		        gn.setDo_line_item_no(line_id);
		        gn.setSku_code(arr[3]);
		        int z=Integer.parseInt(arr[4]);
		        gn.setSku_qty(z);
		        gn.setOut_bound_station(arr[5]);
		        if( gn.getStatus()==null) {
		        gn.setStatus("pending");}
		        this.outboundDoRepo.save(gn);
		        }
		        else {
		        	response.setMessage("insufficient quantity");
		        	ResponseEntity<Object> entityRes2=new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		        	entityRes = entityRes2;
		        	return entityRes;
		        }
		        
	      }
	      myReader.close();
		        
	 
		 return entityRes;
		 
 	}

	
	public List<OutboundDo> getdata() {
		String order="Select * from outbound_do where status='pending'";
		List<OutboundDo> list=jdbcTemplate.query(order, new OutboundDoMapper());
//		 List<OutboundDo> findAll = this.outboundDoRepo.findAll();
		 return list;
	}
}
