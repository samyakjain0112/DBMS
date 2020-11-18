package com.samyak.secureap.dao;

import java.util.List;

import com.samyak.secureap.models.Product;
import com.samyak.secureap.models.TreatmentAndFacilities;

public interface FacilitiesDao {

	int save(TreatmentAndFacilities facilities);
	boolean check(TreatmentAndFacilities facilities);
	void delete(int treatmentId);
	List<TreatmentAndFacilities> getAllFacilities();
	int getTreatmentId(int staffId);
}
