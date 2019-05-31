package com.example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelServiceTest {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Test
	public void testSearchByLessThanPrice0() {
		System.out.println("検索結果の要素取得テスト開始");
		List <Hotel> resultHotelList = hotelRepository.searchByLessThanPrice(5000);
		assertThat("", resultHotelList.get(0).getAreaName(), is("首都圏"));
		assertThat("", resultHotelList.get(0).getHotelName(), is("ホテルローズガーデン新宿"));
		assertThat("", resultHotelList.get(0).getAddress(), is("東京都新宿区西新宿８−１−３"));
		assertThat("", resultHotelList.get(0).getNearestStation(), is("西新宿駅"));
		assertThat("", resultHotelList.get(0).getPrice(), is(5000));
		assertThat("", resultHotelList.get(0).getParking(), is("あり"));
		System.out.println("検索結果の要素取得テスト終了");
	}
	
	@Test
	public void testSearchByLessThanPrice1() {
		System.out.println("全件検索するテスト開始");
		List <Hotel> resultHotelList = hotelRepository.searchByLessThanPrice(null);
		assertThat("全件検索ができていません", resultHotelList.size(), is(5));
		System.out.println("全件検索するテスト終了");
	}

	@Test
	public void testSearchByLessThanPrice2() {
		System.out.println("検索するテスト開始");
		List <Hotel> resultHotelList = hotelRepository.searchByLessThanPrice(5000);
		assertThat("全件検索ができていません", resultHotelList.size(), is(1));
		System.out.println("検索するテスト終了");
	}
	
	@Test
	public void testSearchByLessThanPrice3() {
		System.out.println("検索するテスト開始");
		List <Hotel> resultHotelList = hotelRepository.searchByLessThanPrice(15000);
		assertThat("全件検索ができていません", resultHotelList.size(), is(4));
		System.out.println("検索するテスト終了");
	}
}
