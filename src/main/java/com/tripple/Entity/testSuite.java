package com.tripple.Entity;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.tripple.enumType.customOperator;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = { "id" })
public class testSuite extends BusinessEntity implements Serializable{
	
	static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String suiteName;

	@Column(length = 200)
	String description;
	
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
