package cn.xxh.gold.common.utils;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 功能：基类page中包含公有翻页参数及保存查询到的结果以被页面遍历， 被子类继承后将增加不同的查询条件 。
 * 
 */
public class Page implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 166595600002944789L;

	/**
	 * 当前页码， 从1开始计
	 */
	private long page = 1;

	/**
	 * 每页条数
	 */
	private int pagesize = 10;
	
	
	/**
	 * 排序方式
	 */
	private String sortOrderStr="";
	
	/**
	 * 总条数
	 */
	private long totalElements;

	/**
	 * 当前页数据
	 */
	private List datas;

	/**
	 * 总页数
	 */
	private long totalPages;
	
	
	/**
	 * sql limit offset 使用
	 */
	private long offset;
	
	
	

	public long getOffset() {
		offset = (page-1) * pagesize;
		return offset;
	}

	public void setOffset(long offset) {
		this.offset = offset;
	}

	/**
	 * 功能：获取当前页码
	 * 
	 */
	public long getPage() {
		return page;
	}

	/**
	 * 功能：设置当前页码
	 * 
	 */
	public void setPage(long page) {
		this.page = page;
	}

	/**
	 * 功能：获取每页显示条数
	 * 
	 */
	public int getPagesize() {
		return pagesize;
	}

	/**
	 * 功能：设置每页显示条数
	 * 
	 */
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	/**
	 * 功能：获取当前页数据
	 * 
	 */
	public List getDatas() {
		return datas;
	}

	/**
	 * 功能：设置当前页数据
	 * 
	 */
	public void setDatas(List datas) {
		this.datas = datas;
	}

	/**
	 * 功能：获取总条数
	 * 
	 */
	public long getTotalElements() {
		return totalElements;
	}

	/**
	 * 功能：设置总条数
	 * 
	 */
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	/**
	 * 功能：获取总页数
	 * 
	 */
	public long getTotalPages() {
		if (totalElements < 1) {
			return 0;
		}

		long totalPages = totalElements / pagesize;
		if (totalElements % pagesize != 0) {
			totalPages++;
		}

		return totalPages;
	}

	public String getSortOrderStr() {
		return sortOrderStr;
	}

	public void setSortOrderStr(String sortOrderStr) {
		this.sortOrderStr = sortOrderStr;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	}

}