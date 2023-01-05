package com.example.demo.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.Entity.OutboundDo;

public class OutboundDoMapper implements RowMapper<OutboundDo> {

	@Override
	public OutboundDo mapRow(ResultSet rs, int rowNum) throws SQLException {

		OutboundDo outDo=new OutboundDo();
		
		outDo.setCreate_date(rs.getDate("create_date"));
		outDo.setCreated_by(rs.getInt("created_by"));
		outDo.setDelivery_order_no(rs.getString("delivery_order_no"));
		outDo.setDo_id(rs.getInt("do_id"));
		outDo.setModified_by(rs.getInt("modified_by"));
		outDo.setModify_date(rs.getDate("modify_date"));
		outDo.setOut_bound_station(rs.getString("out_bound_station"));
		outDo.setSku_code(rs.getString("sku_code"));
		outDo.setSku_qty(rs.getInt("sku_qty"));
		outDo.setStatus(rs.getString("status"));
		outDo.setTruck_number(rs.getString("truck_number"));
		
		return outDo;
	}

}
