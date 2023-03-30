package com.batch.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(schema = "db_example", name = "usercustomer")
@EntityListeners(AuditingEntityListener.class)
public class Usercustomer {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@CreatedDate
	@Column(name = "createtime")
	private Date createtime;
	
	@CreatedBy
	@Column(name = "createuserid")
	private Integer createuserid;
	
	@LastModifiedBy
	@Column(name = "lastmodifieduserid")
	private Integer lastmodifieduserid;
	
	@LastModifiedDate
	@Column(name = "lastmodifiedtime")
	private Date lastmodifiedtime;
	
	@Column(name = "customername")
	private String customername;
	
	@Column(name = "customeremail")
	private String customeremail;
	
	@Version
	@Column(name = "version")
	private Integer version;
	
	public Usercustomer() {
		
	}

	public Usercustomer(Date createtime, Integer createuserid, Integer lastmodifieduserid, Date lastmodifiedtime,
			String customername, String customeremail) {
		this.createtime = createtime;
		this.createuserid = createuserid;
		this.lastmodifieduserid = lastmodifieduserid;
		this.lastmodifiedtime = lastmodifiedtime;
		this.customername = customername;
		this.customeremail = customeremail;
	}

	public Usercustomer(Integer id, Date createtime, Integer createuserid, Integer lastmodifieduserid,
			Date lastmodifiedtime, String customername, String customeremail) {
		this.id = id;
		this.createtime = createtime;
		this.createuserid = createuserid;
		this.lastmodifieduserid = lastmodifieduserid;
		this.lastmodifiedtime = lastmodifiedtime;
		this.customername = customername;
		this.customeremail = customeremail;
	}

	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(Integer createuserid) {
		this.createuserid = createuserid;
	}

	public Integer getLastmodifieduserid() {
		return lastmodifieduserid;
	}

	public void setLastmodifieduserid(Integer lastmodifieduserid) {
		this.lastmodifieduserid = lastmodifieduserid;
	}

	public Date getLastmodifiedtime() {
		return lastmodifiedtime;
	}

	public void setLastmodifiedtime(Date lastmodifiedtime) {
		this.lastmodifiedtime = lastmodifiedtime;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomeremail() {
		return customeremail;
	}

	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}

	@Override
	public String toString() {
		return "Usercustomer [id=" + id + ", createtime=" + createtime + ", createuserid=" + createuserid
				+ ", lastmodifieduserid=" + lastmodifieduserid + ", lastmodifiedtime=" + lastmodifiedtime
				+ ", customername=" + customername + ", customeremail=" + customeremail + "]";
	}
	
	
	
}
