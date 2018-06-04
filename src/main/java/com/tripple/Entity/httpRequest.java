/**
 * 
 */
package com.tripple.Entity;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;



import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.tripple.enumType.apiLevel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 *
 */

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false,of={"id"})
public class httpRequest extends BusinessEntity implements Serializable{

	
	
	static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	String name;
	String url;
	String httpMethod;
	Boolean isOn;
	@Column(length=200)
	String description;
	apiLevel apilevel;
	

}
