package utils;

import java.util.Date;

public class PurchaseRec {

	int id;
	Date buyTime;
	String cusPhone;
	String fundCode;
	String fundName;
	int buyShare;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}
	public String getCusPhone() {
		return cusPhone;
	}
	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
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
	public int getBuyShare() {
		return buyShare;
	}
	public void setBuyShare(int buyShare) {
		this.buyShare = buyShare;
	}
}
