package ch.so.agi.avdpool.model;

import java.io.Serializable;
import java.util.Date;

public class DeliveryModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String municipality;
	private int fosnr;
	private String itfName;
	private Date uploadDate;
	
	public String getMunicipality() {
		return municipality;
	}
	
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	
	public int getFosnr() {
		return fosnr;
	}
	
	public void setFosnr(int fosnr) {
		this.fosnr = fosnr;
	}
	
	public String getItfName() {
		return itfName;
	}
	
	public void setItfName(String itfName) {
		this.itfName = itfName;
	}
	
	public Date getUploadDate() {
		return uploadDate;
	}
	
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
}
