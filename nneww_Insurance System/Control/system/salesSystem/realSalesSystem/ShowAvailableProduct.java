package system.salesSystem.realSalesSystem;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import component.BasicButton;
import data.customerData.CustomerData;
import data.insuranceData.AbsInsuranceData;
import dataList.IntISDataList;
import dataList.realDataList.ISDataList;
import system.developSystem.realDevelopSystem.developerAspect.ShowInsuranceInfoSystem;
import system.salesSystem.SalesSystem;

public class ShowAvailableProduct extends SalesSystem {

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
		for (AbsInsuranceData insuranceData : searching().getList()) {
			viewInfo.add(new BasicButton(insuranceData.getName(), Integer.toString(insuranceData.getID()), this.getAH()));
		}
		return viewInfo;
	}

	@Override
	public void processEvent(ActionEvent e) {
		this.startNewSystem(new ShowInsuranceInfoSystem(Integer.parseInt(e.getActionCommand())));

	}

}
