package org.chobit.commons.model.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * 分页查询请求
 *
 * @author robin
 */
public abstract class AbstractPageRequest implements Serializable {


    private static final long serialVersionUID = -5326486960307961945L;


    /**
     * 页码值
     */
    @NotNull(message = "页码值不能为空")
    private Integer pageNo;


    /**
     *
     */
    @Max(value = 100, message = "每页最多只能有100行记录")
    @NotNull(message = "每页记录数不能为空")
    private Integer pageSize;


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
