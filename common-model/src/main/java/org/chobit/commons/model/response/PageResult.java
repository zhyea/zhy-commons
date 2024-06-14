package org.chobit.commons.model.response;

import java.util.List;
import java.util.Objects;

/**
 * 分页数据
 *
 * @author robin
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


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}
		PageResult<?> that = (PageResult<?>) o;
		return Objects.equals(total, that.total)
				&& Objects.equals(pageNo, that.pageNo)
				&& Objects.equals(pageSize, that.pageSize);
	}


	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), total, pageNo, pageSize);
	}
}
