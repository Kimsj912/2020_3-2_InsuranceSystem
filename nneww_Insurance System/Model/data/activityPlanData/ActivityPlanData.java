package data.activityPlanData;

import java.util.Date;

import data.ISData;

public class ActivityPlanData extends ISData {
	
	private Date salesDuration;
	private int salesGoal;
	private String ActivityGoal;
	private int additionalJobOffer;
	private String salesTargetCustomer;
	
	// getter & setter
	public Date getSalesDuration() {return salesDuration;}
	public void setSalesDuration(Date salesDuration) {this.salesDuration = salesDuration;}
	public int getSalesGoal() {return salesGoal;}
	public void setSalesGoal(int salesGoal) {this.salesGoal = salesGoal;}	
	public String getActivityGoal() {return ActivityGoal;}
	public void setActivityGoal(String activityGoal) {ActivityGoal = activityGoal;}
	public int getAdditionalJobOffer() {return additionalJobOffer;}
	public void setAdditionalJobOffer(int additionalJobOffer) {this.additionalJobOffer = additionalJobOffer;}
	public String getSalesTargetCustomer() {return salesTargetCustomer;}
	public void setSalesTargetCustomer(String salesTargetCustomer) {this.salesTargetCustomer = salesTargetCustomer;}
	

}
