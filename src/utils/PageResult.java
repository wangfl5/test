package utils;

import java.util.List;
/**
 * 该类包含两个对象实例，一个是page，一个是实体类
 */
public class PageResult<T> {

	private Page page; // 分页信息
	private List<T> list; // 记录信息

	public PageResult(Page page, List list) {
		this.page = page;
		this.list = list;
	}

	public PageResult() {
		super();
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
