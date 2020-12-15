package utils;
/*
 * 顾客实体类
 */
public class Customer {

	private int id;
	private String cusPhone;
	private String cusPassword;
	private String cusName;
	private String cusIDNum;
	private String cusCCNum;
	private String cusPhoto;
	private int cusStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCusPhone() {
		return cusPhone;
	}
	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}
	public String getCusPassword() {
		return cusPassword;
	}
	public void setCusPassword(String cusPassword) {
		this.cusPassword = cusPassword;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusIDNum() {
		return cusIDNum;
	}
	public void setCusIDNum(String cusIDNum) {
		this.cusIDNum = cusIDNum;
	}
	public String getCusCCNum() {
		return cusCCNum;
	}
	public void setCusCCNum(String cusCCNum) {
		this.cusCCNum = cusCCNum;
	}
	public String getCusPhoto() {
		return cusPhoto;
	}
	public void setCusPhoto(String cusPhoto) {
		this.cusPhoto = cusPhoto;
	}
	public int getCusStatus() {
		return cusStatus;
	}
	public void setCusStatus(int cusStatus) {
		this.cusStatus = cusStatus;
	}
}
