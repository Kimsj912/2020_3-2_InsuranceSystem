package data.insuranceData.realInsuranceData;

import data.customerData.CustomerData;
import data.insuranceData.AbsInsuranceData;

public class DiseaseInsuranceData extends AbsInsuranceData {

	// Attribute
	public enum EDisease {CANCER, HEARTH_ATTACK};
	private EDisease disease; 
			
	// Any Time Use
	@Override public double insuranceRateCheck(CustomerData data) {return 0;}
	
	// Getter & Setter
	public EDisease getDisease() {return this.disease;}
	public void setDisease(EDisease disease) {this.disease = disease;}
}
