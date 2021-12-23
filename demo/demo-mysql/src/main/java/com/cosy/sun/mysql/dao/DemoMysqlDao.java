package com.cosy.sun.mysql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DemoMysqlDao {

	@Select("select id from test")
	public List<Integer> selectAll();
	
}
