package com.tripple.Entity;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.tripple.enumType.paramType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = { "id" })
public class httpParams extends BusinessEntity implements Serializable{

	static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	Long requestid;

	@Column(length = 1000)
	String paramName;
	@Column(length = 1000)
	String paramValue;

	paramType paramType;
	@Column(length = 1000)
	String defaultValue;

	@Column(length = 200)
	String description;

	Boolean isMust;

	@Override
	Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void setId(Long id) {
		// TODO Auto-generated method stub

	}

}
