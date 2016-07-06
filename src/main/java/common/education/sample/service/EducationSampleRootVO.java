package common.education.sample.service;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.uia.WqResultBean;

public class EducationSampleRootVO extends WqBaseBean {

	private EducationSampleVO educationSampleVO;
	private List educationSampleList;
	private List educationSampleList2;
	private List educationSampleList3;

	public EducationSampleVO getEducationSampleVO() {
		return educationSampleVO;
	}

	public void setEducationSampleVO(EducationSampleVO educationSampleVO) {
		this.educationSampleVO = educationSampleVO;
	}

	public List getEducationSampleList() {
		List educationSampleListTmp = null;
		if(educationSampleList != null){
			educationSampleListTmp = educationSampleList;
		}
		return educationSampleListTmp;
	}

	public void setEducationSampleList(List educationSampleList) {
		this.educationSampleList = educationSampleList;
	}

	public List getEducationSampleList2() {
		List educationSampleList2Tmp = null;
		if(educationSampleList2 != null){
			educationSampleList2Tmp = educationSampleList2;
		}
		return educationSampleList2Tmp;
	}

	public void setEducationSampleList2(List educationSampleList2) {
		this.educationSampleList2 = educationSampleList2;
	}

	public List getEducationSampleList3() {
		List educationSampleList3Tmp = null;
		if(educationSampleList3 != null){
			educationSampleList3Tmp = educationSampleList3;
		}
		return educationSampleList3Tmp;
	}

	public void setEducationSampleList3(List educationSampleList3) {
		this.educationSampleList3 = educationSampleList3;
	}
	
}
