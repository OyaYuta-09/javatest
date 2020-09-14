package bean;

public class Bean {
	private int id;
	private String name;
	private String Dpost;
	private String Tpost;
	private String edit;
	private String comment;
	private String fname;

	public Bean(int id, String name, String dpost, String tpost, String edit,String comment) {
		super();
		this.id = id;
		this.name = name;
		this.Dpost = dpost;
		this.Tpost = tpost;
		this.edit = edit;
		this.comment = comment;
	}

	public Bean(String fname) {
		super();
		this.fname = fname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDpost() {
		return Dpost;
	}
	public void setDpost(String dpost) {
		this.Dpost = dpost;
	}
	public String getTpost() {
		return Tpost;
	}
	public void setTpost(String tpost) {
		this.Tpost = tpost;
	}
	public String getEdit() {
		return edit;
	}
	public void setEdit(String edit) {
		this.edit = edit;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}



}
