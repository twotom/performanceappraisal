package cn.js.ccit.model;

/*
    突出贡献自评类
 */
public class ContributeSelfEvaluation {
    private Integer id;
    private Double score;
    private String comment;
    private String evidenceFile;
    private Department department;
    private Integer indicator;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEvidenceFile() {
        return evidenceFile;
    }

    public void setEvidenceFile(String evidenceFile) {
        this.evidenceFile = evidenceFile;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getIndicator() {
        return indicator;
    }

    public void setIndicator(Integer indicator) {
        this.indicator = indicator;
    }
    @Override
    public String toString() {
        return "ContributeSelfEvaluation{" +
                "id=" + id +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", evidenceFile='" + evidenceFile + '\'' +
                ", department=" + department +
                ", indicator=" + indicator +
                '}';
    }
}
