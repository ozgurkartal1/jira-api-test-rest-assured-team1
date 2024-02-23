package pojo.request.edit_issue;

import java.util.List;

public class Update {

	private List<SummaryItem> summary;

	private List<Object> labels;

	public void setSummary(List<SummaryItem> summary) {
		this.summary = summary;
	}

	public List<SummaryItem> getSummary() {
		return summary;
	}

	public List<Object> getLabels() {
		return labels;
	}

	public void setLabels(List<Object> labels) {
		this.labels = labels;
	}

}