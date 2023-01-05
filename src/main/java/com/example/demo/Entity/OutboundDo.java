package com.example.demo.Entity;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "outbound_do")
public class OutboundDo {

//	
//	CREATE TABLE `outbound_do` (
//			  `do_id` int NOT NULL AUTO_INCREMENT,
//			  `delivery_order_no` char(16) DEFAULT NULL,
//			  `do_line_item_no` int DEFAULT NULL,
//			  `out_bound_station` char(16) DEFAULT NULL,
//			  `sku_code` char(16) DEFAULT NULL,
//			  `sku_qty` int NOT NULL,
//			  `created_by` int DEFAULT NULL,
//			  `create_date` date DEFAULT NULL,
//			  `modified_by` int DEFAULT NULL,
//			  `modify_date` date DEFAULT NULL,
//			  `truck_number` varchar(45) DEFAULT NULL,
//			  PRIMARY KEY (`do_id`),
//			  UNIQUE KEY `UX_do_item` (`do_line_item_no`,`delivery_order_no`)
//			) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
//	 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	private int do_id;

	private String delivery_order_no;
	private LocalDate do_date;
	private int do_line_item_no;
	private String out_bound_station;
	private String sku_code;
	private int sku_qty;
	private int created_by;

	private Date create_date;
	private int modified_by;
	private Date modify_date;
	private String truck_number;
	private String status;

	
	



	/**
	 * @return the do_date
	 */
	public LocalDate getDo_date() {
		return do_date;
	}

	/**
	 * @param do_date the do_date to set
	 */
	public void setDo_date(LocalDate do_date) {
		this.do_date = do_date;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the do_id
	 */
	public int getDo_id() {
		return do_id;
	}

	/**
	 * @param do_id the do_id to set
	 */
	public void setDo_id(int do_id) {
		this.do_id = do_id;
	}

	/**
	 * @return the delivery_order_no
	 */
	public String getDelivery_order_no() {
		return delivery_order_no;
	}

	/**
	 * @param delivery_order_no the delivery_order_no to set
	 */
	public void setDelivery_order_no(String delivery_order_no) {
		this.delivery_order_no = delivery_order_no;
	}

	/**
	 * @return the do_line_item_no
	 */
	public int getDo_line_item_no() {
		return do_line_item_no;
	}

	/**
	 * @param do_line_item_no the do_line_item_no to set
	 */
	public void setDo_line_item_no(int do_line_item_no) {
		this.do_line_item_no = do_line_item_no;
	}

	/**
	 * @return the out_bound_station
	 */
	public String getOut_bound_station() {
		return out_bound_station;
	}

	/**
	 * @param out_bound_station the out_bound_station to set
	 */
	public void setOut_bound_station(String out_bound_station) {
		this.out_bound_station = out_bound_station;
	}

	/**
	 * @return the sku_code
	 */
	public String getSku_code() {
		return sku_code;
	}

	/**
	 * @param sku_code the sku_code to set
	 */
	public void setSku_code(String sku_code) {
		this.sku_code = sku_code;
	}

	/**
	 * @return the sku_qty
	 */
	public int getSku_qty() {
		return sku_qty;
	}

	/**
	 * @param sku_qty the sku_qty to set
	 */
	public void setSku_qty(int sku_qty) {
		this.sku_qty = sku_qty;
	}

	/**
	 * @return the created_by
	 */
	public int getCreated_by() {
		return created_by;
	}

	/**
	 * @param created_by the created_by to set
	 */
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	/**
	 * @return the create_date
	 */
	public Date getCreate_date() {
		return create_date;
	}

	/**
	 * @param create_date the create_date to set
	 */
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	/**
	 * @return the modified_by
	 */
	public int getModified_by() {
		return modified_by;
	}

	/**
	 * @param modified_by the modified_by to set
	 */
	public void setModified_by(int modified_by) {
		this.modified_by = modified_by;
	}

	/**
	 * @return the modify_date
	 */
	public Date getModify_date() {
		return modify_date;
	}

	/**
	 * @param modify_date the modify_date to set
	 */
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}

	/**
	 * @return the truck_number
	 */
	public String getTruck_number() {
		return truck_number;
	}

	/**
	 * @param truck_number the truck_number to set
	 */
	public void setTruck_number(String truck_number) {
		this.truck_number = truck_number;
	}

}
