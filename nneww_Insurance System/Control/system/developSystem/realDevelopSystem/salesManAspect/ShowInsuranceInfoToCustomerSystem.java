package system.developSystem.realDevelopSystem.salesManAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import component.BasicButton;
import component.TitledTextArea;
import data.customerData.CustomerData;
import data.insuranceData.AbsInsuranceData;
import system.developSystem.DevelopSystem;

public class ShowInsuranceInfoToCustomerSystem extends DevelopSystem {

	// Static
	private enum EActionCommands {SigninProduct}

	// Attribute
	private int insuranceID;
	private AbsInsuranceData searchedInsuranceData;
	private CustomerData customerData; 

	// Constructor
	public ShowInsuranceInfoToCustomerSystem(int insuranceID, CustomerData customerData) {this.insuranceID=insuranceID; this.customerData = customerData;}

	@Override
	public Vector<JComponent> getViewInfo() {
		this.searchedInsuranceData = this.insuranceList.search(this.insuranceID);
		
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		
		viewInfo.add(new BasicButton("���� ����", EActionCommands.SigninProduct.name(), this.getAH()));
		
		viewInfo.add(new JLabel("������ �����Ͻ� �� �ִ� ���� ���� �Դϴ�."));
		viewInfo.add(new TitledTextArea("���̵�", 1, Integer.toString(searchedInsuranceData.getID()), false));
		viewInfo.add(new TitledTextArea("�����", 1, searchedInsuranceData.getName(), false));
		viewInfo.add(new TitledTextArea("����", 10, searchedInsuranceData.getContent(), false));
		viewInfo.add(new TitledTextArea("�������", 10, searchedInsuranceData.getInsuranceRateInfo(), false));
		
		// Ŭ�ٿ� ����, �������(�����, �����, ����� ���� ������, ����� ������)�� ���ִµ� ���� ����.
		return viewInfo;
	}

	//no use
	@Override
	public void processEvent(ActionEvent e) {
		switch(EActionCommands.valueOf(e.getActionCommand())) {
		case SigninProduct : 
            int result = JOptionPane.showConfirmDialog(null, "���谡���� �����Ͻðڽ��ϱ�?", "SignInProduct", JOptionPane.YES_NO_OPTION);
            if(result==0) { //yes
            	JOptionPane.showMessageDialog(null, "���谡���� �Ϸ�Ǿ����ϴ�.", "SignInProduct", JOptionPane.INFORMATION_MESSAGE);
//            } else { //no
//            	// �̰� �ణ �̻���. �ϴ��� �ּ��ص� ��.
            }
            this.gotoBack();
			break;
		default:
			break;
		}
	}
}
