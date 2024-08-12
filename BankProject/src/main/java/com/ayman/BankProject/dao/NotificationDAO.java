package com.ayman.BankProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayman.BankProject.beans.EmailNotification;

@Repository
public interface NotificationDAO extends JpaRepository<EmailNotification,Integer> {
	
	
	EmailNotification findEmailNotificationByNotificationId(Integer id);

}
