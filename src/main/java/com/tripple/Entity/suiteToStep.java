package com.tripple.Entity;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.tripple.enumType.stepType;

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
@IdClass(suiteToStepMutiKey.class)
public class suiteToStep extends BusinessEntity implements Serializable {

	static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Id
	Long testsuiteId;

	@Id
	Long stepId;

	@Id
	Integer stepOrder;
	stepType type;

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
