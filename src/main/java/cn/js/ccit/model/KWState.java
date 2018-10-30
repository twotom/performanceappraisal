package cn.js.ccit.model;

/**
 * keywork 状态
 */
public class KWState {
    private Integer id;
    private Department department;
    private String evaluator;
    private Integer state;

    public KWState() {
    }

    public KWState(Department department, String evaluator) {
        this.department = department;
        this.evaluator = evaluator;
    }

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(String evaluator) {
        this.evaluator = evaluator;
    }

    @Override
    public String toString() {
        return "KWState{" +
                "id=" + id +
                ", department=" + department +
                ", evaluator='" + evaluator + '\'' +
                ", state=" + state +
                '}';
    }
}
