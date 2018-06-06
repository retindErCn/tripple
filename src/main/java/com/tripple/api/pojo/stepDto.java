package com.tripple.api.pojo;

import com.tripple.enumType.customOperator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class stepDto {
	String stepName;
	String leftVar;
	String rightVar;
	customOperator operator;
	Long  requestid;
}
