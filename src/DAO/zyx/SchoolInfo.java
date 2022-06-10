package DAO.zyx;

public class SchoolInfo {
    private int schoolId;
    private String schoolName;
    private String schoolType;
    private double allCoursesMin;
    private double allCoursesMean;
    private double allCoursesMax;
    private double englishMin;
    private double englishMean;
    private double englishMax;
    private double politicsMin;
    private double politicsMean;
    private double politicsMax;
    private double firstProfessionalMin;
    private double firstProfessionalMean;
    private double firstProfessionalMax;
    private double secondProfessionalMin;
    private double secondProfessionalMean;
    private double secondProfessionalMax;
    private int reExamNumber;

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
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

    public double getAllCoursesMin() {
        return allCoursesMin;
    }

    public void setAllCoursesMin(double allCoursesMin) {
        this.allCoursesMin = allCoursesMin;
    }

    public double getAllCoursesMean() {
        return allCoursesMean;
    }

    public void setAllCoursesMean(double allCoursesMean) {
        this.allCoursesMean = allCoursesMean;
    }

    public double getAllCoursesMax() {
        return allCoursesMax;
    }

    public void setAllCoursesMax(double allCoursesMax) {
        this.allCoursesMax = allCoursesMax;
    }

    public double getEnglishMin() {
        return englishMin;
    }

    public void setEnglishMin(double englishMin) {
        this.englishMin = englishMin;
    }

    public double getEnglishMean() {
        return englishMean;
    }

    public void setEnglishMean(double englishMean) {
        this.englishMean = englishMean;
    }

    public double getEnglishMax() {
        return englishMax;
    }

    public void setEnglishMax(double englishMax) {
        this.englishMax = englishMax;
    }

    public double getPoliticsMin() {
        return politicsMin;
    }

    public void setPoliticsMin(double politicsMin) {
        this.politicsMin = politicsMin;
    }

    public double getPoliticsMean() {
        return politicsMean;
    }

    public void setPoliticsMean(double politicsMean) {
        this.politicsMean = politicsMean;
    }

    public double getPoliticsMax() {
        return politicsMax;
    }

    public void setPoliticsMax(double politicsMax) {
        this.politicsMax = politicsMax;
    }

    public double getFirstProfessionalMin() {
        return firstProfessionalMin;
    }

    public void setFirstProfessionalMin(double firstProfessionalMin) {
        this.firstProfessionalMin = firstProfessionalMin;
    }

    public double getFirstProfessionalMean() {
        return firstProfessionalMean;
    }

    public void setFirstProfessionalMean(double firstProfessionalMean) {
        this.firstProfessionalMean = firstProfessionalMean;
    }

    public double getFirstProfessionalMax() {
        return firstProfessionalMax;
    }

    public void setFirstProfessionalMax(double firstProfessionalMax) {
        this.firstProfessionalMax = firstProfessionalMax;
    }

    public double getSecondProfessionalMin() {
        return secondProfessionalMin;
    }

    public void setSecondProfessionalMin(double secondProfessionalMin) {
        this.secondProfessionalMin = secondProfessionalMin;
    }

    public double getSecondProfessionalMean() {
        return secondProfessionalMean;
    }

    public void setSecondProfessionalMean(double secondProfessionalMean) {
        this.secondProfessionalMean = secondProfessionalMean;
    }

    public double getSecondProfessionalMax() {
        return secondProfessionalMax;
    }

    public void setSecondProfessionalMax(double secondProfessionalMax) {
        this.secondProfessionalMax = secondProfessionalMax;
    }

    public int getReExamNumber() {
        return reExamNumber;
    }

    public void setReExamNumber(int reExamNumber) {
        this.reExamNumber = reExamNumber;
    }

    @Override
    public String toString() {
        return "SchoolInfo{" +
                "schoolId=" + schoolId +
                ", schoolName='" + schoolName + '\'' +
                ", schoolType='" + schoolType + '\'' +
                ", allCoursesMin=" + allCoursesMin +
                ", allCoursesMean=" + allCoursesMean +
                ", allCoursesMax=" + allCoursesMax +
                ", englishMin=" + englishMin +
                ", englishMean=" + englishMean +
                ", englishMax=" + englishMax +
                ", politicsMin=" + politicsMin +
                ", politicsMean=" + politicsMean +
                ", politicsMax=" + politicsMax +
                ", firstProfessionalMin=" + firstProfessionalMin +
                ", firstProfessionalMean=" + firstProfessionalMean +
                ", firstProfessionalMax=" + firstProfessionalMax +
                ", secondProfessionalMin=" + secondProfessionalMin +
                ", secondProfessionalMean=" + secondProfessionalMean +
                ", secondProfessionalMax=" + secondProfessionalMax +
                ", reExamNumber=" + reExamNumber +
                '}';
    }
}
