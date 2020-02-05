/**
 * Project Name:LibraryManagementSystem
 * File Name:Student.java
 * Package Name:com.sxz.entity
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.entity;

/**
 * Description: 学生类 <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class Student {
    private Integer stuId;

    private String stuName;

    private int sex;

    private String college;

    private String className;

    private String admissionTime;

    public Student() {

    }

    public Student(String stuName, int sex, String college, String className, String admissionTime) {
        this.stuName = stuName;
        this.sex = sex;
        this.college = college;
        this.className = className;
        this.admissionTime = admissionTime;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(String admissionTime) {
        this.admissionTime = admissionTime;
    }

    @Override
    public String toString() {
        return "Student [stuId=" + stuId + ", stuName=" + stuName + ", sex=" + sex + ", college=" + college
                + ", className=" + className + ", admissionTime=" + admissionTime + "]";
    }

}
