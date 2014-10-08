package tn.nj.sorties.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Entity;

@javax.persistence.Entity
public class PointOfInterest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4392465714533064532L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String address;
	
	private String city;
	
	private String postalCode;
	
	private String tel;
	
	private String telMobile;
	
	private double latitude;
	
	private double longitude;
	
	private String comment;
	
	private String description;
	
	private String bannerImage;
	
	
	
	
	
	public PointOfInterest(){
		
	}
	
	
	public PointOfInterest(Entity entity){
		
		if(entity.getKey()!=null)
			this.id = entity.getKey().getId();
		
		this.name = (String)entity.getProperty("name");
		
		this.address = (String)entity.getProperty("address");
		
		this.city = (String)entity.getProperty("city");
		
		this.postalCode = (String)entity.getProperty("postalCode");
		
		this.tel = (String)entity.getProperty("tel");
		
		this.telMobile = (String)entity.getProperty("telMobile");
		
		if(entity.getProperty("latitude")!=null)
			this.latitude = (double)entity.getProperty("latitude");
		
		if(entity.getProperty("longitude")!=null)
			this.longitude= (double)entity.getProperty("longitude");
		
		this.comment = (String)entity.getProperty("comment");
		
		this.description = (String)entity.getProperty("description");
		
		this.bannerImage = (String)entity.getProperty("bannerImage");
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
	}





	public String getCity() {
		return city;
	}





	public void setCity(String city) {
		this.city = city;
	}





	public String getPostalCode() {
		return postalCode;
	}





	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}





	public String getTel() {
		return tel;
	}





	public void setTel(String tel) {
		this.tel = tel;
	}





	public String getTelMobile() {
		return telMobile;
	}





	public void setTelMobile(String telMobile) {
		this.telMobile = telMobile;
	}





	public double getLatitude() {
		return latitude;
	}





	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}





	public double getLongitude() {
		return longitude;
	}





	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}





	public String getComment() {
		return comment;
	}





	public void setComment(String comment) {
		this.comment = comment;
	}





	public String getBannerImage() {
		return bannerImage;
	}





	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	@Override
	public String toString() {
		return "PointOfInterest [id=" + id + ", name=" + name + ", address="
				+ address + ", city=" + city + ", postalCode=" + postalCode
				+ ", tel=" + tel + ", telMobile=" + telMobile + ", latitude="
				+ latitude + ", longitude=" + longitude + ", comment="
				+ comment + ", bannerImage=" + bannerImage + "]";
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
