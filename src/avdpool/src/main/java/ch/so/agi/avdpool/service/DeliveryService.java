package ch.so.agi.avdpool.service;

import java.io.IOException;
import java.net.SocketException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

@Stateless
@LocalBean
public class DeliveryService {

	public DeliveryService() {
		System.out.println("Instance created for DeliveryService");
	}
	
	public void getItfList() throws IllegalArgumentException, SocketException, IOException {
		
		// get file list from ftp
		// join with gemeindenamen
		// create links?
		
		
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		String ftpUrl = ctx.getExternalContext().getInitParameter("ch.so.agi.avdpool.infogrips.FTP_URL");
		if (ftpUrl == null) {
			throw new IllegalArgumentException();
		}
		
		String ftpDir = ctx.getExternalContext().getInitParameter("ch.so.agi.avdpool.infogrips.FTP_DIR");
		if (ftpDir == null) {
			throw new IllegalArgumentException();
		}
		
		String ftpUsr = ctx.getExternalContext().getInitParameter("ch.so.agi.avdpool.infogrips.FTP_USR");
		if (ftpUsr == null) {
			throw new IllegalArgumentException();
		}
		
		String ftpPwd = ctx.getExternalContext().getInitParameter("ch.so.agi.avdpool.infogrips.FTP_PWD");
		if (ftpPwd == null) {
			throw new IllegalArgumentException();
		}
		
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect(ftpUrl, 21);
		ftpClient.login(ftpUsr, ftpPwd);
		
		 if (!ftpClient.setFileType(FTP.BINARY_FILE_TYPE)) {
             ftpClient.disconnect();                
             throw new IOException("Could not set binary file type."); 
         } 
		
		String[] files = ftpClient.listNames(ftpDir);
		
		
		
		System.out.println("dir:" + ftpClient.listNames(ftpDir).length);
		
		for (String file : files) {
//			String details = file.getName();
			System.out.println(file);
			
			
		}
//		    String details = file.getName();
//		    if (file.isDirectory()) {
//		        details = "[" + details + "]";
//		    }
//		    details += "\t\t" + file.getSize();
////		    details += "\t\t" + dateFormater.format(file.getTimestamp().getTime());
//		    System.out.println(details);
//		}
		 
		ftpClient.logout();
		ftpClient.disconnect();
		
		System.out.println("Get list from FTP");
		
		
	}
	
}

