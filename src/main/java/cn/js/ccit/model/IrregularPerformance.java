package cn.js.ccit.model;
/**
 * 
 *例外绩效
 */
public class IrregularPerformance {
	private Integer id;
	/**
	 * 一级指标
	 * 1：突出贡献
	 * 2：严重失误
	 */
	private Integer first;
	private Integer second;//二级指标
	private Integer element;//考核元素  可不用
	private Department department;//考核部门
	private Employee evaluator;
	private Double score;//打分
	private String comment;//备注依据
	private String evidenceFile;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFirst() {
		return first;
	}

	public void setFirst(Integer first) {
		this.first = first;
	}

	public Integer getSecond() {
		return second;
	}

	public void setSecond(Integer second) {
		this.second = second;
	}

	public Integer getElement() {
		return element;
	}

	public void setElement(Integer element) {
		this.element = element;
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
		return "IrregularPerformance [comment=" + comment + ", element="
				+ element + ", first=" + first + ", id=" + id + ", score="
				+ score + ", second=" + second + "]";
	}

}
