package dataList;

import java.util.Vector;

public interface IntISDataList<T> {
	
	// Any Time Use
	public void add(T data);
	public void delete(int iD);
	public T search(int iD);
	
	// Getter & Setter
	public int getSize();
	public Vector<T> getList();
}
