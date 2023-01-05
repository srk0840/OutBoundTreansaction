package com.example.demo.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Location_details {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	private int location_id;
	
	private String pallet_id;
	private String sku_category;
	private String skuCode;
	private int quantity;
	private String batch_number;
	private Date expiry_date;
	private Date storage_date;
	private int created_by;
	private int modfiied_by;
	private Date modify_date;
	private int status;
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
	 * @return the sku_category
	 */
	public String getSku_category() {
		return sku_category;
	}
	/**
	 * @param sku_category the sku_category to set
	 */
	public void setSku_category(String sku_category) {
		this.sku_category = sku_category;
	}
	/**
	 * @return the sku_code
	 */
	public String getSku_code() {
		return skuCode;
	}
	/**
	 * @param sku_code the sku_code to set
	 */
	public void setSku_code(String sku_code) {
		this.skuCode = sku_code;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the batch_number
	 */
	public String getBatch_number() {
		return batch_number;
	}
	/**
	 * @param batch_number the batch_number to set
	 */
	public void setBatch_number(String batch_number) {
		this.batch_number = batch_number;
	}
	/**
	 * @return the expiry_date
	 */
	public Date getExpiry_date() {
		return expiry_date;
	}
	/**
	 * @param expiry_date the expiry_date to set
	 */
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	/**
	 * @return the storage_date
	 */
	public Date getStorage_date() {
		return storage_date;
	}
	/**
	 * @param storage_date the storage_date to set
	 */
	public void setStorage_date(Date storage_date) {
		this.storage_date = storage_date;
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
	 * @return the modfiied_by
	 */
	public int getModfiied_by() {
		return modfiied_by;
	}
	/**
	 * @param modfiied_by the modfiied_by to set
	 */
	public void setModfiied_by(int modfiied_by) {
		this.modfiied_by = modfiied_by;
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
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
