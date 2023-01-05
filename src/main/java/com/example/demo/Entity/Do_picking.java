package com.example.demo.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Do_picking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "netive")
	private int picking_id;
	
	private String aisle;
	private int aisle_postion;
	private int areaid;
	private String direction;
	private int location_id;
	private String order_no;
	private String out_bound_station;
	private String pallet_id;
	private String sku_code;
	private int sku_qty;
	private int self_level;
	private String operatorEmpCode;
	private String operator_name;
	private String status;
	private int created_by;
	private Date create_date;
	private int modified_by;
	private Date modified_date;
	/**
	 * @return the picking_id
	 */
	public int getPicking_id() {
		return picking_id;
	}
	/**
	 * @param picking_id the picking_id to set
	 */
	public void setPicking_id(int picking_id) {
		this.picking_id = picking_id;
	}
	/**
	 * @return the aisle
	 */
	public String getAisle() {
		return aisle;
	}
	/**
	 * @param aisle the aisle to set
	 */
	public void setAisle(String aisle) {
		this.aisle = aisle;
	}
	/**
	 * @return the aisle_postion
	 */
	public int getAisle_postion() {
		return aisle_postion;
	}
	/**
	 * @param aisle_postion the aisle_postion to set
	 */
	public void setAisle_postion(int aisle_postion) {
		this.aisle_postion = aisle_postion;
	}
	/**
	 * @return the areaid
	 */
	public int getAreaid() {
		return areaid;
	}
	/**
	 * @param areaid the areaid to set
	 */
	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}
	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}
	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	/**
	 * @return the location_id
	 */
	public int getLocation_id() {
		return location_id;
	}
	/**
	 * @param location_id the location_id to set
	 */
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	/**
	 * @return the order_no
	 */
	public String getOrder_no() {
		return order_no;
	}
	/**
	 * @param order_no the order_no to set
	 */
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
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
	 * @return the pallet_id
	 */
	public String getPallet_id() {
		return pallet_id;
	}
	/**
	 * @param pallet_id the pallet_id to set
	 */
	public void setPallet_id(String pallet_id) {
		this.pallet_id = pallet_id;
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
	 * @return the self_level
	 */
	public int getSelf_level() {
		return self_level;
	}
	/**
	 * @param self_level the self_level to set
	 */
	public void setSelf_level(int self_level) {
		this.self_level = self_level;
	}
	/**
	 * @return the operator_emp_code
	 */
	public String getOperator_emp_code() {
		return operatorEmpCode;
	}
	/**
	 * @param operator_emp_code the operator_emp_code to set
	 */
	public void setOperator_emp_code(String operator_emp_code) {
		this.operatorEmpCode = operator_emp_code;
	}
	/**
	 * @return the operator_name
	 */
	public String getOperator_name() {
		return operator_name;
	}
	/**
	 * @param operator_name the operator_name to set
	 */
	public void setOperator_name(String operator_name) {
		this.operator_name = operator_name;
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
	 * @return the modified_date
	 */
	public Date getModified_date() {
		return modified_date;
	}
	/**
	 * @param modified_date the modified_date to set
	 */
	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}
	
	
	
	
	

}
