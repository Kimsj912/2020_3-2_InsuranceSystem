package system.developSystem.realDevelopSystem.developerAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import component.TitledTextArea;
import data.insuranceData.AbsInsuranceData;
import system.developSystem.DevelopSystem;

public class ShowInsuranceInfoSystem extends DevelopSystem {

	// Attribute
	private int insuranceID;
	
	// Constructor
	public ShowInsuranceInfoSystem(int insuranceID) {this.insuranceID=insuranceID;}

	@Override
	public Vector<JComponent> getViewInfo() {
		AbsInsuranceData insuranceData = this.insuranceList.search(this.insuranceID);
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("��û�Ͻ� ���� ���� �Դϴ�."));
		viewInfo.add(new TitledTextArea("�̸�", 1, insuranceData.getName(), false));
		viewInfo.add(new TitledTextArea("����", 10, insuranceData.getContent(), false));
		viewInfo.add(new TitledTextArea("���� ����", 10, insuranceData.getInsuranceRateInfo(), false));
		viewInfo.add(new TitledTextArea("������", 1, Double.toString(insuranceData.getLossPercent()), false));
		viewInfo.add(new TitledTextArea("���� ���� ����", 1, Boolean.toString(insuranceData.isInsuranceratePermit()), false));
		viewInfo.add(new TitledTextArea("��ǰ �ΰ� ����", 1, Boolean.toString(insuranceData.isProductPermit()), false));
		return viewInfo;
	}
	
	// No Use
	@Override public void processEvent(ActionEvent e) {}
}
