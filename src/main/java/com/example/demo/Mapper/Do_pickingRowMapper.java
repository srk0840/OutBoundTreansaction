package com.example.demo.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.Entity.Do_picking;

public class Do_pickingRowMapper implements RowMapper<Do_picking> {

	@Override
	public Do_picking mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Do_picking doPick=new Do_picking();

		doPick.setAisle(rs.getString("aisle"));
		doPick.setAisle_postion(rs.getInt("aisle_postion"));
		doPick.setAreaid(rs.getInt("areaid"));
		doPick.setCreate_date(rs.getDate("create_date"));
		doPick.setDirection(rs.getString("direction"));
		doPick.setLocation_id(rs.getInt("location_id"));
		doPick.setModified_by(rs.getInt("modified_by"));
		doPick.setModified_date(rs.getDate("modified_date"));
		doPick.setOperator_emp_code(rs.getString("operator_emp_code"));
		doPick.setOperator_name(rs.getString("operator_name"));
		doPick.setOrder_no(rs.getString("order_no"));
		doPick.setOut_bound_station(rs.getString("out_bound_station"));
		doPick.setPallet_id(rs.getString("pallet_id"));
		doPick.setSelf_level(rs.getInt("self_level"));
		doPick.setSku_code(rs.getString("sku_code"));
		doPick.setSku_qty(rs.getInt("sku_qty"));
		doPick.setStatus(rs.getString("status"));
		doPick.setPicking_id(rs.getInt("picking_id"));
		doPick.setCreated_by(rs.getInt("created_by"));
		
		return doPick;
	}

}
