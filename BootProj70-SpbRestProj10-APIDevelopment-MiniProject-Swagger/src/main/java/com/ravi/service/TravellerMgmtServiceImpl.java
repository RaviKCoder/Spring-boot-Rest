package com.ravi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.TravellerEntity;
import com.ravi.exception.TravellerNotFoundException;
import com.ravi.repository.ITravellerRepository;
import com.ravi.vo.TravellerVO;

@Service
public class TravellerMgmtServiceImpl implements ITravellerMgmtService {

	@Autowired
	ITravellerRepository travellerRepo;

	@Override
	public String registerTraveller(TravellerVO vo) {
		// convert vo to entity
		TravellerEntity entity = new TravellerEntity();
		BeanUtils.copyProperties(vo, entity);
		entity.setCreatedBy(System.getProperty("user.name"));

		// use repo
		Integer idVal = travellerRepo.save(entity).getTid();

		return "Traveller is saved with id value: " + idVal;
	}

	@Override
	public String registerTravellers(List<TravellerVO> listVO) {

		// convert ListVO to ListEntity

//		List<TravellerEntity> listEntity=new ArrayList<TravellerEntity>();
//		listVO.forEach(vo->{
//			TravellerEntity entity=new TravellerEntity();
//			BeanUtils.copyProperties(vo, entity);
//			entity.setCreatedBy(System.getProperty("user.name"));
//			listEntity.add(entity);
//		});

		List<TravellerEntity> listEntity = listVO.stream().map(vo -> {
			TravellerEntity entity = new TravellerEntity();
			BeanUtils.copyProperties(vo, entity);
			entity.setCreatedBy(System.getProperty("user.name"));
			return entity;
		}).collect(Collectors.toList());

		// use repo
		List<TravellerEntity> savedEntity = travellerRepo.saveAll(listEntity);

		// get only id values
		List<Integer> ids = savedEntity.stream().map(TravellerEntity::getTid).collect(Collectors.toList());

		// return the message
		return savedEntity.size() + " Travellers are saved with id values: " + ids;
	}

	@Override
	public List<TravellerVO> showAllTravellers() {
		// user repo
		List<TravellerEntity> listEntity = travellerRepo.findAll();

		// convert listEntity to listVO
		List<TravellerVO> listVO = listEntity.stream().map(entity -> {
			TravellerVO vo = new TravellerVO();
			BeanUtils.copyProperties(entity, vo);
			return vo;
		}).collect(Collectors.toList());

		return listVO;
	}

	@Override
	public List<TravellerVO> showAllTravellersByIds(List<Integer> ids) {

		// use repo
		List<TravellerEntity> allById = travellerRepo.findAllById(ids);

		// convert listEntity to listVO object
		List<TravellerVO> listVO = allById.stream().map(entity -> {
			TravellerVO vo = new TravellerVO();
			BeanUtils.copyProperties(entity, vo);
			return vo;
		}).collect(Collectors.toList());

		return listVO;
	}

	@Override
	public List<TravellerVO> getTravellersByBudgetRange(Double startRange, Double endRange) {
		if (startRange > endRange) {
			throw new IllegalArgumentException("start range can't be greater than end range");
		}

		// use repo
		List<TravellerEntity> listEntity = travellerRepo.fetchTravellersByBudgetRange(startRange, endRange);

		// convert listEntity to listVO
		List<TravellerVO> listVO = new ArrayList<TravellerVO>();

		for (TravellerEntity entity : listEntity) {

			TravellerVO vo = new TravellerVO();

			// copy matching properties
			BeanUtils.copyProperties(entity, vo);
			listVO.add(vo);

		}
		return listVO;
	}

	@Override
	public TravellerVO getTravellerById(Integer id) {

		// use repo
		TravellerEntity entity = travellerRepo.findById(id)
				.orElseThrow(() -> new TravellerNotFoundException("Traveller not found with id:" + id));

		// convert entity to vo
		TravellerVO vo = new TravellerVO();

		BeanUtils.copyProperties(entity, vo);

		return vo;
	}

	@Override
	public String updateTraveller(TravellerVO vo) {
		// use repo
		TravellerEntity entity = travellerRepo.findById(vo.getTid())
				.orElseThrow(() -> new TravellerNotFoundException("Traveller not found with id: " + vo.getTid()));

		// convert vo to entity
		BeanUtils.copyProperties(vo, entity);

		// update the object
		travellerRepo.save(entity);

		return "Traveller object is updated";
	}

	@Override
	public String updateTeavellerBudget(Integer tid, Double discountPercentage) {
		// use repo
		TravellerEntity entity = travellerRepo.findById(tid)
				.orElseThrow(() -> new TravellerNotFoundException("Traveller not found with id: " + tid));

		// calculate discount amount
		Double discount = entity.getBudget() * discountPercentage / 100.0;

		// set the final amount
		entity.setBudget(entity.getBudget() - discount);

		// update the object
		TravellerEntity savedEntity = travellerRepo.save(entity);

		return "Traveller budget is updated successfully with id value:" + savedEntity.getTid();
	}

	@Override
	public String deleteTravellerById(Integer tid) {
		// use repo
		TravellerEntity entity = travellerRepo.findById(tid)
				.orElseThrow(() -> new TravellerNotFoundException("Traveller not found with id: " + tid));

		// delete the object
		travellerRepo.deleteById(tid);

		return "traveller deleted by id: " + entity.getTid();
	}

	@Override
	public String deleteTravelerByBudgetRange(Double startBudget, Double endBudget) {
		// use repo
		Integer deletedCount = travellerRepo.deleteTravellerByBudgetRange(startBudget, endBudget);

		if (deletedCount == 0) {
			throw new TravellerNotFoundException(
					"No teaveller found within budget range: " + startBudget + "------" + endBudget);
		}

		return deletedCount + " no of traveller are deleted based on " + startBudget + "-----" + endBudget + " range";
	}

}
