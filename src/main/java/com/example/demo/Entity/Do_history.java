package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Do_history {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "netive")
	private int do_history_id;
	private String delivery_order_no;
	private int do_line_item_no;
	private int location_id;
	private String sku_code;
	private String pallet_id;
	private int pallet_sku_qty;
	private String out_bound_station;

	/**
	 * @return the do_history_id
	 */
	public int getDo_history_id() {
		return do_history_id;
	}

	/**
	 * @param do_history_id the do_history_id to set
	 */
	public void setDo_history_id(int do_history_id) {
		this.do_history_id = do_history_id;
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
	 * @return the pallet_sku_qty
	 */
	public int getPallet_sku_qty() {
		return pallet_sku_qty;
	}

	/**
	 * @param pallet_sku_qty the pallet_sku_qty to set
	 */
	public void setPallet_sku_qty(int pallet_sku_qty) {
		this.pallet_sku_qty = pallet_sku_qty;
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

}
