package exam.Dao.interfaces;

import java.util.Date;
import java.util.List;

import utils.Page;
import exam.domain.Paper;

public interface PaperDao extends CommonDao<Paper> {

	List<Paper> queryPaperBypage(Page page, String examName, Date examStart, Date examEnd);
	List<Paper> queryPaperBycondition(String examName, Date examStart, Date examEnd);
	List<Paper> findQuestionbyDate(Date date);
}
