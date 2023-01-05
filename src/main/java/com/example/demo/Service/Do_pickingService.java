package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Entity.Do_history;
import com.example.demo.Entity.Do_picking;
import com.example.demo.Entity.Location_details;
import com.example.demo.Entity.Location_mst;
import com.example.demo.Entity.OutboundDo;
import com.example.demo.Entity.Sku_inventory;
import com.example.demo.Exception.Insufficient;
import com.example.demo.Exception.ResponseException;
import com.example.demo.Mapper.Do_pickingRowMapper;
import com.example.demo.Repo.DoPickingRepo;
import com.example.demo.Repo.Location_detailsRepo;
import com.example.demo.Repo.Location_mstRepo;
import com.example.demo.Repo.Sku_inventoryRepo;

@Service
public class Do_pickingService {
	@Autowired
	private DoPickingRepo doPickingRepo;

	@Autowired
	private Sku_inventoryRepo sku_inventoryRepo;
	@Autowired
	private Location_detailsRepo location_detailsRepo;
	@Autowired
	private Location_mstRepo location_mstRepo;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	String O_out_bound_station;
	String O_delivery_order_no;
	String O_sku_code;
	int do_line_item_no;
	String O_status;

	String LD_Sku_Code;
	int LD_qty;
	int LD_location_id;
	String LD_pallet_id;

	int LM_location_id;

	int MasterloctionID;
	String aisle;
	String direction;
	int slevel;
	int aislePostion;
	Sku_inventory skuInventory = new Sku_inventory();

	@ExceptionHandler(Insufficient.class)
	public ResponseEntity<?> executeOrder(List<OutboundDo> outboundDolist) {

		ResponseException response = new ResponseException();
		ResponseEntity<Object> entityRes = new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		OutboundDo out = new OutboundDo();
		Sku_inventory sku_inventory = new Sku_inventory();
		for (int i = 0; i < outboundDolist.size(); i++) {
			out = outboundDolist.get(i);
			int O_do_id = out.getDo_id();
			O_delivery_order_no = out.getDelivery_order_no();
			O_out_bound_station = out.getOut_bound_station();
			do_line_item_no = out.getDo_line_item_no();
			int O_sku_qty = out.getSku_qty();
			O_sku_code = out.getSku_code();

			List<Sku_inventory> sku_inventrylist = sku_inventoryRepo.findByskuCode(O_sku_code);
			for (int j = 0; j < sku_inventrylist.size(); j++) {
				sku_inventory = sku_inventrylist.get(j);
				String sku_inventory_sku_code = sku_inventory.getSkuCode();
				int sku_inventory_qantity = sku_inventory.getQantity();
				boolean value = sku_inventory_sku_code.equals(O_sku_code);
				if (value) {
					if (sku_inventory_qantity >= O_sku_qty) {
						sku_inventory_qantity -=   O_sku_qty;
						String update_sku_inventory_qantity = "UPDATE sku_inventory SET qantity="
								+ sku_inventory_qantity + " where sku_code='" + O_sku_code + "'";
						this.jdbcTemplate.update(update_sku_inventory_qantity);

						String update_O_status = "update outbound_do set status=" + "'processing'" + " where sku_code='"
								+ O_sku_code + "'and delivery_order_no ='" + O_delivery_order_no + "'";

						this.jdbcTemplate.update(update_O_status);

					} else {
						ResponseEntity<Object> entityRes1 = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
						response.setMessage("insufficient quantity");
//						System.out.println("insufficient quantity");
						// throw new Insufficient(400,"hello");;
						entityRes = entityRes1;
						return entityRes;
					}
				}
			}

			Location_details ld = new Location_details();
			List<Location_details> ld_list = this.location_detailsRepo.findByskuCode(O_sku_code);
			for (int k = 0; k < ld_list.size(); k++) {
				ld = ld_list.get(k);
				LD_location_id = ld.getLocation_id();
				LD_pallet_id = ld.getPallet_id();
				LD_qty = ld.getQuantity();
				LD_Sku_Code = ld.getSku_code();
				boolean value1 = LD_Sku_Code.equals(O_sku_code);
				if (value1) {
					Do_picking do_pick = new Do_picking();
					Location_mst lm = new Location_mst();
					List<Location_mst> lm_list = this.location_mstRepo.findBylocationId(LD_location_id);
					for (int l = 0; l < lm_list.size(); l++) {
						lm = lm_list.get(l);
						MasterloctionID = lm.getLocation_id();
						if (MasterloctionID == LD_location_id) {
							aisle = lm.getAisle();
							direction = lm.getDirection();
							slevel = lm.getShelf_level();
							aislePostion = lm.getAisle_position();

							do_pick.setOrder_no(O_delivery_order_no);
							do_pick.setSku_code(LD_Sku_Code);
							do_pick.setSku_qty(LD_qty);
							do_pick.setAisle(aisle);
							do_pick.setDirection(direction);
							do_pick.setSelf_level(slevel);
							do_pick.setAisle_postion(aislePostion);
							do_pick.setLocation_id(LD_location_id);
							do_pick.setOut_bound_station(O_out_bound_station);
							do_pick.setPallet_id(LD_pallet_id);
							do_pick.setStatus("processing");
							this.doPickingRepo.save(do_pick);

							Do_history do_history = new Do_history();

						}
					}

					String query = "DELETE FROM location_details WHERE pallet_id='" + LD_pallet_id + "'";
					this.jdbcTemplate.update(query);

					break;
				}
			}
			


		}
		return entityRes;

	}

