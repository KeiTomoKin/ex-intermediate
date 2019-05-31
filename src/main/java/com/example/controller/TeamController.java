package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;


/**
 * チーム関連機能の処理の制御を行うコントローラー
 * 
 * @author keita.tomooka
 *
 */
@Controller
@RequestMapping("/team")
public class TeamController {
	@Autowired
	private TeamService teamService;

	/**
	 * チーム一覧を出力する.
	 * 
	 * @param model リクエストスコープ
	 * @return チーム一覧画面
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<Team> teamList = teamService.showList();
		model.addAttribute("teamList", teamList);
		return "team/list";
	}
	
	/**
	 * チーム情報を出力する.
	 * @param id ID
	 * @param model リクエストスコープ
 	 * @return チーム詳細画面
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id,Model model) {
		Team team =teamService.showDetail(Integer.valueOf(id));
		model.addAttribute("team", team);
		return "team/detail";
	}
}
