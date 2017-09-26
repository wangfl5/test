package utils;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * page分页功能实现类
 * @author Home
 *
 */
public class PageUtil {

	public static Page createPage(int everyPage, int totalCount, int currentPage) {// 创建分页信息对象
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrentPage(currentPage);
		int totalPage = getTotalPage(everyPage, totalCount);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		return new Page(everyPage, totalCount, totalPage, currentPage, beginIndex, hasPrePage, hasNextPage);
	}

	public static int getEveryPage(int everyPage) { // 获得每页显示记录数
		return everyPage == 0 ? 10 : everyPage;
	}

	public static int getCurrentPage(int currentPage) { // 获得当前页
		return currentPage == 0 ? 1 : currentPage;
	}

	public static int getTotalPage(int everyPage, int totalCount) {// 获得总页数
		int totalPage = 0;
		if (totalCount != 0 && totalCount % everyPage == 0) {
			totalPage = totalCount / everyPage;
		} else {
			totalPage = totalCount / everyPage + 1;
		}
		return totalPage;
	}

	public static int getBeginIndex(int everyPage, int currentPage) {// 获得起始位置
		return (currentPage - 1) * everyPage;
	}

	public static boolean getHasPrePage(int currentPage) {// 获得是否有上一页
		return currentPage == 1 ? false : true;
	}

	public static boolean getHasNextPage(int totalPage, int currentPage) { // 获得是否有上一页
		return currentPage == totalPage || totalPage == 0 ? false : true;
	}
	
	public static List<?> getList(Session session, String hql, Page page){
		Query query = session.createQuery(hql);
		query.setMaxResults(page.getEveryPage()).setFirstResult(page.getBeginIndex());//Hibernate的分页方法
		List<?> list = query.list();
		return list;
	}

	public static <T> List<T> getList(Session session, String hql, int number) {
		List<T> list = session.createQuery(hql).setMaxResults(number).list();
		return list;
	}
	public static Page getPage(int everyPage, int currentPage){
		Page page = new Page();
		page.setEveryPage(everyPage);
		page.setCurrentPage(currentPage);
		return page;
	}
}
