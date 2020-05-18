package system.salesSystem.realSalesSystem;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import component.BasicButton;
import component.TitledTextArea;
import data.customerData.CustomerData;
import system.salesSystem.SalesSystem;

public class SinginCustomerSystem extends SalesSystem {
	// Static
	private enum EActionCommands {SaveInsuranceData}
	
	// Component
	private TitledTextArea nameTTA = new TitledTextArea("�̸�", 1, "", true);
	private TitledTextArea residenceTTA = new TitledTextArea("������", 2, "", true);
	private TitledTextArea phoneNumTTA = new TitledTextArea("��ȭ��ȣ", 1, "", true);
	
	private TitledTextArea emailTTA = new TitledTextArea("�̸���", 1, "", true);
//	private TitledTextArea familyillhistoryTTA = new TitledTextArea("������", 1, "", true);
	private TitledTextArea socialSecurityNumTTA = new TitledTextArea("�ֹι�ȣ", 1, "", true);
//	private TitledTextArea genderTTA = new TitledTextArea("����", 1, "", true);
	private TitledTextArea jobTTA = new TitledTextArea("����", 1, "", true);
	private TitledTextArea propertyTTA = new TitledTextArea("���", 1, "", true);
//	private TitledTextArea accidentHistoryTTA = new TitledTextArea("��� �̷�", 1, "", true);
	private TitledTextArea ageTTA = new TitledTextArea("����", 1, "", true);
	private TitledTextArea accountNumTTA = new TitledTextArea("���¹�ȣ", 1, "", true);
	
	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("�� ������ �Է��� �ּ���"));
		viewInfo.add(this.nameTTA);
		viewInfo.add(this.socialSecurityNumTTA);
		viewInfo.add(this.phoneNumTTA);
		viewInfo.add(this.emailTTA);
		viewInfo.add(this.residenceTTA);

		viewInfo.add(this.jobTTA);
		viewInfo.add(this.propertyTTA);
		viewInfo.add(this.ageTTA);
		
		viewInfo.add(this.accountNumTTA);
		
		viewInfo.add(new BasicButton("����", EActionCommands.SaveInsuranceData.name(), this.getAH()));
		return viewInfo;
	}

	@Override
	public void processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case SaveInsuranceData : this.save(); this.gotoBack(); break;
		}
	}
	private void save() {
		CustomerData data = new CustomerData();
		data.setName(this.nameTTA.getContent());
		data.setResidence(this.residenceTTA.getContent());
		data.setPhoneNum(this.phoneNumTTA.getContent());
		data.setEmail(this.emailTTA.getContent());
		data.setSocialSecurityNum(this.socialSecurityNumTTA.getContent());
		data.setJob(this.jobTTA.getContent());
		data.setProperty(this.propertyTTA.getContent());
		data.setAge(this.ageTTA.getContent());
		data.setAccountNum(this.accountNumTTA.getContent());
		
		this.customerList.add(data);
		
//		for(InsuranceRatePermitManData employee : this.insuranceRatePermitManList.getList()) {
//			if(employee.isWorkable()) {employee.addTask(new InsuranceRatePermit(data.getID()));}
//		}
		// customer�� ����... �� �����ϰų� �Ұ� �����ϱ� �ٷ� �ٸ� ������� �Ϸ� �ִ� �� �ƴ�
	}

}
