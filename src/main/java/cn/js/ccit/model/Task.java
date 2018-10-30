package cn.js.ccit.model;

public class Task {
	private Integer id;
	private String name;
	private Department department;//任务所属部分
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Task [department=" + department + ", id=" + id + ", name="
				+ name + "]";
	}
	

}
