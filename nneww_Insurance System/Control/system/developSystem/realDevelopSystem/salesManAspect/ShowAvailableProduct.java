package system.developSystem.realDevelopSystem.salesManAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import component.BasicButton;
import data.customerData.CustomerData;
import data.insuranceData.AbsInsuranceData;
import dataList.IntISDataList;
import dataList.realDataList.ISDataList;
import system.developSystem.DevelopSystem;
import system.developSystem.realDevelopSystem.developerAspect.ShowInsuranceInfoSystem;

public class ShowAvailableProduct extends DevelopSystem {

	private CustomerData customerData;
	
	public ShowAvailableProduct(CustomerData customerData) {
		this.customerData = customerData;
		
	}
	public IntISDataList<AbsInsuranceData> searching() {
		IntISDataList<AbsInsuranceData> availableInsuranceList= new ISDataList<AbsInsuranceData>();
		
		// �� �� �����ؼ� ������ �� ã�Ƽ� availableInsuranceList�� �ֱ�
		// �ϴ��� ��ü ���� ��ǰ�� �����ַ��� ��.
		for (AbsInsuranceData insuranceData:this.insuranceList.getList()) {
			availableInsuranceList.add(insuranceData);
		}
		return availableInsuranceList;
	}
	
	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		
		viewInfo.add(new JLabel("������ �����ϼ���."));
		//���⵵ ���̺�� ���������. ����.... (���� ���̵�, �����, ����)
		for (AbsInsuranceData insuranceData : searching().getList()) {
			viewInfo.add(new BasicButton(insuranceData.getName(), Integer.toString(insuranceData.getID()), this.getAH()));
		}
		return viewInfo;
	}

	@Override
	public void processEvent(ActionEvent e) {
		// showInsuranceInfoSystem�� true false�̷��� �־ �����Ҽ��� ���� �� ������, �ִ°� �Ȱǵ��̴°� �����ϱ� �ϴ� ������.
		this.startNewSystem(new ShowInsuranceInfoToCustomerSystem(Integer.parseInt(e.getActionCommand()), this.customerData));

	}

}
