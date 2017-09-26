package exam.Dao.interfaces;

import java.util.List;

import utils.Page;

import exam.domain.Result;

public interface ResultDao extends CommonDao<Result> {

	List<Result> findbystaffId(int staffId);

	List<Result> queryResultBypage(Page page);

	List<Result> findByPaper(int pId);

	int getEntryByCondition(int pId, int staffId);

}
