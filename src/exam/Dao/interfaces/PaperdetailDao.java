package exam.Dao.interfaces;

import java.util.List;

import exam.domain.Paperdetail;

public interface PaperdetailDao extends CommonDao<Paperdetail> {

	public List<Paperdetail> findSubjects(int pId);

}
