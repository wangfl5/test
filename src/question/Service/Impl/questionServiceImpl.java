package question.Service.Impl;

import java.util.Date;
import java.util.List;

import question.Dao.interfaces.questionDao;
import question.Service.interfaces.questionService;
import question.domain.Question;
import utils.Page;
import utils.PageResult;
import exam.Service.Impl.CommonServiceImpl;
import exam.domain.Subject;

public class questionServiceImpl extends CommonServiceImpl<Question> implements
		questionService {
	private questionDao questiondao;
	
	public questionDao getQuestiondao() {
		return questiondao;
	}

	public void setQuestiondao(questionDao questiondao) {
		this.questiondao = questiondao;
	}

	@Override
	public List<Question> findQuestionbyDate(Date date) {	
		return questiondao.findQuestionbyDate(date);
	}

	@Override
	public PageResult queryQuestionBypage(Page page) {
		page = utils.PageUtil.createPage(page.getEveryPage(), questiondao.findAllEntry().size(),  page.getCurrentPage());
		List<Question> list = questiondao.queryQuestionBypage(page);
		PageResult pageResult = new PageResult(page, list);
		return pageResult;
	}

	

}
