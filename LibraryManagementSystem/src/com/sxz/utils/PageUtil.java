/**
 * Project Name:employee_system
 * File Name:PageUtil.java
 * Package Name:com.sxz.utils
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.utils;

import java.util.List;

/**
 * Description: 分页工具类 <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class PageUtil {
    // 分页查询的数据
    private List list;

    // 每页的数据量
    private Integer pageSize = 2;

    // 当前页数
    private Integer pageNum;

    // 开始下标
    private Integer startIndex;

    // 总记录数
    private Integer totalRecords;

    // 总页数
    private Integer totalPage;

    // 第一页
    private Integer firstPage;

    // 最后一页
    private Integer lastPage;

    // 上一页
    private Integer previousPage;

    // 下一页
    private Integer nextPage;

    // 需要分页的请求
    private String pageRequest;

    // 用于记录模糊的条件
    private String likename;

    // 显示页码
    private int startPage;

    private int endPage;

    public PageUtil() {

    }

    /**
     * 
     * Creates a new instance of PageUtil.
     *
     * @param totalRecords 总记录数，用来计算总页数
     * @param pageNum 当前页，用来计算起始页
     */
    public PageUtil(int totalRecords, int pageNum) {
        this.totalRecords = totalRecords;
        this.pageNum = pageNum;
        // 首页
        this.firstPage = 1;

        // 需要求出开始
        this.startIndex = (pageNum - 1) * pageSize;
        // 需要求出总页数
        this.totalPage = totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;

        // 显示页码
        if (totalPage <= 9) {
            startPage = 1;
            endPage = totalPage;
        } else {
            startPage = pageNum - 4;
            endPage = pageNum + 4;

            if (startPage < 1) {
                startPage = 1;
                endPage = 9;
            }

            if (endPage > totalPage) {
                endPage = totalPage;
                startPage = totalPage - 8;
            }
        }

        // 上一页
        if (this.pageNum > 1) {
            this.previousPage = this.pageNum - 1;
        } else
            this.previousPage = this.firstPage;
        // 尾页
        this.lastPage = this.totalPage;
        // 下一页
        if (this.pageNum < lastPage) {
            this.nextPage = this.pageNum + 1;
        } else
            this.nextPage = this.lastPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Integer firstPage) {
        this.firstPage = firstPage;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public Integer getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(Integer previousPage) {
        this.previousPage = previousPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public String getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(String pageRequest) {
        this.pageRequest = pageRequest;
    }

    public String getLikename() {
        return likename;
    }

    public void setLikename(String likename) {
        this.likename = likename;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    @Override
    public String toString() {
        return "PageUtil [pageSize=" + pageSize + ", pageNum=" + pageNum + ", startIndex=" + startIndex
                + ", totalRecords=" + totalRecords + ", firstPage=" + firstPage + ", lastPage=" + lastPage
                + ", previousPage=" + previousPage + ", nextPage=" + nextPage + ", pageRequest=" + pageRequest
                + ", likename=" + likename + "]";
    }

}
