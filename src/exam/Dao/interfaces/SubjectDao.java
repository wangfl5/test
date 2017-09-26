package exam.Dao.interfaces;

import java.util.List;

import utils.Page;
import exam.domain.Subject;

public interface SubjectDao extends CommonDao<Subject> {

	List<Subject> querySubjectBypage(Page page);

}
