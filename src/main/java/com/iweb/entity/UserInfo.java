package com.iweb.entity;

/**
 * bookstoresmanager   IntelliJ IDEA
 * BookInfo
 *
 * @param
 * @author minghuachen
 * @date 2023/6/8 13:53
 */
public class UserInfo {
    private String userId;
    private String userName;
    private Integer sex;
    private String education;
    private String age;
    private String salary;
    private String tax;
    private Integer nativeProvince;
    private Integer nativeCity;
    private String writerId;


    public UserInfo() {
    }



    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public UserInfo(String userId, String userName, Integer sex, String education, String age, String salary, String tax, Integer nativeProvince, Integer nativeCity, String writerId) {
        this.userId = userId;
        this.userName = userName;
        this.sex = sex;
        this.education = education;
        this.age = age;
        this.salary = salary;
        this.tax = tax;
        this.nativeProvince = nativeProvince;
        this.nativeCity = nativeCity;
        this.writerId = writerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Integer getNativeProvince() {
        return nativeProvince;
    }

    public void setNativeProvince(Integer nativeProvince) {
        this.nativeProvince = nativeProvince;
    }

    public Integer getNativeCity() {
        return nativeCity;
    }

    public void setNativeCity(Integer nativeCity) {
        this.nativeCity = nativeCity;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", education='" + education + '\'' +
                ", age='" + age + '\'' +
                ", salary='" + salary + '\'' +
                ", nativeProvince=" + nativeProvince +
                ", nativeCity=" + nativeCity +
                ", writerId='" + writerId + '\'' +
                '}';
    }
}
