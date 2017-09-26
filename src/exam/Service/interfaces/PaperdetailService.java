package exam.Service.interfaces;

import java.util.List;

import exam.domain.Paperdetail;

public interface PaperdetailService extends CommonService<Paperdetail> {

	public List<Paperdetail> findSubjects(int p_id);

}
