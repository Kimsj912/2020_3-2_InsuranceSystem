package system.developSystem.realDevelopSystem.developerAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import component.BasicButton;
import component.TitledTextArea;
import data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import data.insuranceData.AbsInsuranceData;
import data.insuranceData.realInsuranceData.CarAccidentInsuranceData;
import data.taskData.realTaskData.InsuranceRatePermit;
import system.developSystem.DevelopSystem;

public class DevelopInsuranceSystem extends DevelopSystem {

	// Static
	private enum EActionCommands {SaveInsuranceData}
	
	// Component
	private TitledTextArea nameTTA = new TitledTextArea("�̸�", 1, "", true);
	private TitledTextArea contentTTA = new TitledTextArea("����", 10, "", true);
	private TitledTextArea insuranceRateInfoTTA = new TitledTextArea("���� ����", 10, "", true);
	private TitledTextArea lossPercentTTA = new TitledTextArea("������", 1, "", true);
	
	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("���� ������ �Է��� �ּ���"));
		viewInfo.add(this.nameTTA);
		viewInfo.add(this.contentTTA);
		viewInfo.add(this.insuranceRateInfoTTA);
		viewInfo.add(this.lossPercentTTA);
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
		AbsInsuranceData data = new CarAccidentInsuranceData();
		data.setName(this.nameTTA.getContent());
		data.setContent(this.contentTTA.getContent());
		data.setInsuranceRateInfo(this.insuranceRateInfoTTA.getContent());
		data.setLossPercent(Double.parseDouble(this.lossPercentTTA.getContent()));
		this.insuranceList.add(data);
		
		for(InsuranceRatePermitManData employee : this.insuranceRatePermitManList.getList()) {
			if(employee.isWorkable()) {employee.addTask(new InsuranceRatePermit(data.getID()));}
		}
	}
}
