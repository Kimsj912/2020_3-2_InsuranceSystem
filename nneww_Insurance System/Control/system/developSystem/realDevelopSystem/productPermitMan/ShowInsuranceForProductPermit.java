package system.developSystem.realDevelopSystem.productPermitMan;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import component.BasicButton;
import component.TitledTextArea;
import data.insuranceData.AbsInsuranceData;
import data.taskData.realTaskData.ProductPermit;
import dataList.realDataList.ISDataList;
import system.developSystem.DevelopSystem;

public class ShowInsuranceForProductPermit extends DevelopSystem {

	// Static
	private enum EActionCommands {Permit, Ban}
		
	// Association
	private ISDataList<ProductPermit> tasks;
	private int taskIndex, targetInsuranceID;
	private AbsInsuranceData insuranceData;
	
	// Constructor
	public ShowInsuranceForProductPermit(ISDataList<ProductPermit> isDataList, int taskIndex) {
		this.tasks=isDataList; this.taskIndex=taskIndex;
	}

	@Override
	public Vector<JComponent> getViewInfo() {
		this.targetInsuranceID = this.tasks.search(taskIndex).getTargetInsuranceID();
		this.insuranceData = this.insuranceList.search(this.targetInsuranceID);
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("��ǰ �ΰ� �Ǵ� ���ּ���"));
		viewInfo.add(new TitledTextArea("�̸�", 1, this.insuranceData.getName(), false));
		viewInfo.add(new TitledTextArea("����", 10, this.insuranceData.getContent(), false));
		viewInfo.add(new TitledTextArea("���� ����", 10, this.insuranceData.getInsuranceRateInfo(), false));
		viewInfo.add(new TitledTextArea("������", 1, Double.toString(this.insuranceData.getLossPercent()), false));
		viewInfo.add(new BasicButton("�հ�", EActionCommands.Permit.name(), this.getAH()));
		viewInfo.add(new BasicButton("���հ�", EActionCommands.Ban.name(), this.getAH()));
		return viewInfo;
	}
	
	@Override
	public void processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case Permit : this.insuranceData.permitProduct(); break;
		case Ban : break;
		}
		this.tasks.delete(this.taskIndex);
		this.gotoBack();
	}
}
