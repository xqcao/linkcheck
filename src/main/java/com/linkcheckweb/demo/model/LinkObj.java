package com.linkcheckweb.demo.model;

import java.util.Map;

public class LinkObj {
	private String name;
	private String hostname;
	private boolean policyStatus;
	private boolean vehicleStatus;
	private Map<String, Object> linkDetails; 
	
	public LinkObj() {
		super();
	}
	public LinkObj(String name, String hostname, boolean policyStatus, boolean vehicleStatus) {
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
	public Map<String, Object> getLinkDetails() {
        return linkDetails;
    }

    public void setLinkDetails(Map<String, Object> linkDetails) {
        this.linkDetails = linkDetails;
    }
	@Override
	public String toString() {
		return "LinkObj [name=" + name + ", hostname=" + hostname + ", policyStatus=" + policyStatus
				+ ", vehicleStatus=" + vehicleStatus + ", linkDetails=" + linkDetails + "]";
	}

}
