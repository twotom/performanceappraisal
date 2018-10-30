package cn.js.ccit.model;
/**
 *日常绩效 
 *
 */
public class RoutinePerformance {

	private Integer id;
	/**
	 * 指标
	 * 1：自身建设  
	 * 2：工作规范 
	 */
	private Integer indicator;
	private Department department;
	private Employee evaluator;
	private Integer element;
	private Double score;
	private String comment;
	private String evidenceFile;
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Integer getElement() {
		return element;
	}
	public void setElement(Integer element) {
		this.element = element;
	}
	
	public Employee getEvaluator() {
		return evaluator;
	}
	public void setEvaluator(Employee evaluator) {
		this.evaluator = evaluator;
	}
	
	
	
	public String getEvidenceFile() {
		return evidenceFile;
	}
	public void setEvidenceFile(String evidenceFile) {
		this.evidenceFile = evidenceFile;
	}
	@Override
	public String toString() {
		return "RoutinePerformance [comment=" + comment + ", department="
				+ department + ", id=" + id + ", indicator=" + indicator
				+ ", score=" + score + "]";
	}
	
}
