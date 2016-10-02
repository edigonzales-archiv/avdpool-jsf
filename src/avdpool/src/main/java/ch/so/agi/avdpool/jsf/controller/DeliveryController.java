package ch.so.agi.avdpool.jsf.controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.SocketException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ch.so.agi.avdpool.service.DeliveryService;


@ManagedBean(name = "delivery")
@RequestScoped
public class DeliveryController implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB 
	private DeliveryService deliveryService;

	
	public String dummyTest() throws IllegalArgumentException, SocketException, IOException {
		
		deliveryService.getItfList();
				
		return "success";
	}
}
