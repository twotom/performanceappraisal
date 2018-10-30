package cn.js.ccit.model;

/**
 * 得分汇总
 */
public class ScoreSummary {
    private Department department;
    private Double score;//得分

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

    @Override
    public String toString() {
        return "ScoreSummary{" +
                "department=" + department +
                ", score=" + score +
                '}';
    }
}
