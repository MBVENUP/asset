package com.sprint1.assets.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint1.assets.entity.Asset;
import com.sprint1.assets.entity.Status;

@Repository
public interface AssetManagementRepository extends JpaRepository<Asset, Integer> {

	
	@Query ("select a from Asset a where a.assetStatus=?1")
	public List<Asset> getReportStatus(Status assetStatus);

	@Query ("select a from Asset a where a.assetMovementDate >=?1 and a.assetMovementDate <=?2 and a.assetStatus=?3")
	public List<Asset> generateMonthlyReport(LocalDate fromDate,LocalDate toDate,Status assetStatus);

}