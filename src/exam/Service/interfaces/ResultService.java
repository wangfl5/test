package exam.Service.interfaces;

import java.util.List;

import utils.Page;
import utils.PageResult;

import exam.domain.Result;

public interface ResultService extends CommonService<Result> {

	List<Result> findbystaffId(int staffId);

	PageResult queryResultBypage(Page page);

	List<Result> findByPaper(int pId);

	int getEntryByCondition(int pId, int staffId);

}
