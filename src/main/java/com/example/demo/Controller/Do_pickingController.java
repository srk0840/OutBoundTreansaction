package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Do_picking;
import com.example.demo.Entity.OutboundDo;
import com.example.demo.Entity.Sku_inventory;
import com.example.demo.Service.Do_pickingService;

@CrossOrigin("*")
@RestController
public class Do_pickingController {

	@Autowired
	private Do_pickingService do_pickingService;

	@PostMapping("/exe_orders")
	public ResponseEntity<?> executeOrder(@RequestBody List<OutboundDo> outboundDo) {
//		System.out.println(outboundDo);
		 return do_pickingService.executeOrder(outboundDo);

	}

	@GetMapping("/assign_Retrive_pallet")
	public List<Do_picking> retrivePallet() {
		return this.do_pickingService.show_retrivePalletScreen();
	}
	
	@GetMapping("/assign_picking_sku")
	public List<Do_picking> pickingSku(){
		return this.do_pickingService.show_Picking_Sku_Screen();
	}
	
	@GetMapping("/dispatchTaskAssign")
	public List<Do_picking> dispatchSku(){
		return this.do_pickingService.dispatch_Sku_Screen();
	}
	
	
	@PostMapping("/palletRetriveTaskAssign")
	public void AssignPallet(@RequestBody List<Do_picking> do_pickings) {
		this.do_pickingService.palletRetrivetaskAssign(do_pickings);
	}
	
	@PostMapping("/PickingSkuTaskAssign")
	public void Assign_Picking_Sku(@RequestBody List<Do_picking> do_pickings) {
		this.do_pickingService.picking_Sku_taskAssign(do_pickings);
	}
	
	
	@PostMapping("/dispatchTaskAssign")
	public void Assign_dispatch(@RequestBody List<Do_picking> do_pickings) {
		this.do_pickingService.dispatch_taskAssign(do_pickings);
	}
	
	
	@GetMapping("/taskList/{operatorEmpCode}")
	public List<Do_picking> taskList( @PathVariable String operatorEmpCode){
		return this.do_pickingService.TaskList(operatorEmpCode);
	}
	
	
}
