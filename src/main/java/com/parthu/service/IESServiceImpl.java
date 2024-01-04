package com.parthu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parthu.entity.IESEntity;
import com.parthu.repository.IESRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class IESServiceImpl implements IESService {

	@Autowired
	private IESRepo repo;

	@Override
	public IESEntity iesRecord(IESEntity entity) {
		repo.save(entity);
		return entity;
	}

	@Override
	public IESEntity iesGetRecord(Integer id) {
		Optional<IESEntity> findById = repo.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		} else {
			return null;
		}
	}

	@Override
	public List<IESEntity> iesGetRecordBasedOnName(String value) {
		List<IESEntity> findByName = repo.findByName(value + "%");
		return findByName;
	}

	@Override
	public IESEntity iesRecordUpdate(IESEntity entity, Integer id) {

		Optional<IESEntity> findById = repo.findById(id);
		if (findById.isPresent()) {
			IESEntity iesEntity = findById.get();
				iesEntity.setName(entity.getName());
				repo.save(iesEntity);
				return iesEntity;
		} else {
			throw new EntityNotFoundException("Record is not found "+id);
		}
	}

	@Override
	public String iesRecordDelete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IESEntity iesRecords() {
		// TODO Auto-generated method stub
		return null;
	}
}
