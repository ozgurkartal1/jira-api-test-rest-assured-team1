package pojo.request.issue;

import java.util.List;

public class Fields{
    private String summary;
    private Issuetype issuetype;
    private Project project;
    private Description description;
    private List<String> labels;

    public void setSummary(String summary){
        this.summary = summary;
    }

    public String getSummary(){
        return summary;
    }

    public void setIssuetype(Issuetype issuetype){
        this.issuetype = issuetype;
    }

    public Issuetype getIssuetype(){
        return issuetype;
    }

    public void setProject(Project project){
        this.project = project;
    }

    public Project getProject(){
        return project;
    }

    public void setDescription(Description description){
        this.description = description;
    }

    public Description getDescription(){
        return description;
    }

    public void setLabels(List<String> labels){
        this.labels = labels;
    }

    public List<String> getLabels(){
        return labels;
    }
}