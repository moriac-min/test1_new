package foodportal.front.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import foodportal.front.member.service.MemberService;

@Controller
public class SampleController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping("/portal/sample/basic.do")
	public String basic() {
		return "layout/sampleContent";
	}
	
	@RequestMapping("/portal/popup/sample.do")
	public String popup(@RequestParam(required = false) String _memberId,
			@RequestParam(required = false) String _token) {
		if (_memberId == null || _token == null || !memberService.memberTokenMatches(_memberId, _token)) {
			throw new RuntimeException("로그인 후 정해진 링크를 통해 보실 수 있는 페이지입니다.");
		}
		
		return "layout/sampleContent";
	}
}
