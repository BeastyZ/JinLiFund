package utils;
/*
 * 统计基金总额的实体类
 */
public class CalFundAssetsDto {

	private int buyShare;
	private double fundNAV;
	
	public int getBuyShare() {
		return buyShare;
	}
	public void setBuyShare(int buyShare) {
		this.buyShare = buyShare;
	}
	public double getFundNAV() {
		return fundNAV;
	}
	public void setFundNAV(double fundNAV) {
		this.fundNAV = fundNAV;
	}	
}
