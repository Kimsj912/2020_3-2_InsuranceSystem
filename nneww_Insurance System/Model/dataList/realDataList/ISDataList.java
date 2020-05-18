package dataList.realDataList;

import java.util.Vector;

import data.ISData;
import dataList.IntISDataList;

public class ISDataList<T extends ISData> implements IntISDataList<T> {

	// Working Variable
	private int index;
	
	// Component
	private Vector<T> datas;
	
	// Constructor
	public ISDataList() {
		// Initialize Working Variable
		this.index = 0;
		
		// Create Component
		this.datas = new Vector<T>();
	}

	// Any Time Use
	@Override public void add(T data) {data.setID(this.index++); this.datas.add(data);} // ID Setting When Adding
	@Override public void delete(int iD) {this.datas.remove(this.search(iD));}
	@Override public T search(int iD) {for(T data : this.datas) {if(data.getID() == iD) {return data;}} return null;}
	
	// Getter & Setter
	@Override public int getSize() {return this.datas.size();}
	@Override public Vector<T> getList() {return this.datas;}
}
