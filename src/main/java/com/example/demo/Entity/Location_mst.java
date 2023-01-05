package com.example.demo.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Location_mst {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "netive")
	private int locationId;
	
	private String area;
	private String aisle;
	private String direction;
	private int aisle_position;
	private int shelf_level;
	private int status;
	@Column(name="created_by")
	private int createdBy;
	private Date create_date;
	private int modified_by;
	private Date modify_date;
	/**
	 * @return the location_id
	 */
	public int getLocation_id() {
		return locationId;
	}
	/**
	 * @param location_id the location_id to set
	 */
	public void setLocation_id(int location_id) {
		this.locationId = location_id;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
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
	 * @return the aisle_position
	 */
	public int getAisle_position() {
		return aisle_position;
	}
	/**
	 * @param aisle_position the aisle_position to set
	 */
	public void setAisle_position(int aisle_position) {
		this.aisle_position = aisle_position;
	}
	/**
	 * @return the shelf_level
	 */
	public int getShelf_level() {
		return shelf_level;
	}
	/**
	 * @param shelf_level the shelf_level to set
	 */
	public void setShelf_level(int shelf_level) {
		this.shelf_level = shelf_level;
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
	/**
	 * @return the created_by
	 */
	
	/**
	 * @return the create_date
	 */
	public Date getCreate_date() {
		return create_date;
	}
	/**
	 * @return the createdBy
	 */
	public int getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
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
