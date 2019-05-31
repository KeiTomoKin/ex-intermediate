package com.example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Team;
import com.example.repository.TeamRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamServiceTest {
	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private NamedParameterJdbcTemplate template;


	
	@Test
	public void testLoad() {
		System.out.println("主キー検索するテスト開始");
		Integer giantsId = 1;
		Team resultTeam = teamRepository.load(giantsId);
		
		assertThat("リーグ名が登録されていません", resultTeam.getLeagueName(), is("セントラル・リーグ"));
		assertThat("球団名が登録されていません", resultTeam.getTeamName(), is("読売ジャイアンツ"));
		assertThat("本拠地が登録されていません", resultTeam.getHeadquarters(), is("東京ドーム（東京都・文京区）"));
		assertThat("発足が登録されていません", resultTeam.getInauguration(), is("1934年12月26日"));
		assertThat("歴史が登録されていません", resultTeam.getHistory(),
				is("大日本東京野球倶楽部（1934年）\n" + "↓\n" + "東京巨人軍（1935年〜1946年）\n" + "↓\n" + "読売ジャイアンツ（1947年〜）"));

		System.out.println("主キー検索するテスト終了");
	}
	
	@Test
	public void testFindALL() {
		System.out.println("全件検索するテスト開始");
		
		List<Team> resultTeamList = teamRepository.findAll();
		
		assertThat("順番が異なります", resultTeamList.get(0).getTeamName(), is("読売ジャイアンツ"));
		assertThat("順番が異なります", resultTeamList.get(1).getTeamName(), is("阪神タイガース"));
		assertThat("順番が異なります", resultTeamList.get(2).getTeamName(), is("中日ドラゴンズ"));
		assertThat("順番が異なります", resultTeamList.get(3).getTeamName(), is("横浜DeNAベイスターズ"));
		assertThat("順番が異なります", resultTeamList.get(4).getTeamName(), is("広島東洋カープ"));
		assertThat("順番が異なります", resultTeamList.get(5).getTeamName(), is("東京ヤクルトスワローズ"));

		System.out.println("全件検索するテスト終了");
	}
	
	

}
