package cn.js.ccit.model;

/**
 *  常规工作 
 */
public class RegularWork {

	private Integer id;
	private Department department;
	private Employee evaluator;//打分人
	private Integer choose;// A B C D
	private Double score;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Employee getEvaluator() {
		return evaluator;
	}
	public void setEvaluator(Employee evaluator) {
		this.evaluator = evaluator;
	}
	public Integer getChoose() {
		return choose;
	}
	public void setChoose(Integer choose) {
		this.choose = choose;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "RegularWork [choose=" + choose + ", department=" + department
				+ ", evaluator=" + evaluator + ", id=" + id + ", score="
				+ score + "]";
	}
	
	
}
