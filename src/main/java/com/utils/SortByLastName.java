package com.utils;

import java.util.Comparator;

import com.dto.EmployeeDTO;

public class SortByLastName implements Comparator<EmployeeDTO>{

	@Override
	public int compare(EmployeeDTO o1, EmployeeDTO o2) {
		return o1.getLastName().compareTo(o2.getLastName());
	}

}
