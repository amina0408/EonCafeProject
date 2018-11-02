package com.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.dao.OrderDaoImpl;
import com.dao.VendorDao;
import com.dao.VendorDaoImpl;
import com.dao.VendorExistsException;
import com.model.Vendor;

/**
 * 
 * @author User
 *This class provides vendor services 
 */

public class VendorService implements VendorServiceInterface{
	boolean status=true;

	private static List<Vendor> allVendorsList=new ArrayList<Vendor>();
	List<Integer>list=new ArrayList<Integer>();
	VendorDao vendordaoimpl=new VendorDaoImpl();
/**
 * This function is used to get the the vendor by givind vendor id as a parameter
 * @param vid represents the vendor id 
 * 
 */
		public Vendor getvendor(int vid)
		{
			Vendor vendor=vendordaoimpl.getVendor(vid);
			return vendor;
			
		}
		
		/**
		 * This function is used to get the list of vendors
		 * 
		 */
		public List<Vendor> getAllVendor() {
			allVendorsList = new ArrayList<Vendor>();
			allVendorsList = vendordaoimpl.getAllVendors();
			return allVendorsList;

		}
		/**
		 * This function is used to add the vendor 
		 * @param v represents the entire object of vendor with parameters vendor id,vendor name,vendor email,vendor password
		 */
		public void addVendor(Vendor v) throws VendorExistsException
		{
			vendordaoimpl.addVendor(v);
		}
		
		/**
		 * This function is used to delete vendor 
		 */
		
		public void deleteVendor(Vendor v)
		{
			vendordaoimpl.deleteVendor(v);;
		}
	
		
		
		
		/**
		 * This function is used to send mail to the customer from the vendors
		 * @param vendorMailId represents the mail id of vendor
		 * @param customerMailId represents mail id of customer
		 * @param password represents the password of vendor
		 */
		
		@Override
		public boolean sendMail(String vendorMailId,String customerMailId,String password,int oid) {
			try{
			//from-vendor emailId 
			String from=vendorMailId;
			//to-customer emailId
			String to=customerMailId;
			//host is smtp server
			String host ="smtp.gmail.com" ;
	        String user = from;
	        String pass = password;
	        //setting a subject
	        String subject = "Your Order Status In EON CAFE ";
	        //setting messageText
	        String messageText = "Dear customer,your order with OrderId:"+oid+ "is ready!! please collect it from our counter";
	        boolean sessionDebug = false;

	        Properties props = System.getProperties();

	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.required", "true");

	        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	        Session mailSession = Session.getDefaultInstance(props, null);
	        mailSession.setDebug(sessionDebug);
	        Message msg = new MimeMessage(mailSession);
	        msg.setFrom(new InternetAddress(from));
	        InternetAddress[] address = {new InternetAddress(to)};
	        msg.setRecipients(Message.RecipientType.TO, address);
	        msg.setSubject(subject); msg.setSentDate(new Date());
	        msg.setText(messageText);

	       Transport transport=mailSession.getTransport("smtp");
	       transport.connect(host, user, pass);
	       transport.sendMessage(msg, msg.getAllRecipients());
	       transport.close();
	       System.out.println("message sent successfully");
	    }catch(Exception ex)
	    {
	    	System.out.println(" Exception occured ");
	        System.out.println(ex);
	        status=false;
	    }

			finally
			{
			
				return status;
				
			}
			
	}
		
		@Override
		public boolean isDiscountAvailable() 
		{
			// TODO Auto-generated method stub
			
			OrderDaoImpl orderDao = null;
			int countOfVid=0;
			boolean status = false;

					
					list.add(1);
					list.add(2);
					list.add(3);
					list.add(2);
					list.add(2);
					for(int i:list)
					{
						//countOfVid=Collections.frequency(list,i);
						 System.out.println("element: " + i
						            + ", count: " + Collections.frequency(list, i));
						countOfVid=Collections.frequency(list, i);
						if(countOfVid>=2)
						{
							status=true;
						}
					} 
					
			

			return status;
		}

		@Override
		public int getDiscount(int totalPrice) {
			// TODO Auto-generated method stub
			int netPrice;
			VendorService disc=new VendorService();
			boolean bool=disc.isDiscountAvailable();
			if(bool)
			{
				netPrice=(totalPrice*10)/100;
				return netPrice;
			}
			else
			{
				return totalPrice;
			}
			
			
		}

		
	
	
}
