package com.ravi.service;

import java.util.List;

import com.ravi.vo.TravellerVO;

public interface ITravellerMgmtService {


	public String registerTraveller(TravellerVO vo);
	public String registerTravellers(List<TravellerVO> listVO);
	public List<TravellerVO> showAllTravellers();
	public List<TravellerVO> showAllTravellersByIds(List<Integer> ids);
	public List<TravellerVO> getTravellersByBudgetRange(Double startRange,Double endRange);
	public TravellerVO getTravellerById(Integer id);
	public String updateTraveller(TravellerVO vo);
	public String updateTeavellerBudget(Integer tid,Double discountPercentage);
	public String deleteTravellerById(Integer tid);
	public String deleteTravelerByBudgetRange(Double startBudget,Double endBudget);
}
