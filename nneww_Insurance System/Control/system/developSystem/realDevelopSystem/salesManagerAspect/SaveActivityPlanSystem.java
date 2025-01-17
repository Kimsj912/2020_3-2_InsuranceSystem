package system.developSystem.realDevelopSystem.salesManagerAspect;

import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import component.BasicButton;
import component.TitledTextArea;
import data.activityPlanData.ActivityPlanData;
import system.developSystem.DevelopSystem;

public class SaveActivityPlanSystem extends DevelopSystem {

	// Static
	private enum EActionCommands {SaveInsuranceData}
		
	/*date type인 salesDuration때문에 3개를 받음.*/
	private JTextArea salesDuration_yearTTA = new JTextArea(); 
	private JTextArea salesDuration_monthTTA = new JTextArea();
	private JTextArea salesDuration_dayTTA = new JTextArea();
	private TitledTextArea salesGoalTTA = new TitledTextArea("전체 매출 목표",1,"",true); //int
	private TitledTextArea activityGoalTTA = new TitledTextArea("전체 활동 목표",10,"",true);
	private TitledTextArea additionalJobOfferTTA = new TitledTextArea("추가 구인 필요량",1,"",true); //int
	private TitledTextArea salesTargetCustomerTTA = new TitledTextArea("주력 고객 선정",3,"",true);
	
	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		
		viewInfo.add(new JLabel("활동계획란"));
		viewInfo.add(this.salesDuration_yearTTA);
		viewInfo.add(this.salesDuration_monthTTA);
		viewInfo.add(this.salesDuration_dayTTA);
		viewInfo.add(this.salesGoalTTA);
		viewInfo.add(this.activityGoalTTA);
		viewInfo.add(this.additionalJobOfferTTA);
		viewInfo.add(this.salesTargetCustomerTTA);
		
		viewInfo.add(new BasicButton("저장", EActionCommands.SaveInsuranceData.name(), this.getAH()));

		return viewInfo;
	}

	@Override
	public void processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case SaveInsuranceData :
			this.save(); 
            JOptionPane.showMessageDialog(null, "저장이 완료되었습니다.", "SaveInsuranceData", JOptionPane.INFORMATION_MESSAGE);
			this.gotoBack(); 
			break;
		}
	}
	@SuppressWarnings("deprecation")
	private void save() {
		ActivityPlanData data = new ActivityPlanData();
		Date durationdate = new Date();
		durationdate.setYear(Integer.parseInt(salesDuration_yearTTA.getText()));
		durationdate.setMonth(Integer.parseInt(salesDuration_monthTTA.getText()));
		durationdate.setDate(Integer.parseInt(salesDuration_dayTTA.getText()));
		data.setSalesDuration(durationdate);
		data.setSalesGoal(Integer.parseInt(this.salesGoalTTA.getContent()));
		data.setActivityGoal(this.activityGoalTTA.getContent());
		data.setAdditionalJobOffer(Integer.parseInt(this.additionalJobOfferTTA.getContent()));
		data.setSalesTargetCustomer(this.salesTargetCustomerTTA.getContent());
		
		this.activityPlanList.add(data);
		
	}
}
