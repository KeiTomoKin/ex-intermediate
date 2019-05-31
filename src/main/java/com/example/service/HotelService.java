package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテル情報を操作するサービス
 * 
 * @author keita.tomooka
 *
 */
@Service
@Transactional
public class HotelService {
	@Autowired	
	private  HotelRepository hotelRepository;
	
	/**
	 * 指定した金額よりも安いホテルの情報リストを取得する.
	 * @param price 金額
	 * @return ホテル情報のリスト
	 */
	public List<Hotel> searchByLessThanPrice(Integer price){
		return hotelRepository.searchByLessThanPrice(price);
	}

}
