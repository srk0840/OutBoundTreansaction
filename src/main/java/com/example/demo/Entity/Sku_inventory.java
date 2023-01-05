package com.example.demo.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sku_inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	private int sku_inventory_id;
	@Column(name="sku_code")
	private String skuCode;
	private int qantity;
	private Date create_date;
	private int modified_by=0;
	private Date modify_date;
	
	/**
	 * @return the sku_inventory_id
	 */
	public int getSku_inventory_id() {
		return sku_inventory_id;
	}
	/**
	 * @param sku_inventory_id the sku_inventory_id to set
	 */
	public void setSku_inventory_id(int sku_inventory_id) {
		this.sku_inventory_id = sku_inventory_id;
	}
	/**
	 * @return the sku_code
	 */
	public String getSkuCode() {
		return skuCode;
	}
	/**
	 * @param sku_code the sku_code to set
	 */
	public void setSku_code(String skuCode) {
		this.skuCode = skuCode;
	}
	/**
	 * @return the qantity
	 */
	public int getQantity() {
		return qantity;
	}
	/**
	 * @param qantity the qantity to set
	 */
	public void setQantity(int qantity) {
		this.qantity = qantity;
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
	
	
	
	
	

}
