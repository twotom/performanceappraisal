package cn.js.ccit.model;
/**
 *部门
 *
 */
public class Department {
	private Integer id;
	private String name;
	private String shortName;
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
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Department() {
	}

	public Department(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", shortName="
				+ shortName + "]";
	}

	

}
