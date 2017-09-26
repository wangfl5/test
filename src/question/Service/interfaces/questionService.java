package question.Service.interfaces;

import java.util.Date;
import java.util.List;

import question.domain.Question;
import utils.Page;
import utils.PageResult;
import exam.Service.interfaces.CommonService;

public interface questionService extends CommonService<Question> {

	List<Question> findQuestionbyDate(Date date);

	PageResult queryQuestionBypage(Page page);

}
