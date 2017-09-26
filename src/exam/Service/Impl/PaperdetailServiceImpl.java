package exam.Service.Impl;

import java.util.List;

import exam.Dao.interfaces.PaperdetailDao;
import exam.Service.interfaces.PaperdetailService;
import exam.domain.Paperdetail;

public class PaperdetailServiceImpl extends CommonServiceImpl<Paperdetail>
		implements PaperdetailService {

	private PaperdetailDao paperdetaildao;
	public void setPaperdetaildao(PaperdetailDao paperdetaildao) {
		this.paperdetaildao = paperdetaildao;
	}

	public PaperdetailDao getPaperdetaildao() {
		return paperdetaildao;
	}
	
	@Override
	public List<Paperdetail> findSubjects(int pId) {
		return paperdetaildao.findSubjects(pId);
		
	}

	

	

}
