package utils;
/*
 * 基金自选实体类 用于校验是否已经添加了自选
 */
public class SelfChosen {
	
	private String cusPhone;
	private String fundCode;
	
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
}
