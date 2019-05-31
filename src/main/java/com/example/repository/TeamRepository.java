package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

/**
 * teamsテーブルを操作するリポジトリ.
 * 
 * @author keita.tomooka
 *
 */
@Repository
public class TeamRepository {
	private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("leage_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	};
	@Autowired
	NamedParameterJdbcTemplate template;

	/**
	 * チーム一覧情報を発足順に取得する.
	 * 
	 * @return チーム一覧情報を返す
	 */
	public List<Team> findAll() {
		String sql = "SELECT id,leagu_name,team_name,headquarters,inaugration,history ORDER BY inauguration";
		List<Team> teamList = template.query(sql, TEAM_ROW_MAPPER);
		return teamList;
	}

	/**
	 * 主キーからチーム情報を取得する.
	 * 
	 * @param id 主キー
	 * @return チーム情報
	 */
	public Team load(Integer id) {
		String sql = "SELECT id,leagu_name,team_name,headquarters,inaugration,history WEHER :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
		return team;
	}

}