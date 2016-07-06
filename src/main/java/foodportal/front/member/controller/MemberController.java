package foodportal.front.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import abc.cms.util.LoginUtil;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import common.commonfacillity.log.CommonLog;
import foodportal.front.member.service.MemberService;
import foodportal.front.member.vo.MemberVO;

@Controller
public class MemberController {
	
	@CommonLog Logger log;
	@Autowired
	private MemberService memberService;

	@RequestMapping("/portal/member/policy.do")
	public String basic(MemberVO memberVO, Model model) throws Exception {
		MemberVO mv = new MemberVO();
		
		memberVO.setPolicy_type("TERM 01");
		mv = memberService.selectPolicy(memberVO);
		model.addAttribute("term01", mv);
		
		memberVO.setPolicy_type("TERM02");
		mv = memberService.selectPolicy(memberVO);
		model.addAttribute("term02", mv);
		
		memberVO.setPolicy_type("TERM03");
		mv = memberService.selectPolicy(memberVO);
		model.addAttribute("term03", mv);
		
		return "layout/member/policy";
	}
	
	/**
	 * 정책 동의 화면
	 * @param memberVO
	 * @return policyList
	 */
	@RequestMapping("/portal/member/policyView.do")
	public String policyView(MemberVO memberVO, Model model) throws Exception {
		
		List<MemberVO> policyList = memberService.selectPolicyList(memberVO);
		model.addAttribute("policyList", policyList);
		
		return "layout/member/policy";
	}
	
	/**
	 * 로그인 화면
	 * @param memberVO
	 * @return 
	 */
	@RequestMapping("/portal/member/login.do")
	public ModelAndView login(MemberVO memberVO, Model model) throws Exception {
		
		ModelAndView mv = new ModelAndView("layout/member/login");
		
		return mv;
	}
	
	/**
	 * 로그인 체크
	 * @param memberVO
	 * @return idDup
	 */
	@RequestMapping(value = "/portal/member/ajax/chkLogin.do",method=RequestMethod.POST)
	public @ResponseBody void chkLogin(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		memberVO.setId(request.getParameter("user_id"));
		memberVO.setPassword(request.getParameter("pwd"));
		
		MemberVO idDup = memberService.selectMember(memberVO);
		
		if (idDup != null) {
			LoginUtil.login(request, idDup);
			
			HttpSession session = request.getSession();
			String redirect = (String) session.getAttribute("abc.cms.redirect");
			idDup.setRedirect(redirect);
			
			session.removeAttribute("abc.cms.redirect");
		}
		
		response.setContentType("text/plain;charset=utf-8");
		response.getWriter().write(new Gson().toJson(idDup));
	}
	
	/**
	 * 아이디 찾기
	 * @param memberVO
	 * @return 
	 */
	@RequestMapping("/portal/member/popup/findId.do")
	public ModelAndView findId() throws Exception {
		ModelAndView mv = new ModelAndView("layout/member/findId");
		
		return mv;
	}
	
	/**
	 * 비밀 번호 재설정 화면
	 * @param memberVO
	 * @return mv
	 */
	@RequestMapping("/portal/member/newPwView.do")
	public String newPwView(MemberVO memberVO, Model model) throws Exception {
		
		MemberVO mv = memberService.selectMember(memberVO);
		model.addAttribute("member", mv);
		
		return "layout/member/resetPw";
	}
	
	/**
	 * 비밀 번호 재설정 결과 화면
	 * @param memberVO
	 * @return resetPwResult
	 */
	@RequestMapping("/portal/member/resetPwResultView.do")
	public String resetPwResultView(MemberVO memberVO, Model model) throws Exception {
		
		int resetPwResult = memberService.updateMember(memberVO);
		model.addAttribute("resetPwResult", resetPwResult);
		
		return "layout/member/resetPw";
	}
	
	/**
	 * 실명 확인
	 * @param memberVO
	 * @return
	 */
	@RequestMapping("/portal/member/pop/realNameAuthView.do")
	public ModelAndView realNameAuthView() throws Exception{
		ModelAndView mv = new ModelAndView("");
		//실명 확인 인증 팝업창
		//실명인증 모듈 호출
		return mv;
	}
	
	/**
	 * 아이디 중복 체크
	 * @param memberVO
	 * @return
	 */
	@RequestMapping(value = "/portal/member/ajax/chkIdDuplication.do",method=RequestMethod.POST)
	public @ResponseBody void chkIdDuplication(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		memberVO.setId(request.getParameter("user_id"));
		MemberVO idDup = memberService.selectIdDuplication(memberVO);
		
		response.setContentType("text/plain;charset=utf-8");
		response.getWriter().write(new Gson().toJson(idDup));
	}

	
	/**
	 * 1회성 비밀 토큰을 만들어 반환한다
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/portal/member/memberToken.do", produces = "text/javascript", method = RequestMethod.POST)
	public @ResponseBody String generateMemberToken(HttpSession session) {
		// TODO 하드코딩된 ID를 프로그램적으로 가져오도록 수정
		String memberId = "testUser";
		if (memberId == null)
			return "null"; // 로그인 안한 경우

		String token = memberService.generateMemberToken(memberId);
		JsonObject data = new JsonObject();
		data.addProperty("memberId", memberId);
		data.addProperty("token", token);
		
		return data.toString();
	}
}
