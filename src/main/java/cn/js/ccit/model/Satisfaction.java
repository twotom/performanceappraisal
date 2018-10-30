package cn.js.ccit.model;
/*
 * 满意度评价
 */
public class Satisfaction {

	private Integer id;
	private Department department;
	private Integer indicator;//指标
	private Employee evaluator;//打分人
	private Integer element;//考核元素
	private Integer choose;//1-4 A B C D
	private Double score;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIndicator() {
		return indicator;
	}
	public void setIndicator(Integer indicator) {
		this.indicator = indicator;
	}
	public Employee getEvaluator() {
		return evaluator;
	}
	public void setEvaluator(Employee evaluator) {
		this.evaluator = evaluator;
	}
	public Integer getElement() {
		return element;
	}
	public void setElement(Integer element) {
		this.element = element;
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
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Satisfaction [choose=" + choose + ", element=" + element
				+ ", evaluator=" + evaluator + ", id=" + id + ", indicator="
				+ indicator + ", score=" + score + "]";
	}
	
	
	
	
}
