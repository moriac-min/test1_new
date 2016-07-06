package common.adminfacillity.systemmngt.service;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.uia.WqResultBean;

public class ProgramRootVO extends WqBaseBean {

	private ProgramVO programVO;
	private List programList;

	public ProgramVO getProgramVO() {
		return programVO;
	}

	public void setProgramVO(ProgramVO programVO) {
		this.programVO = programVO;
	}

	public List getProgramList() {
		List programListTmp = null;
		if(programList != null){
			programListTmp = programList;
		}
		return programListTmp;
	}

	public void setProgramList(List programList) {
		this.programList = programList;
	}
}
