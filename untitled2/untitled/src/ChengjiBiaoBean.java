


/*
 * 2020-11-29  21：46
 * 成绩表单列数据储存类
 * */


public class ChengjiBiaoBean {
	
	//项目唯一id
	private String id;
	
	//项目名称
	private String title;
	
	//项目分类
	private String classify;
	
	//项目指导老师
	private String teacher;
	
	//项目编号
	private String number;
	
	//项目判断
	private String justify;
	
	public ChengjiBiaoBean() {
		this.setId("");
		this.setTitle("");
		this.setClassify("");
		this.setTeacher("");
		this.setNumber("");
		this.setJustify("");
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getJustify() {
		return justify;
	}

	public void setJustify(String justify) {
		this.justify = justify;
	}
	
	

}
