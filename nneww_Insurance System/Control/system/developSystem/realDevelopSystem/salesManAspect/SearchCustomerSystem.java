package system.developSystem.realDevelopSystem.salesManAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import component.BasicButton;
import data.customerData.CustomerData;
import dataList.IntISDataList;
import dataList.realDataList.ISDataList;
import system.developSystem.DevelopSystem;

public class SearchCustomerSystem extends DevelopSystem {

	private enum EActionCommands {search}

	private JTextField customerNameTTA;
	
	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		
		viewInfo.add(new JLabel("고객명을 입력해주세요."));
		this.customerNameTTA = new JTextField();
		viewInfo.add(customerNameTTA);
		viewInfo.add(new BasicButton("조회",EActionCommands.search.name(),this.getAH()));
		
		return viewInfo;
	}
	public IntISDataList<CustomerData> search() {
		IntISDataList<CustomerData> searchedCustomerList=new ISDataList<CustomerData>();
		for(CustomerData customerData : this.customerList.getList()) {
			if(customerData.getName().equals(this.customerNameTTA.getText())) {
				searchedCustomerList.add(customerData);
			}
		}
		return searchedCustomerList;
		
	}
	
	@Override
	public void processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case search : this.startNewSystem(new ShowCustomerInfoSystem(search(),this.customerNameTTA));break;
		}
	}

}
