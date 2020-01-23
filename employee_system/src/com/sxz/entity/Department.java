/**
 * Project Name:employee_system
 * File Name:Department.java
 * Package Name:com.sxz.entity
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.entity;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class Department {
    private Integer deptno;

    private String deptname;

    public Department() {

        super();
        // Auto-generated constructor stub

    }

    public Department(Integer deptno, String deptname) {
        super();
        this.deptno = deptno;
        this.deptname = deptname;
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

    @Override
    public String toString() {
        return "Department [deptno=" + deptno + ", deptname=" + deptname + "]";
    }
}
