package pojo.request.issue;

import java.util.List;

public class Content {
    private String type;

    private List<ContentItem> content;

    public Content(){}

    public Content(String type, List<ContentItem> content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ContentItem> getContent() {
        return content;
    }

    public void setContent(List<ContentItem> content) {
        this.content = content;
    }
}
