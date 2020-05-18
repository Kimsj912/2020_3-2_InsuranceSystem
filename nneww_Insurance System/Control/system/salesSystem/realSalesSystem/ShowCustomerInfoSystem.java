package system.salesSystem.realSalesSystem;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import component.BasicButton;
import data.customerData.CustomerData;
import dataList.IntISDataList;
import system.developSystem.DevelopSystem;

public class ShowCustomerInfoSystem extends DevelopSystem {

	private IntISDataList<CustomerData> searchedCustomerList;
	private JTextField searchedNameTTA;

	public ShowCustomerInfoSystem(IntISDataList<CustomerData> customerList, JTextField searchedNameTTA) {
		this.searchedCustomerList = customerList;
		this.searchedNameTTA = searchedNameTTA;
	}

	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		if (this.searchedCustomerList.getList().isEmpty()) {
			viewInfo.add(new JLabel(this.searchedNameTTA.getText() + "���� �ý��ۿ� �������� �ʽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�"));
		} else {
			//���̺��� ������ ���߿� (����, �����̵�, ��ȭ��ȣ, ����, ����, �ֹι�ȣ)���������
			for (CustomerData customerData : this.searchedCustomerList.getList()) {
				viewInfo.add(new BasicButton(customerData.getName(), Integer.toString(customerData.getID()), this.getAH()));
			}
		}
		return viewInfo;
	}

	@Override
	public void processEvent(ActionEvent e) {
		// �� ���õǸ�, ���� ������ �� �ִ� ���� �˻� â�� ���� ��
		// �ϴ� ���������� ���߿� �ٽ� ��ġ��.
		for (CustomerData customerData : this.customerList.getList()) {
			if (Integer.toString(customerData.getID()).equals(e.getActionCommand())) {
				this.startNewSystem(new ShowAvailableProduct(customerData));// Ŭ�ٴ� ID�� ������, ���� CustomerData�� �����̴�.
			}
		}
		
	}

}
