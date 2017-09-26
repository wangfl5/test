package exam.Service.Impl;

import java.util.List;

import utils.Page;
import utils.PageResult;

import exam.Dao.interfaces.ResultDao;
import exam.Service.interfaces.ResultService;
import exam.domain.Result;

public class ResultServiceImpl extends CommonServiceImpl<Result> implements
		ResultService {
	private ResultDao resultdao;
	public void setResultdao(ResultDao resultdao) {
		this.resultdao = resultdao;
	}
	public ResultDao getResultdao() {
		return resultdao;
	}
	@Override
	public List<Result> findbystaffId(int staffId) {
		return resultdao.findbystaffId(staffId);
	}
	@Override
	public PageResult queryResultBypage(Page page) {
		page = utils.PageUtil.createPage(page.getEveryPage(), resultdao.findAllEntry().size(),  page.getCurrentPage());
		List<Result> list = resultdao.queryResultBypage(page);
		PageResult pageResult = new PageResult(page, list);
		return pageResult;
	}
	@Override
	public List<Result> findByPaper(int pId) {
		
		return resultdao.findByPaper(pId);
	}
	@Override
	public int getEntryByCondition(int pId, int staffId) {
		// TODO Auto-generated method stub
		return resultdao.getEntryByCondition(pId, staffId);
	}
	


}
