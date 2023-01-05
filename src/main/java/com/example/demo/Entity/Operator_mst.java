package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Operator_mst {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "netive")
	private int operator_id;
	private String operator_emp_code;
	private String operator_name;
	private String operator_address;
	private String status;
	/**
	 * @return the operator_id
	 */
	public int getOperator_id() {
		return operator_id;
	}
	/**
	 * @param operator_id the operator_id to set
	 */
	public void setOperator_id(int operator_id) {
		this.operator_id = operator_id;
	}
	/**
	 * @return the operator_emp_code
	 */
	public String getOperator_emp_code() {
		return operator_emp_code;
	}
	/**
	 * @param operator_emp_code the operator_emp_code to set
	 */
	public void setOperator_emp_code(String operator_emp_code) {
		this.operator_emp_code = operator_emp_code;
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
	 * @return the operator_address
	 */
	public String getOperator_address() {
		return operator_address;
	}
	/**
	 * @param operator_address the operator_address to set
	 */
	public void setOperator_address(String operator_address) {
		this.operator_address = operator_address;
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
	
	

}
