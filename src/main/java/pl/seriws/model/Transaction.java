package pl.seriws.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue
	private Long id;
	private double price;
	private String clientName;
	private String clientLastName;
	private String serialNumber;
	private String phoneNumber;
	private String clientmail;
	private Date startDate;
	private Date endDate;
	private String model;
	private String comments;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientLastName() {
		return clientLastName;
	}
	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getClientmail() {
		return clientmail;
	}
	public void setClientmail(String clientmail) {
		this.clientmail = clientmail;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", price=" + price + ", clientName=" + clientName + ", clientLastName="
				+ clientLastName + ", serialNumber=" + serialNumber + ", phoneNumber=" + phoneNumber + ", clientmail="
				+ clientmail + ", startDate=" + startDate + ", endDate=" + endDate + ", model=" + model + ", comments="
				+ comments + "]";
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}