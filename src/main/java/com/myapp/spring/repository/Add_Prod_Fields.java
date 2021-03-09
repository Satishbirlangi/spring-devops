package com.myapp.spring.repository;

import com.myapp.spring.model.Add_Prod_Tocart;

public interface Add_Prod_Fields {

	Add_Prod_Tocart saveOrders(Add_Prod_Tocart aptc);

	Add_Prod_Tocart updateOrdersCategory(Add_Prod_Tocart aptc);

	Add_Prod_Tocart updateOrdersType(Add_Prod_Tocart aptc);

	Add_Prod_Tocart updateOrdersName(Add_Prod_Tocart aptc);

	Add_Prod_Tocart updateOrdersCount(Add_Prod_Tocart aptc);

}
