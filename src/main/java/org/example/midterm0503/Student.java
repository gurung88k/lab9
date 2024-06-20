package org.example.midterm0503;

public class Student {
    private int studentNum;
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;
    private String province;
    private int avgGrade;
    private String major;

    // Constructor
    public Student(int studentNum, String firstName, String lastName, String telephone,
                   String address, String province, int avgGrade, String major) {
        this.studentNum = studentNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
        this.province = province;
        this.avgGrade = avgGrade;
        this.major = major;
    }

    // Getters and setters (you may not need all depending on your use case)
    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(int avgGrade) {
        this.avgGrade = avgGrade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    // Override toString() method for debugging purposes (optional)
    @Override
    public String toString() {
        return "Student{" +
                "studentNum=" + studentNum +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", province='" + province + '\'' +
                ", avgGrade=" + avgGrade +
                ", major='" + major + '\'' +
                '}';
    }
}
