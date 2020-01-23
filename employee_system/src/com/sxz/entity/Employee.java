/**
 * Project Name:employee_system
 * File Name:Employee.java
 * Package Name:com.sxz.entity
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.entity;

import java.io.Serializable;

/**
 * Description: Employee类<br/>
 * 
 * @author songXZ
 * @version
 * @see
 */

// 一般实体实现序列化接口
public class Employee implements Serializable {
    private Integer empno;

    private String empname;

    private Integer empsex;

    private String job;

    private String hiredate;

    private double salary;

    private Integer sid;

    private Integer deptno;

    private String hobby;

    private String leader;

    private String deptname;

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public Employee() {

        super();
        // Auto-generated constructor stub

    }

    public Employee(Integer empno, String empname, Integer empsex, String job, String hiredate, double salary,
            Integer sid, Integer deptno, String deptname, String hobby) {
        super();
        this.empno = empno;
        this.empname = empname;
        this.empsex = empsex;
        this.job = job;
        this.hiredate = hiredate;
        this.salary = salary;
        this.sid = sid;
        this.deptno = deptno;
        this.deptname = deptname;
        this.hobby = hobby;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Integer getEmpsex() {
        return empsex;
    }

    public void setEmpsex(Integer empsex) {
        this.empsex = empsex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Employee [empno=" + empno + ", empname=" + empname + ", empsex=" + empsex + ", job=" + job
                + ", hiredate=" + hiredate + ", salary=" + salary + ", sid=" + sid + ", deptno=" + deptno
                + ", deptname=" + deptname + ", hobby=" + hobby + ", leader=" + leader + "]";
    }

}
