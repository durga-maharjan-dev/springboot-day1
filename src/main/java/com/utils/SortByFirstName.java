package com.utils;

import java.util.Comparator;

import com.dto.EmployeeDTO;

public class SortByFirstName implements Comparator<EmployeeDTO>{

	@Override
	public int compare(EmployeeDTO o1, EmployeeDTO o2) {
		return o1.getFirstName().compareTo(o2.getFirstName());
	}
	

}
