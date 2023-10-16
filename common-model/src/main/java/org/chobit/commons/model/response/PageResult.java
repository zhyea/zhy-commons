package org.chobit.commons.model.response;

import java.util.List;

/**
 * 分页数据
 *
 * @author rui.zhang
 */
public class PageResult<T> extends Result<List<T>> {


    private static final long serialVersionUID = -4969393538580809626L;


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
}
