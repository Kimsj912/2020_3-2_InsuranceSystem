package system.developSystem.realDevelopSystem.insuranceRatePermitMan;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import component.BasicButton;
import component.TitledTextArea;
import data.employeeData.developEmployeeData.ProductPermitManData;
import data.insuranceData.AbsInsuranceData;
import data.taskData.realTaskData.InsuranceRatePermit;
import data.taskData.realTaskData.ProductPermit;
import dataList.realDataList.ISDataList;
import system.developSystem.DevelopSystem;

public class ShowInsuranceForInsuranceRatePermit extends DevelopSystem {

	// Static
	private enum EActionCommands {Permit, Ban}
		
	// Association
	private ISDataList<InsuranceRatePermit> tasks;
	private int taskIndex, targetInsuranceID;
	private AbsInsuranceData insuranceData;
	
	// Constructor
	public ShowInsuranceForInsuranceRatePermit(ISDataList<InsuranceRatePermit> tasks, int taskIndex) {
		this.tasks=tasks; this.taskIndex=taskIndex;
	}

	@Override
	public Vector<JComponent> getViewInfo() {
		this.targetInsuranceID = this.tasks.search(taskIndex).getTargetInsuranceID();
		this.insuranceData = this.insuranceList.search(this.targetInsuranceID);
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("요율 검증 해주세요"));
		viewInfo.add(new TitledTextArea("이름", 1, this.insuranceData.getName(), false));
		viewInfo.add(new TitledTextArea("설명", 10, this.insuranceData.getContent(), false));
		viewInfo.add(new TitledTextArea("요율 설명", 10, this.insuranceData.getInsuranceRateInfo(), false));
		viewInfo.add(new TitledTextArea("손해율", 1, Double.toString(this.insuranceData.getLossPercent()), false));
		viewInfo.add(new BasicButton("합격", EActionCommands.Permit.name(), this.getAH()));
		viewInfo.add(new BasicButton("불합격", EActionCommands.Ban.name(), this.getAH()));
		return viewInfo;
	}
	
	@Override
	public void processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case Permit : this.insuranceData.permitInsuranceRate(); this.orderProductPermit(); break;
		case Ban : break;
		}
		this.tasks.delete(this.taskIndex);
		this.gotoBack();
	}
	
	private void orderProductPermit() {
		for(ProductPermitManData employee : this.productPermitManList.getList()) {
			if(employee.isWorkable()) {employee.addTask(new ProductPermit(this.targetInsuranceID));}
		}
	}
}
