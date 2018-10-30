package cn.js.ccit.model;

public class Employee {
	private Integer id;
	private String empId;//工号
	private String name;//姓名
	private String pwd;//密码
	private Character sex;
	private Identity identity;//身份
	private Department department;//部门
	private Group group;//考核小组
	private String ranId;//随机账号
	private String ranPwd;//随机密码
	private Integer state;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	
	public Character getSex() {
		return sex;
	}
	public void setSex(Character sex) {
		this.sex = sex;
	}


	public String getRanId() {
		return ranId;
	}

	public void setRanId(String ranId) {
		this.ranId = ranId;
	}

	public String getRanPwd() {
		return ranPwd;
	}

	public void setRanPwd(String ranPwd) {
		this.ranPwd = ranPwd;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Employee [department=" + department + ", empId=" + empId
				+ ", group=" + group + ", id=" + id + ", identity=" + identity
				+ ", name=" + name + ", pwd=" + pwd + ", sex=" + sex + "]";
	}
	

}
