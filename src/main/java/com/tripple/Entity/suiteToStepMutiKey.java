package com.tripple.Entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = { "id" ,"testsuiteId","stepId","stepOrder"})
public class suiteToStepMutiKey implements Serializable {
	
	
	Long id;
	
	Long testsuiteId;
	
	Long stepId;
	
	Integer stepOrder;
	
	
}
