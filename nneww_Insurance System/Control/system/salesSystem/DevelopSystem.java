package system.salesSystem;

import data.ISData;
import data.customerData.CustomerData;
import data.employeeData.salesEmployeeData.SalesManData;
import data.employeeData.salesEmployeeData.SalesManagerData;
import dataList.IntISDataList;
import system.ISSystem;

public abstract class SalesSystem extends ISSystem {

	// Associate
	protected IntISDataList<SalesManData> salesManList; //개발자 리스트
	protected IntISDataList<SalesManagerData> salesManagerList;  //보험요율계산하는 사람 리스트
	
//	protected IntISDataList<CustomerData> customerList;
	
	// Initialize Time Use
	@Override @SuppressWarnings("unchecked")
	public void specificAssociateModel(IntISDataList<? extends ISData>[] datas) { //ISSystem의 specificAssociateModel을 받아몸. //develop line 사람들 및, 데이터의 리스트들이 dats에 담겨있음.
		this.salesManList=(IntISDataList<SalesManData>) datas[4];
		this.salesManagerList=(IntISDataList<SalesManagerData>) datas[5];
	
		this.customerList=(IntISDataList<CustomerData>) datas[6];

	}
}