	public List<Do_picking> show_retrivePalletScreen() {
		String q = "Select * from do_picking where status='processing' or status='pallet Retrive' ";
		List<Do_picking> list = jdbcTemplate.query(q, new Do_pickingRowMapper());
//		return this.doPickingRepo.findAll();
		return list;
	}

	public List<Do_picking> show_Picking_Sku_Screen() {
		String q = "Select * from do_picking where status='pallet Retrive' or status='picking Complete'";
		List<Do_picking> list = jdbcTemplate.query(q, new Do_pickingRowMapper());
		return list;
	}

	public List<Do_picking> dispatch_Sku_Screen() {
		String q = "Select * from do_picking where status='picking Complete'  or status='Done'";
		List<Do_picking> list = jdbcTemplate.query(q, new Do_pickingRowMapper());
//		return this.doPickingRepo.findAll();
		return list;
	}
	
	
	
	
	public List<Do_picking> TaskList(String operatorEmpCode){
		return this.doPickingRepo.findByoperatorEmpCode(operatorEmpCode);
	}

	
	
	Do_picking obj = new Do_picking();
	public void palletRetrivetaskAssign(List<Do_picking> do_picking) {
		for (int i = 0; i < do_picking.size(); i++) {
			obj = do_picking.get(i);
			String op_name = obj.getOperator_name();
			String op_code = obj.getOperator_emp_code();
			int l_id = obj.getLocation_id();
			String l_palletid = obj.getPallet_id();
			List<Do_picking> do_pic_obj = this.doPickingRepo.findAll();
			for (int j = 0; j < do_pic_obj.size(); j++) {
				Do_picking dop = new Do_picking();
				dop = do_pic_obj.get(j);
				if (dop.getLocation_id() == l_id && dop.getPallet_id().equals(l_palletid)) {
					dop.setStatus("pallet Retrive");
					dop.setOperator_name(op_name);
					dop.setOperator_emp_code(op_code);
					this.doPickingRepo.save(dop);
				}
			}

		}
	}

	// picking sku assign Task

	public void picking_Sku_taskAssign(List<Do_picking> do_picking) {
		for (int i = 0; i < do_picking.size(); i++) {
			obj = do_picking.get(i);
			String op_name = obj.getOperator_name();
			String op_code = obj.getOperator_emp_code();
			int l_id = obj.getLocation_id();
			String l_palletid = obj.getPallet_id();
			List<Do_picking> do_pic_obj = this.doPickingRepo.findAll();
			for (int j = 0; j < do_pic_obj.size(); j++) {
				Do_picking dop = new Do_picking();
				dop = do_pic_obj.get(j);
				if (dop.getLocation_id() == l_id && dop.getPallet_id().equals(l_palletid)) {
					dop.setStatus("picking Complete");
					dop.setOperator_name(op_name);
					dop.setOperator_emp_code(op_code);
					this.doPickingRepo.save(dop);
				}
			}

		}
	}

// Dispatch task assign

