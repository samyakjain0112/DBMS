package com.samyak.secureap.dao;

import java.util.List;

import com.samyak.secureap.models.Distributer;

public interface DistributerDao {

	Distributer getAllDetailsDistributer(int loginId);
	void save(Distributer distributer);
	void delete(int loginId);
	List<Distributer> getAllDistributers();
}
