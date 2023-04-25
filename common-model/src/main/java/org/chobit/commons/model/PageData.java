package org.chobit.commons.model;

import java.util.List;

/**
 * 分页数据
 *
 * @author rui.zhang
 */
public class PageData<T> {


    /**
     * 记录总数
     */
    private Long total;

    /**
     * 页码
     */
    private Integer pageNo = 1;

    /**
     * 每页记录数
     */
    private Integer pageSize = 10;

    /**
     * 数据
     */
    private List<T> data;


    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
