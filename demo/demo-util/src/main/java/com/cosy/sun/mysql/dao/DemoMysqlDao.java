package com.cosy.sun.mysql.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DemoMysqlDao {

	@Select("select id from test")
	public List<Integer> selectAll();
	
}
