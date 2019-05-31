package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;

/**
 * ホテル関連機能の処理の制御を行うコントローラー.
 * 
 * @author keita.tomooka
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	/**
	 * ホテル検索画面を表示する.
	 * 
	 * @param model リクエストスコープ
	 * @return ホテル検索画面
	 */
	@RequestMapping("/")
	public String index(Model model) {
		List<Hotel> hotelList = new ArrayList<Hotel>();
		model.addAttribute("hotelList", hotelList);
		return "hotel";
	}

	/**
	 * ホテル検索結果画面を表示する.
	 * 
	 * @param price 金額
	 * @param model リクエストスコープ
	 * @return ホテル検索結果画面
	 */
	@RequestMapping("/result")
	public String result(Integer price, Model model) {
		List<Hotel> hotelList = hotelService.showList(price);
		model.addAttribute("hotelList", hotelList);
		return "hotel";
	}

}
