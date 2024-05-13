package com.linkcheckweb.demo.model;

public class OneRegion {
	private String name;
	private String hostname;
	private boolean policyStatus;
	private boolean vehicleStatus;
	public OneRegion() {
		super();
	}
	public OneRegion(String name, String hostname, boolean policyStatus, boolean vehicleStatus) {
		super();
		this.name = name;
		this.hostname = hostname;
		this.policyStatus = policyStatus;
		this.vehicleStatus = vehicleStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public boolean isPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(boolean policyStatus) {
		this.policyStatus = policyStatus;
	}
	public boolean isVehicleStatus() {
		return vehicleStatus;
	}
	public void setVehicleStatus(boolean vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}
	

}
