package pojo.request.issue;

import java.util.List;

public class Description{
	private String type;
	private int version;
	private List<Content> content;

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setVersion(int version){
		this.version = version;
	}

	public int getVersion(){
		return version;
	}

	public void setContent(List<Content> content){
		this.content = content;
	}

	public List<Content> getContent(){
		return content;
	}
}