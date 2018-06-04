package com.tripple.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class header {
	String name;
	String value;
}
