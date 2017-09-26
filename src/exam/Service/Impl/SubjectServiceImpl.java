package exam.Service.Impl;

import java.util.List;

import utils.Page;
import utils.PageResult;
import exam.Dao.interfaces.SubjectDao;
import exam.Service.interfaces.SubjectService;
import exam.domain.Subject;

public class SubjectServiceImpl extends CommonServiceImpl<Subject> implements
		SubjectService {
	private SubjectDao subjectdao;
	
	public SubjectDao getSubjectdao() {
		return subjectdao;
	}

	public void setSubjectdao(SubjectDao subjectdao) {
		this.subjectdao = subjectdao;
	}

	@Override
	public PageResult querySubjectBypage(Page page) {
		page = utils.PageUtil.createPage(page.getEveryPage(), subjectdao.findAllEntry().size(),  page.getCurrentPage());
		List<Subject> list = subjectdao.querySubjectBypage(page);
		PageResult pageResult = new PageResult(page, list);
		return pageResult;
	}

	

}
