package DAO.yx;

public class SchoolList {
    private int schoolId;
    private int recruitNumber;
    private int englishType;
    private int mathType;
    private int politicType;
    private String schoolName;
    private String schoolLoc;
    private String schoolType;
    private String preProfessionalCourses;
    private String reProfessionalCourses;


    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }



    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public int getRecruitNumber() {
        return recruitNumber;
    }

    public void setRecruitNumber(int recruitNumber) {
        this.recruitNumber = recruitNumber;
    }

    public int getEnglishType() {
        return englishType;
    }

    public void setEnglishType(int englishType) {
        this.englishType = englishType;
    }

    public int getMathType() {
        return mathType;
    }

    public void setMathType(int mathType) {
        this.mathType = mathType;
    }

    public int getPoliticType() {
        return politicType;
    }

    public void setPoliticType(int politicType) {
        this.politicType = politicType;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolLoc() {
        return schoolLoc;
    }

    public void setSchoolLoc(String schoolLoc) {
        this.schoolLoc = schoolLoc;
    }

    public String getPreProfessionalCourses() {
        return preProfessionalCourses;
    }

    public void setPreProfessionalCourses(String preProfessionalCourses) {
        this.preProfessionalCourses = preProfessionalCourses;
    }

    public String getReProfessionalCourses() {
        return reProfessionalCourses;
    }

    public void setReProfessionalCourses(String reProfessionalCourses) {
        this.reProfessionalCourses = reProfessionalCourses;
    }

    @Override
    public String toString() {
        return "SchoolList{" +
                "schoolId=" + schoolId +
                ", recruitNumber=" + recruitNumber +
                ", englishType=" + englishType +
                ", mathType=" + mathType +
                ", politicType=" + politicType +
                ", schoolName='" + schoolName + '\'' +
                ", schoolLoc='" + schoolLoc + '\'' +
                ", schoolType='" + schoolType + '\'' +
                ", preProfessionalCourses='" + preProfessionalCourses + '\'' +
                ", reProfessionalCourses='" + reProfessionalCourses + '\'' +
                '}';
    }
}
