package utils;
/*
 * 基金实体类
 */
public class Fund {
	
	private int id;
	private String fundCode;
	private String fundName;
	private String fundManager;
	private double fundScale;
	private String fundEstablishedTime;
	private String fundOwner;
	private int fundBuyStatus;
	private int fundSoldStatus;
	private double fundNAV;
	private int fundType;
	private int fundInvestType;
	private double fundShareScale;
	private int fundStatus;
	private double fundSeasonYields;
	private double fundYearYields;
	private String fundInvestTypeToString;
	private String fundTypeToString;
	private String fundBuyStatusToString;
	private String fundSoldStatusToString;
	
	public String getFundTypeToString() {
		return fundTypeToString;
	}
	public void setFundTypeToString(String fundTypeToString) {
		this.fundTypeToString = fundTypeToString;
	}
	public String getFundBuyStatusToString() {
		return fundBuyStatusToString;
	}
	public void setFundBuyStatusToString(String fundBuyStatusToString) {
		this.fundBuyStatusToString = fundBuyStatusToString;
	}
	public String getFundSoldStatusToString() {
		return fundSoldStatusToString;
	}
	public void setFundSoldStatusToString(String fundSoldStatusToString) {
		this.fundSoldStatusToString = fundSoldStatusToString;
	}
	public String getFundInvestTypeToString() {
		return fundInvestTypeToString;
	}
	public void setFundInvestTypeToString(String fundInvestTypeToString) {
		this.fundInvestTypeToString = fundInvestTypeToString;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getFundManager() {
		return fundManager;
	}
	public void setFundManager(String fundManager) {
		this.fundManager = fundManager;
	}
	public double getFundScale() {
		return fundScale;
	}
	public void setFundScale(double fundScale) {
		this.fundScale = fundScale;
	}
	public String getFundEstablishedTime() {
		return fundEstablishedTime;
	}
	public void setFundEstablishedTime(String fundEstablishedTime) {
		this.fundEstablishedTime = fundEstablishedTime;
	}
	public String getFundOwner() {
		return fundOwner;
	}
	public void setFundOwner(String fundOwner) {
		this.fundOwner = fundOwner;
	}
	public int getFundBuyStatus() {
		return fundBuyStatus;
	}
	public void setFundBuyStatus(int fundBuyStatus) {
		this.fundBuyStatus = fundBuyStatus;
	}
	public int getFundSoldStatus() {
		return fundSoldStatus;
	}
	public void setFundSoldStatus(int fundSoldStatus) {
		this.fundSoldStatus = fundSoldStatus;
	}
	public double getFundNAV() {
		return fundNAV;
	}
	public void setFundNAV(double fundNAV) {
		this.fundNAV = fundNAV;
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
	public double getFundShareScale() {
		return fundShareScale;
	}
	public void setFundShareScale(double fundShareScale) {
		this.fundShareScale = fundShareScale;
	}
	public int getFundStatus() {
		return fundStatus;
	}
	public void setFundStatus(int fundStatus) {
		this.fundStatus = fundStatus;
	}
	public double getFundSeasonYields() {
		return fundSeasonYields;
	}
	public void setFundSeasonYields(double fundSeasonYields) {
		this.fundSeasonYields = fundSeasonYields;
	}
	public double getFundYearYields() {
		return fundYearYields;
	}
	public void setFundYearYields(double fundYearYields) {
		this.fundYearYields = fundYearYields;
	}
}
