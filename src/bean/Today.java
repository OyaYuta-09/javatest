package bean;

public class Today {
	private String today;
	private String time;
	public Today(String today, String time) {
		super();
		this.today = today;
		this.time = time;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
