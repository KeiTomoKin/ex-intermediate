package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

/**
 * チーム情報を操作するサービス .
 * 
 * @author keita.tomooka
 *
 */
@Service
@Transactional
public class TeamService {
	@Autowired
	private TeamRepository teamRepository;

	/**
	 * チーム情報を全権取得する.
	 * 
	 * @return チーム一覧情報
	 */
	public List<Team> showList() {
		return teamRepository.findAll();
	}

	/**
	 * チーム情報を取得する.
	 * 
	 * @param id ID
	 * @return チーム情報
	 */
	public Team showDetail(Integer id) {
		return teamRepository.load(id);
	}

}
