//package com.cosy.sun.mysql.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.atomikos.jdbc.AtomikosDataSourceBean;
//import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(basePackages = "com.sun.dao.a", sqlSessionFactoryRef = "sqlSessionFactory")
//public class DatasourceConfig {
//
//	@Autowired
//	private DataSourceProp dsConfig;
//
//	@Bean("dataSource")
//	@Primary
//	public DataSource datasource() {
//		DruidDataSource ds = new DruidDataSource();
//		ds.setUrl(dsConfig.getUrl());
//		ds.setDriverClassName(dsConfig.getDriverClassName());
//		ds.setUsername(dsConfig.getUserName());
//		ds.setPassword(dsConfig.getPassword());
//		MysqlXADataSource xaDatasource = new MysqlXADataSource();
//		AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
//		atomikosDataSourceBean.setXaDataSource(xaDatasource);
//		atomikosDataSourceBean.setUniqueResourceName("dataSource1");
//		return ds;
//	}
//
//	@Bean("transactionManager")
//	@Primary
//	public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
//		return new DataSourceTransactionManager(dataSource);
//	}
//
//	@Bean("sqlSessionFactory")
//	@Primary
//	public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(dataSource);
////		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis.xml"));
//		return sqlSessionFactoryBean;
//	}
//
//}
