package pojo.response;

import java.util.List;

public class ApplicationRoles{
	private int size;
	private List<Object> items;

	public void setSize(int size){
		this.size = size;
	}

	public int getSize(){
		return size;
	}

	public void setItems(List<Object> items){
		this.items = items;
	}

	public List<Object> getItems(){
		return items;
	}
}