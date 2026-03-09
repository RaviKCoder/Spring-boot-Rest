package com.ravi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ravi.entity.TravellerEntity;

public interface ITravellerRepository extends JpaRepository<TravellerEntity,Integer> {

	@Query("FROM TravellerEntity WHERE budget BETWEEN :start AND :end")
	public List<TravellerEntity> fetchTravellersByBudgetRange(@Param("start")Double strartRange,@Param("end") Double endRange);

	@Modifying
	@Transactional
	@Query("DELETE FROM TravellerEntity WHERE budget BETWEEN :startBudget AND :endBudget")
	public Integer deleteTravellerByBudgetRange(@Param("startBudget") Double startBudget,@Param("endBudget") Double endBudget );


}
