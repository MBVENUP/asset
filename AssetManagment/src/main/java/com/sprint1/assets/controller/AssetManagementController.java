package com.sprint1.assets.controller;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.assets.entity.Asset;
import com.sprint1.assets.exception.NotFoundException;
import com.sprint1.assets.service.AssetServiceImpl;

@RestController
@RequestMapping(path="/api/asset")
public class AssetManagementController {
	// Creating logger Object
	Logger logger = org.slf4j.LoggerFactory.getLogger(AssetManagementController.class);
	@Autowired
	AssetServiceImpl assetImplementation;

	// Creating and saving Asset
	@PostMapping(path = "/create")
	public ResponseEntity<String> createAsset(@Valid @RequestBody Asset asset){
		Asset savedAsset = assetImplementation.addAsset(asset);
		logger.info("Asset Created");
		ResponseEntity<String> response = new ResponseEntity<>(
				"Asset with the ID" + savedAsset.getAssetId() + "is created", HttpStatus.CREATED);
		return response;
	}

	// Displaying Assets
	@GetMapping(path = "/viewall")
	public ResponseEntity<List<Asset>> viewAsset() throws NotFoundException {
		List<Asset> listOfAsset = assetImplementation.viewAsset();
		if(listOfAsset.isEmpty()) {
			 throw new NotFoundException("invalid");
		}
		return new ResponseEntity<List<Asset>>(listOfAsset, HttpStatus.OK);
	}
	
	// Finding Assets
		@GetMapping(path = "/get/{id}")
		public Asset getAssetById(@PathVariable int id) throws NotFoundException {
			
			Asset asset = assetImplementation.searchAsset(id);
			if(asset==null)
			{
				throw new NotFoundException("AssetId not found");
			}
			return asset;
		}

//	// Removing Assets
//	@DeleteMapping(path = "/delete/{id}")
//	public ResponseEntity<String> deleteAsset(@PathVariable int id) throws NotFoundException {
//		boolean assetRemoved = assetImplementation.deleteAsset(id);
//		logger.info("Asset Deleted");
//		if (assetRemoved==false) {
//			 throw new NotFoundException("invalid");
//		}
//		ResponseEntity<String> response = new ResponseEntity<>("Asset with the ID" + id + "is deleted", HttpStatus.OK);
//		
//		
//		 return response;
//	}
//
//	// Updating Assets
//	@PutMapping(path = "/update")
//	public ResponseEntity<Asset> updateAsset(@RequestBody Asset asset) throws NotFoundException{
//		Asset assetUpdated = assetImplementation.modifyAsset(asset);
//		logger.info("Asset Updated");
//
//		if ((assetUpdated==null)) {
//			 throw new NotFoundException("invaild");
//			
//		}
//		return new ResponseEntity<Asset>(assetUpdated, HttpStatus.OK);
//	}

	

}
