package com.sprint1.assets.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.assets.entity.Asset;
import com.sprint1.assets.exception.NotFoundException;
import com.sprint1.assets.repository.AssetManagementRepository;

@Service("assetImplementation")
public class AssetServiceImpl implements AssetService {
	@Autowired
	AssetManagementRepository assetRepository;
	
	@Transactional
	@Override
	public Asset addAsset(Asset asset)
	{
	return assetRepository.save(asset);
	}
		
	@Override
	public List<Asset> viewAsset() 
	{
		return assetRepository.findAll();
	}
	
	@Override
	public Asset searchAsset(int assetId) throws NotFoundException
	{
		
		if(assetRepository.existsById(assetId)) {
			assetRepository.findById(assetId);
			return assetRepository.getById(assetId);
		}
		return null;
	}
	
//	@Transactional
//	@Override
//	public Asset modifyAsset(Asset asset)  throws NotFoundException
//	{	
//		Asset a1= null;
//		if(assetRepository.existsById(asset.getAssetId())) {
//			a1=assetRepository.save(asset);
//		}
//		return a1;
//	}
//	
//	@Transactional
//	@Override
//	public boolean deleteAsset(int assetId) throws NotFoundException
//	{
//	if(assetRepository.existsById(assetId)) {
//	assetRepository.deleteById(assetId);
//	return true;
//	}
//	return false;
//	}

	
	
}
