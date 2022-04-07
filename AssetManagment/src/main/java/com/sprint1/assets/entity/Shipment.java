package com.sprint1.assets.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Shipment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
	@SequenceGenerator(name = "my_seq", sequenceName = "MY_SEQ", allocationSize = 1)
	@Column(name = "shipment_Id")
	private int shipmentId;
	@Column(name = "shipment_Company_Name")
	private String shipmentCompanyName;
	@Column(name = "shipment_State")
	private String shipmentState;
	@Column(name = "shipment_Country")
	private String shipmentCountry;
	@Column(name = "sub_Location")
	private String subLocation;
	@OneToOne
	@JoinColumn(name = "assetId", referencedColumnName = "asset_Id")
	private Asset asset;

	public Shipment() {
	}

	public Shipment(int shipmentId, String shipmentCompanyName, String shipmentState, String shipmentCountry,
			String subLocation, Asset asset) {
		super();
		this.shipmentId = shipmentId;
		this.shipmentCompanyName = shipmentCompanyName;
		this.shipmentState = shipmentState;
		this.shipmentCountry = shipmentCountry;
		this.subLocation = subLocation;
		this.asset = asset;
	}

	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public String getShipmentCompanyName() {
		return shipmentCompanyName;
	}

	public void setShipmentCompanyName(String shipmentCompanyName) {
		this.shipmentCompanyName = shipmentCompanyName;
	}

	public String getShipmentState() {
		return shipmentState;
	}

	public void setShipmentState(String shipmentState) {
		this.shipmentState = shipmentState;
	}

	public String getShipmentCountry() {
		return shipmentCountry;
	}

	public void setShipmentCountry(String shipmentCountry) {
		this.shipmentCountry = shipmentCountry;
	}

	public String getSubLocation() {
		return subLocation;
	}

	public void setSubLocation(String subLocation) {
		this.subLocation = subLocation;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	@Override
	public String toString() {
		return "Shipment [shipmentId=" + shipmentId + ", shipmentCompanyName=" + shipmentCompanyName
				+ ", shipmentState=" + shipmentState + ", shipmentCountry=" + shipmentCountry + ", subLocation="
				+ subLocation + ", asset=" + asset + "]";
	}

}