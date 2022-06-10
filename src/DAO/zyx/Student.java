package DAO.zyx;

public class Student {
    private int studentId;
    private String studentName;
    private String studentPassword;
    private String schoolName;
    private String schoolType;
    private String cameFrom;
    private String dreamSchoolType;
    private String dreamSchoolLoc;
    private String dreamSchoolName;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public String getCameFrom() {
        return cameFrom;
    }

    public void setCameFrom(String cameFrom) {
        this.cameFrom = cameFrom;
    }

    public String getDreamSchoolType() {
        return dreamSchoolType;
    }

    public void setDreamSchoolType(String dreamSchoolType) {
        this.dreamSchoolType = dreamSchoolType;
    }

    public String getDreamSchoolLoc() {
        return dreamSchoolLoc;
    }

    public void setDreamSchoolLoc(String dreamSchoolLoc) {
        this.dreamSchoolLoc = dreamSchoolLoc;
    }

    public String getDreamSchoolName() {
        return dreamSchoolName;
    }

    public void setDreamSchoolName(String dreamSchoolName) {
        this.dreamSchoolName = dreamSchoolName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", schoolType='" + schoolType + '\'' +
                ", cameFrom='" + cameFrom + '\'' +
                ", dreamSchoolType='" + dreamSchoolType + '\'' +
                ", dreamSchoolLoc='" + dreamSchoolLoc + '\'' +
                ", dreamSchoolName='" + dreamSchoolName + '\'' +
                '}';
    }
}
