package com.sprint1.assets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint1.assets.entity.Asset;
import com.sprint1.assets.entity.Status;
import com.sprint1.assets.exception.NotFoundException;
import com.sprint1.assets.repository.AssetManagementRepository;
import com.sprint1.assets.service.AssetService;

@SpringBootTest
class AssetServiceImplTest {

	@Autowired
	AssetService assetService;

	@MockBean
	AssetManagementRepository assetRepo;

	Asset a;

	@Before
	public void setUp() throws Exception {
		a = getAsset();
	}

	private Asset getAsset() {
		Asset a1 = new Asset();
		a1.setAssetId(101);
		a1.setRecipientName("Venu");
		a1.setRecipientLocation("Mysuru");
		a1.setAssetManufacturer("Lenovo");
		a1.setAssetModel("Thinkpad");
		a1.setAssetType("Laptop");
		a1.setAssetStatus(Status.READY_TO_DELIVER);
		a1.setAssetMovementDate(LocalDate.of(2022, 04, 01));
		a1.setExpectedDeliveryDate(LocalDate.of(2022, 04, 05));
		a1.setActualDeliveredDate(LocalDate.of(2022, 04, 05));
		a1.setAssetSourceLocation("Bengaluru");
		a1.setAssetDestinationLocation("Mysuru");
		return a1;
	}

	@Test
	void testAddAsset() {

		Mockito.when(assetRepo.save(a)).thenReturn(a);
		assertThat(assetService.addAsset(a)).isEqualTo(a);
	}

	@Test
	void testViewAsset() {
		List<Asset> assetList = new ArrayList<>();
		Asset a2 = new Asset();
		a2.setAssetId(101);
		a2.setRecipientName("Venu");
		a2.setRecipientLocation("Mysuru");
		a2.setAssetManufacturer("Lenovo");
		a2.setAssetModel("Thinkpad");
		a2.setAssetType("Laptop");
		a2.setAssetStatus(Status.READY_TO_DELIVER);
		a2.setAssetMovementDate(LocalDate.of(2022, 04, 01));
		a2.setExpectedDeliveryDate(LocalDate.of(2022, 04, 05));
		a2.setActualDeliveredDate(LocalDate.of(2022, 04, 05));
		a2.setAssetSourceLocation("Bengaluru");
		a2.setAssetDestinationLocation("Mysuru");
		assetList.add(a);
		assetList.add(a2);

		Mockito.when(assetRepo.findAll()).thenReturn(assetList);
		assertThat(assetService.viewAsset().equals(assetList));
	}

	@Test
	void testSearchAsset() throws NotFoundException {
		Mockito.when(assetRepo.existsById(Mockito.anyInt())).thenReturn(true);
		Mockito.when(assetService.searchAsset(Mockito.anyInt())).thenReturn(a);
		assertEquals(a, assetService.searchAsset(Mockito.anyInt()));
	}
}
