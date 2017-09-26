package exam.Service.interfaces;

import java.util.Date;
import java.util.List;

import utils.Page;
import utils.PageResult;
import exam.domain.Paper;

public interface PaperService extends CommonService<Paper> {

	PageResult queryPaperBypage(Page page, String examName, Date examStart, Date examEnd);

	List<Paper> queryPaperBy(String examName, Date examStart, Date examEnd);

	List<Paper> findQuestionbyDate(Date date);

}
