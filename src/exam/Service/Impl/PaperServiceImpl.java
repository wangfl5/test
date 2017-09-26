package exam.Service.Impl;

import java.util.Date;
import java.util.List;

import utils.Page;
import utils.PageResult;
import exam.Dao.interfaces.PaperDao;
import exam.Service.interfaces.PaperService;
import exam.domain.Paper;

public class PaperServiceImpl extends CommonServiceImpl<Paper> implements
		PaperService {
	private PaperDao paperdao;
	
	public PaperDao getPaperdao() {
		return paperdao;
	}

	public void setPaperdao(PaperDao paperdao) {
		this.paperdao = paperdao;
	}

	
	public PageResult queryPaperBypage(Page page, String examName, Date examStart, Date examEnd) {
		page = utils.PageUtil.createPage(page.getEveryPage(), paperdao.queryPaperBycondition(examName,examStart,examEnd).size(),  page.getCurrentPage());
		List<Paper> list = paperdao.queryPaperBypage(page,examName,examStart,examEnd);
		PageResult pageResult = new PageResult(page, list);
		return pageResult;
	}

	@Override
	public List<Paper> queryPaperBy(String examName, Date examStart,
			Date examEnd) {
		return paperdao.queryPaperBycondition(examName, examStart, examEnd);
	}

	@Override
	public List<Paper> findQuestionbyDate(Date date) {
		
		return paperdao.findQuestionbyDate(date);
	}

	

}
