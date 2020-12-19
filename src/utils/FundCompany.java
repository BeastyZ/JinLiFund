package utils;
/*
 * 基金公司实体类
 */
import java.math.BigDecimal;

public class FundCompany {

	private int id;
	private String comName;
	private BigDecimal assetManagementScale;
	private int fundNum;
	private String setupTime;
	private String generalManager;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public BigDecimal getAssetManagementScale() {
		return assetManagementScale;
	}
	public void setAssetManagementScale(BigDecimal assetManagementScale) {
		this.assetManagementScale = assetManagementScale;
	}
	public int getFundNum() {
		return fundNum;
	}
	public void setFundNum(int fundNum) {
		this.fundNum = fundNum;
	}
	public String getSetupTime() {
		return setupTime;
	}
	public void setSetupTime(String setupTime) {
		this.setupTime = setupTime;
	}
	public String getGeneralManager() {
		return generalManager;
	}
	public void setGeneralManager(String generalManager) {
		this.generalManager = generalManager;
	}
}
