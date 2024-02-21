package pojo.request.add_comment;

import java.util.List;

public class Content {
    private List<ContentItem> content;

    private String type;

    public void setContent(List<ContentItem> content){
        this.content = content;
    }

    public List<ContentItem> getContent(){
        return content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
