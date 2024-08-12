package com.ayman.BankProject.beans;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "notifications")
public class EmailNotification {
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "notification_id")
	private Integer notificationId;
	
	@Column(name = "notification_date")
	private Date date;
	
	@Column(name = "content")
	private String text;
	
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public EmailNotification() {
		super();
	}

	public EmailNotification(Date date, String text) {
		super();
		this.date = date;
		this.text = text;
	}

	public Integer getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "EmailNotification [notificationId=" + notificationId + ", date=" + date + ", text=" + text + "]";
	}
	
	

}
