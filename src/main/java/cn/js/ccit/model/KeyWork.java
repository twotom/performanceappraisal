package cn.js.ccit.model;

/**
 *  重点工作 
 */
public class KeyWork {

	private Integer id;
	private Task task;
	private Integer grade;//档次
	private Integer level;//级别
	private Integer charge;//负荷
	private Employee evaluator;//考核人
	private Double score;//得分

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public Employee getEvaluator() {
		return evaluator;
	}
	public void setEvaluator(Employee evaluator) {
		this.evaluator = evaluator;
	}


	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getCharge() {
		return charge;
	}
	public void setCharge(Integer charge) {
		this.charge = charge;
	}
	@Override
	public String toString() {
		return "KeyWork [charge=" + charge + ", evaluator=" + evaluator
				+ ", grade=" + grade + ", id=" + id + ", level=" + level
				+ ", score=" + score + ", task=" + task + "]";
	}
	
}
