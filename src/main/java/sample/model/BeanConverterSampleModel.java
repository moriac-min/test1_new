package sample.model;

import java.util.ArrayList;
import java.util.List;

import sample.beans.BaseBean;
import sample.beans.CodeBean;
import sample.beans.InfoBean;
import sample.beans.ModifiedBean;
import sample.beans.ResultBean;
import sample.beans.SelectBean;
import sample.beans.UserBean;

public class BeanConverterSampleModel {

	private final String[][] infoArr = {
			{ "1", "배송지1", "011-1111-1111", "100-400", "서울 중구 청운동" },
			{ "2", "배송지2", "02-2222-2222", "110-720", "서울 종로구 효자동" },
			{ "3", "다른 곳", "016-3333-3333", "165-320", "서울 관악구 봉천동" } };

	private final String[][] codeArr = { { "011", "SKT" }, { "016", "KT" },
			{ "019", "LGT" } };

	public BaseBean select(BaseBean ibean) throws Exception {

		SelectBean sBean = (SelectBean) ibean;
		UserBean inUserbean = sBean.getUserInfo();

		System.out.println("[IN] " + inUserbean);

		SelectBean outVO = new SelectBean();

		// user put
		UserBean userInfo = new UserBean();

		userInfo.setUserID("TMP_1234");
		userInfo.setUserName("홍길동");
		userInfo.setAddress("서울 구로구 구로3동 대륭포스트 타워2차");

		outVO.setUserInfo(userInfo);

		// infoList put
		List infoList = new ArrayList();
		InfoBean infoBean = null;

		for (int i = 0; i < infoArr.length; i++) {

			infoBean = new InfoBean();

			infoBean.setNumber(Integer.parseInt(infoArr[i][0]));
			infoBean.setTitle(infoArr[i][1]);
			infoBean.setTelno(infoArr[i][2]);
			infoBean.setZip(infoArr[i][3]);
			infoBean.setAddress(infoArr[i][4]);

			infoList.add(infoBean);
		}

		outVO.setInfoList(infoList);

		// codeList put
		List codeList = new ArrayList();
		CodeBean codeBean = null;

		for (int i = 0; i < codeArr.length; i++) {

			codeBean = new CodeBean();

			codeBean.setCode(codeArr[i][0]);
			codeBean.setValue(codeArr[i][1]);

			codeList.add(codeBean);
		}

		outVO.setCodeList(codeList);

		return outVO;
	}

	
	public BaseBean modified(BaseBean ibean) throws Exception {

		ModifiedBean bean = (ModifiedBean) ibean;

		List infoList = bean.getInfoList();
		InfoBean infoBean = null;

		for (int i = 0; i < infoList.size(); i++) {
			infoBean = (InfoBean) infoList.get(i);
			System.out.println("[Modified Item] number=" + infoBean.getNumber());
			System.out.println("[Modified Item] title=" + infoBean.getTitle());
			System.out.println("[Modified Item] telno=" + infoBean.getTelno());
			System.out.println("[Modified Item] zip=" + infoBean.getZip());
			System.out.println("[Modified Item] address=" + infoBean.getAddress());
			System.out.println("[Modified Item] rowStatus=" + infoBean.getRowStatus());

		}

		// output
		ResultBean rtnResult = new ResultBean();

		rtnResult.setResult(infoList.size() + "건 success");
		
		ModifiedBean outVO = new ModifiedBean();
		outVO.setRtnResult(rtnResult);
		
		return outVO;

	}
}
