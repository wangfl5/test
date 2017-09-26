package exam.Service.interfaces;

import utils.Page;
import utils.PageResult;
import exam.domain.Subject;

public interface SubjectService extends CommonService<Subject> {

	PageResult querySubjectBypage(Page page);

}
