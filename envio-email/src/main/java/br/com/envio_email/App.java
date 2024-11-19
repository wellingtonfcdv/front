package br.com.envio_email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;


public class App 
{
	
	private String userName = "wellinfcdev@gmail.com";
	private String senha = "rboumcojbtrnwkhq";
	//private String senha = "tagimazero0!";
	@Test
    public void testeEmail() {
    	/*
    	 * wellinfcdev@gmail.com
    	 * 
    	 * 
    	 * */
		
		// Configurações do proxy SOCKS
		System.setProperty("http.proxyHost", "http://do-user:1234@10.26.0.159");
		System.setProperty("http.proxyPort", "8080");
		System.setProperty("https.proxyHost", "https://do-user:1234@10.26.0.159");
		System.setProperty("https.proxyPort", "8080");

        
		try {
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");/*Autorização*/
			properties.put("mail.smtp.starttls", "true");/*Autenticação*/
			properties.put("mail.smtp.host", "smtp.gmail.com");/*Servidor gmail Google*/
			properties.put("mail.smtp.port", "465");/*Porta do servidor*/
			properties.put("mail.smtp.socketFactory.port", "465");/*Especifica a porta a ser conectada pelo socket*/
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");/*Classe socket de conexão ao smtp*/
			
			Session session = Session.getInstance(properties, new Authenticator(){
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, senha);
				}
					
		
				});
			System.out.print(session);
			
			Address[] toUser = InternetAddress.parse("wellingtonfc@hotmail.com, wellinfcdev@gmail.com");
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName));/*Quem está enviando*/
			message.setRecipients(Message.RecipientType.TO, toUser); /*Email de destino*/
			message.setSubject("Chegou e-mail enviado com Java.");
			message.setText("Olá programador, vc acaba de receber um e-mail enviado com Java do curso formação java web.");
			
			Transport.send(message);
			
			System.out.println("E-mail enviado com sucesso");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
    }
}
