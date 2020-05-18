package data.taskData.realTaskData;

import data.taskData.AbsTask;

public class ProductPermit extends AbsTask {

	// Attribute
	private int targetInsuranceID;
	
	// Constructor
	public ProductPermit(int targetInsuranceID) {this.targetInsuranceID=targetInsuranceID;}
	
	// Getter & Setter
	public int getTargetInsuranceID() {return this.targetInsuranceID;}
}
