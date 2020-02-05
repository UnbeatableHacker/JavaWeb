/**
 * Project Name:LibraryManagementSystem
 * File Name:Teacher.java
 * Package Name:com.sxz.entity
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.entity;

/**
 * Description: 教师表 <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class Teacher {
    private Integer teacherId;

    private String teacherName;

    private int sex;

    private String college;

    private String admissionTime;

    public Teacher() {

    }

    public Teacher(String teacherName, int sex, String college, String admissionTime) {
        this.teacherName = teacherName;
        this.sex = sex;
        this.college = college;
        this.admissionTime = admissionTime;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public String getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(String admissionTime) {
        this.admissionTime = admissionTime;
    }

    @Override
    public String toString() {
        return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", sex=" + sex + ", college="
                + college + ", admissionTime=" + admissionTime + "]";
    }

}
