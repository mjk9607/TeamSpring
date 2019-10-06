package com.test.springboard.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.springboard.services.BoardService;
import com.test.springboard.vo.BoardVO;
import com.test.springboard.vo.UserVO;

@Controller
@RequestMapping("/deleteBoard.do")
@SessionAttributes({"userVO", "boardVO"})
public class DeleteBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(DeleteBoardController.class);
	
	@Autowired
	private BoardService boardService;

	@ModelAttribute("userVO")
	public UserVO userVO() {
		UserVO userVO = new UserVO();
		return userVO;
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String showAddBoardList(@ModelAttribute("userVO") UserVO userVO,
									@ModelAttribute("boardVO") BoardVO boardVO,
								     Model model) {
		logger.info("Call : AddBoardList.jsp - GET DELETE INDEX : " + boardVO.getIdx());
		
		if(userVO.getId() == null) {
			return "redirect:login.do";
		}

		boardService.deleteBoard(boardVO);
		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addBoardList(@ModelAttribute("userVO") UserVO userVO, 
								@ModelAttribute("boardVO") BoardVO boardVO, 
								 Model model) {
		logger.info("Call : X");
		
		return "";
	}
}
