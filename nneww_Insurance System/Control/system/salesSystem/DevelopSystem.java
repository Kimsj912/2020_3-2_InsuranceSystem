package system.salesSystem;

import data.ISData;
import data.customerData.CustomerData;
import data.employeeData.salesEmployeeData.SalesManData;
import data.employeeData.salesEmployeeData.SalesManagerData;
import dataList.IntISDataList;
import system.ISSystem;

public abstract class SalesSystem extends ISSystem {

	// Associate
	protected IntISDataList<SalesManData> salesManList; //������ ����Ʈ
	protected IntISDataList<SalesManagerData> salesManagerList;  //�����������ϴ� ��� ����Ʈ
	
//	protected IntISDataList<CustomerData> customerList;
	
	// Initialize Time Use
	@Override @SuppressWarnings("unchecked")
	public void specificAssociateModel(IntISDataList<? extends ISData>[] datas) { //ISSystem�� specificAssociateModel�� �޾Ƹ�. //develop line ����� ��, �������� ����Ʈ���� dats�� �������.
		this.salesManList=(IntISDataList<SalesManData>) datas[4];
		this.salesManagerList=(IntISDataList<SalesManagerData>) datas[5];
	
		this.customerList=(IntISDataList<CustomerData>) datas[6];

	}
}
