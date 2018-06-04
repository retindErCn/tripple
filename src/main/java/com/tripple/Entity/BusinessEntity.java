package com.tripple.Entity;


import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BusinessEntity {
	
	@CreatedDate
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime createDate=DateTime.now();
	
	@LastModifiedBy
	@ManyToOne(fetch=FetchType.LAZY)
	user updateBy;
	
	@LastModifiedDate
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime updatedDate=DateTime.now();
	
	@Version
	Integer version;
	
	 abstract Long getId();
	 abstract void setId(Long id);
	 
	
}
