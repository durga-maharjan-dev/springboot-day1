package com.utils;

import java.util.Comparator;

import com.dto.EmployeeDTO;

public class SortByFirstNameDescending implements Comparator<EmployeeDTO>{

	@Override
	public int compare(EmployeeDTO o1, EmployeeDTO o2) {
		
		return o2.getFirstName().compareTo(o1.getFirstName());
	}

}
