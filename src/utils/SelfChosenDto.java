package utils;
/*
 * 基金自选实体类 用于显示自选基金
 */
public class SelfChosenDto {

	private String fundCode;
	private String fundName;
	private double fundNAV;
	private double fundYearYields;
	private int fundType;
	private int fundInvestType;
	private int fundBuyStatus;
	private String fundInvestTypeToString;
	
	public String getFundInvestTypeToString() {
		return fundInvestTypeToString;
	}
	public void setFundInvestTypeToString(String fundInvestTypeToString) {
		this.fundInvestTypeToString = fundInvestTypeToString;
	}
	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public double getFundNAV() {
		return fundNAV;
	}
	public void setFundNAV(double fundNAV) {
		this.fundNAV = fundNAV;
	}
	public double getFundYearYields() {
		return fundYearYields;
	}
	public void setFundYearYields(double fundYearYields) {
		this.fundYearYields = fundYearYields;
	}
	public int getFundType() {
		return fundType;
	}
	public void setFundType(int fundType) {
		this.fundType = fundType;
	}
	public int getFundInvestType() {
		return fundInvestType;
	}
	public void setFundInvestType(int fundInvestType) {
		this.fundInvestType = fundInvestType;
	}
	public int getFundBuyStatus() {
		return fundBuyStatus;
	}
	public void setFundBuyStatus(int fundBuyStatus) {
		this.fundBuyStatus = fundBuyStatus;
	}
}