	public void dispatch_taskAssign(List<Do_picking> do_picking) {
		for (int i = 0; i < do_picking.size(); i++) {
			obj = do_picking.get(i);
			String op_name = obj.getOperator_name();
			String op_code = obj.getOperator_emp_code();
			int l_id = obj.getLocation_id();
			String l_palletid = obj.getPallet_id();
			List<Do_picking> do_pic_obj = this.doPickingRepo.findAll();
			for (int j = 0; j < do_pic_obj.size(); j++) {
				Do_picking dop = new Do_picking();
				dop = do_pic_obj.get(j);
				if (dop.getLocation_id() == l_id && dop.getPallet_id().equals(l_palletid)) {
					dop.setStatus("Done");
					dop.setOperator_name(op_name);
					dop.setOperator_emp_code(op_code);
					this.doPickingRepo.save(dop);
				}
			}

		}
	}

}








//String O_sku_code=outboundDo.getSku_code();
//int O_line=outboundDo.getDo_line_item_no();
//int O_sku_qty=outboundDo.getSku_qty();
//O_out_bound=outboundDo.getOut_bound_station();
//O_delivery_order_no = outboundDo.getDelivery_order_no();

//for(int i=0;i<sku_inventrylist.size();i++)
//{
//	sku_inventory=sku_inventrylist.get(i);
//	String inventryskucode=sku_inventory.getSku_code();
//	int inventryskuqty=sku_inventory.getQantity();
//	boolean value=O_sku_code.equals(inventryskucode);
//	if(value) {
//		if(O_sku_qty<=inventryskuqty) {
//			String deleteginrow="DELETE FROM outboundDo WHERE sku_code ='"+O_sku_code+"', do_line_item_no = '"+O_line+"'";
////			  this.jdbcTemplate.update(deleteginrow);
//			System.out.println(deleteginrow);
//			System.out.println(O_sku_qty);
//			while(O_sku_qty>0) {
//				List<Location_details> location_detailsList=this.location_detailsRepo.findAll();
//				Location_details location_details=new Location_details();
//				for(int j=0;j<location_detailsList.size();j++) {
//					location_details=location_detailsList.get(j);
//					 LD_Sku_Code=location_details.getSku_code();
//					 LD_qty=location_details.getQuantity();
//					 
//					 if(LD_Sku_Code.equals(O_sku_code)) {
//						
//						  LD_pallet_id = location_details.getPallet_id(); 
//						   LD_location_id = location_details.getLocation_id();
//						   
//						   List<Location_mst> location_mstList=this.location_mstRepo.findAll();
//						   Location_mst location_mst=new Location_mst();
//						   for(int k=0;k<location_mstList.size();k++) {
//							   location_mst=location_mstList.get(k);
//							   LM_location_id = location_mst.getLocation_id();
//							   if(LM_location_id ==LD_location_id) {
//								   location_mst.getArea();
//								   location_mst.getAisle_position();
//								   location_mst.getAisle();
//								   Do_picking do_picking=new Do_picking();
//								   do_picking.setOrder_no(O_delivery_order_no);
//								   do_picking.setSku_code(O_sku_code);
//								   do_picking.setSku_qty(LD_qty);
//								   do_picking.setAreaid(i);
//								   do_picking.setDirection(location_mst.getDirection());
//								   do_picking.setSelf_level(location_mst.getShelf_level());
//								   do_picking.setAisle_postion(location_mst.getAisle_position());
//								   do_picking.setLocation_id(LM_location_id);
//								   do_picking.setOut_bound_station(O_out_bound);
//								   do_picking.setPallet_id(LD_pallet_id);
//								   this.doPickingRepo.save(do_picking);	
//								   String query= "DELETE FROM location_details WHERE pallet_id='"+LD_pallet_id+"'";
//									System.out.println(query);
////									 this.jdbcTemplate.update(query);
//									System.out.println(LD_pallet_id);
//									 break; 
//							   }
//							  
//							 
//						   }
//						   
//					 }	
//				}
//				break;
//			}
//			//break;
//		}
//		
//		
//	}
//}
