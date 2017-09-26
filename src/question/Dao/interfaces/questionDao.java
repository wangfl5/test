package question.Dao.interfaces;

import java.util.Date;
import java.util.List;

import question.domain.Question;
import utils.Page;
import exam.Dao.interfaces.CommonDao;

public interface questionDao extends CommonDao<Question> {

	List<Question> findQuestionbyDate(Date date);

	List<Question> queryQuestionBypage(Page page);

}
