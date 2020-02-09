package gr.hua.dit.entity;

public class AppResult {

	int index;
	
	String result;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public AppResult(int index, String result) {
		super();
		this.index = index;
		this.result = result;
	}
	
	
}
