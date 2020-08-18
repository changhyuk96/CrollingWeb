package com.my.crolling;

public class CityInfo{
	
	private String cityName;
	private String todayTotal;
	private String foreign;
	private String domestic;
	private String confirmedPatient;
	private String recoveredPatient;
	private String totalPatient;
	private String recoveredRate;
	
	public CityInfo(String cityName,String todayTotal,
			String foreign, String domestic, String totalPatient,
			String confirmedPatient,String recoveredPatient) {
		this.cityName = cityName;
		this.todayTotal = todayTotal;
		this.foreign = foreign;
		this.domestic = domestic;
		this.totalPatient = totalPatient;
		this.recoveredPatient = recoveredPatient;
		this.confirmedPatient = confirmedPatient;
		double rate = (Double.parseDouble(recoveredPatient.replace(",", ""))*100)/(Double.parseDouble(totalPatient.replace(",", "")));
		this.recoveredRate = String.format("%.1f%%", rate);
	}

	public String getRecoveredRate() {
		return recoveredRate;
	}


	public void setRecoveredRate(String recoveredRate) {
		this.recoveredRate = recoveredRate;
	}


	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getTodayTotal() {
		return todayTotal;
	}

	public void setTodayTotal(String todayTotal) {
		this.todayTotal = todayTotal;
	}

	public String getForeign() {
		return foreign;
	}

	public void setForeign(String foreign) {
		this.foreign = foreign;
	}

	public String getDomestic() {
		return domestic;
	}

	public void setDomestic(String domestic) {
		this.domestic = domestic;
	}

	public String getConfirmedPatient() {
		return confirmedPatient;
	}

	public void setConfirmedPatient(String confirmedPatient) {
		this.confirmedPatient = confirmedPatient;
	}

	public String getRecoveredPatient() {
		return recoveredPatient;
	}

	public void setRecoveredPatient(String recoveredPatient) {
		this.recoveredPatient = recoveredPatient;
	}

	public String getTotalPatient() {
		return totalPatient;
	}

	public void setTotalPatient(String totalPatient) {
		this.totalPatient = totalPatient;
	}
	
}
