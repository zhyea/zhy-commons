package org.chobit.commons.model.response;

import java.util.List;
import java.util.Objects;


/**
 * 分页信息
 *
 * @param <T> 数据类型
 */
public class PageItem<T> {


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
     * 数据集
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageItem<?> pageItem = (PageItem<?>) o;
        return Objects.equals(total, pageItem.total)
                && Objects.equals(pageNo, pageItem.pageNo)
                && Objects.equals(pageSize, pageItem.pageSize)
                && Objects.equals(data, pageItem.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, pageNo, pageSize, data);
    }
}
