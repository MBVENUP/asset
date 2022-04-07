package com.sprint1.assets.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Asset implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
	@SequenceGenerator(name = "my_seq", sequenceName = "MY_SEQ", allocationSize = 1)
	@Column(name = "asset_Id")
	private int assetId;
	@Column(name = "recipient_Name")
	private String recipientName;
	@Column(name = "recipient_Location")
	private String recipientLocation;
	@Column(name = "asset_Manufacturer")
	private String assetManufacturer;
	@Column(name = "asset_Model")
	private String assetModel;
	@Column(name = "asset_Type")
	private String assetType;
	@Column(name = "asset_Status")
	private Status assetStatus;

	@Column(name = "asset_Movement_Date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate assetMovementDate; // Dispatched Date

	@Column(name = "expected_Delivery_Date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate expectedDeliveryDate;

	@Column(name = "actual_Delivered_Date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate actualDeliveredDate;
	
	@Column(name = "asset_Source_Location") 
	private String assetSourceLocation;
	@Column(name = "asset_Destination_Location")
	private String assetDestinationLocation;
	@JsonIgnore
	@OneToOne(mappedBy = "asset", cascade = CascadeType.ALL)
	private Shipment shipment;

	public Asset() {

	}

	public Asset(int assetId, String recipientName, String recipientLocation, String assetManufacturer,
			String assetModel, String assetType, Status assetStatus, LocalDate assetMovementDate,
			LocalDate expectedDeliveryDate, LocalDate actualDeliveredDate, String assetSourceLocation,
			String assetDestinationLocation, Shipment shipment) {
		super();
		this.assetId = assetId;
		this.recipientName = recipientName;
		this.recipientLocation = recipientLocation;
		this.assetManufacturer = assetManufacturer;
		this.assetModel = assetModel;
		this.assetType = assetType;
		this.assetStatus = assetStatus;
		this.assetMovementDate = assetMovementDate;
		this.expectedDeliveryDate = expectedDeliveryDate;
		this.actualDeliveredDate = actualDeliveredDate;
		this.assetSourceLocation = assetSourceLocation;
		this.assetDestinationLocation = assetDestinationLocation;
		this.shipment = shipment;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientLocation() {
		return recipientLocation;
	}

	public void setRecipientLocation(String recipientLocation) {
		this.recipientLocation = recipientLocation;
	}

	public String getAssetManufacturer() {
		return assetManufacturer;
	}

	public void setAssetManufacturer(String assetManufacturer) {
		this.assetManufacturer = assetManufacturer;
	}

	public String getAssetModel() {
		return assetModel;
	}

	public void setAssetModel(String assetModel) {
		this.assetModel = assetModel;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public Status getAssetStatus() {
		return assetStatus;
	}

	public void setAssetStatus(Status assetStatus) {
		this.assetStatus = assetStatus;
	}

	public LocalDate getAssetMovementDate() {
		return assetMovementDate;
	}

	public void setAssetMovementDate(LocalDate assetMovementDate) {
		this.assetMovementDate = assetMovementDate;
	}

	public LocalDate getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public LocalDate getActualDeliveredDate() {
		return actualDeliveredDate;
	}

	public void setActualDeliveredDate(LocalDate actualDeliveredDate) {
		this.actualDeliveredDate = actualDeliveredDate;
	}

	public String getAssetSourceLocation() {
		return assetSourceLocation;
	}

	public void setAssetSourceLocation(String assetSourceLocation) {
		this.assetSourceLocation = assetSourceLocation;
	}

	public String getAssetDestinationLocation() {
		return assetDestinationLocation;
	}

	public void setAssetDestinationLocation(String assetDestinationLocation) {
		this.assetDestinationLocation = assetDestinationLocation;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", recipientName=" + recipientName + ", recipientLocation="
				+ recipientLocation + ", assetManufacturer=" + assetManufacturer + ", assetModel=" + assetModel
				+ ", assetType=" + assetType + ", assetStatus=" + assetStatus + ", assetMovementDate="
				+ assetMovementDate + ", expectedDeliveryDate=" + expectedDeliveryDate + ", actualDeliveredDate="
				+ actualDeliveredDate + ", assetSourceLocation=" + assetSourceLocation + ", assetDestinationLocation="
				+ assetDestinationLocation + ", shipment=" + shipment + "]";
	}

}
