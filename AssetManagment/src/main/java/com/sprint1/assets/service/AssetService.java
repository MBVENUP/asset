package com.sprint1.assets.service;
import java.util.List;

import com.sprint1.assets.entity.Asset;
import com.sprint1.assets.exception.NotFoundException;

public interface AssetService {

public Asset addAsset(Asset asset);
public List<Asset> viewAsset();
public Asset searchAsset(int assetId) throws NotFoundException ;
//public boolean deleteAsset(int assetId) throws NotFoundException;
//public Asset modifyAsset(Asset asset) throws NotFoundException;

}

