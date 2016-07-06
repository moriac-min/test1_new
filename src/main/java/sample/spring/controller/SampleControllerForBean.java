package sample.spring.controller;


import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sample.beans.BaseBean;
import sample.model.BeanConverterSampleModel;
import websquare.system.adapter.annotation.BEAN_DEF;

@Controller
public class SampleControllerForBean {

	protected Log log = LogFactory.getLog(this.getClass());

	/** sampleServiceForBean */
	@Resource(name = "sampleServiceForBean")
	private BeanConverterSampleModel sampleService;

	@RequestMapping(value="/sample/spring/bean/getSelect.do")
	@BEAN_DEF (beans={"root=sample.beans.SelectBean", "userInfo=sample.beans.UserBean", "infoList=sample.beans.InfoBean", "codeList=sample.beans.CodeBean" })
	public ModelAndView getSelect( BaseBean ibean ) throws Exception {
		System.out.println("%%%%%%% getSelect %%%%%%%%%");
		
		ModelAndView mav = new ModelAndView("wqView");
		Object retObj = null;

		try {
			retObj = sampleService.select(ibean);

			mav.addObject("result" , retObj);
			// mav.addObject("msgCode" , "success");
		} catch ( Exception e ) {
			mav.addObject("result" , retObj);
			// mav.addObject("msgCode" , "error");
		}

		return mav;
	}


	@RequestMapping(value="/sample/spring/bean/setModified.do")
	@BEAN_DEF (beans={ "root=sample.beans.ModifiedBean", "infoList=sample.beans.InfoBean", "rtnResult=sample.beans.ResultBean"})
	public ModelAndView setModified( BaseBean ibean ) throws Exception {

		ModelAndView mav = new ModelAndView("wqView");
		Object retObj = null;

		try {
			retObj = sampleService.modified(ibean);

			mav.addObject("result" , retObj);
			// mav.addObject("msgCode" , "success");
		} catch ( Exception e ) {
			mav.addObject("result" , retObj);
			// mav.addObject("msgCode" , "error");
		}

		return mav;
	}

}
