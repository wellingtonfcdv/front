package br.com.envio_email;

import java.util.Properties;

import org.junit.Test;


public class App 
{
	@Test
    public void testeEmail() {
    	/*
    	 * wellinfeijo.com.br@gmail.com
    	 * 
    	 * 
    	 * */
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");/*Autorização*/
		properties.put("mail.smtp.starttis", "true");/*Autenticação*/
		properties.put("mail.smtp.host", "smtp.gmail.com");/*Servidor gmail Google*/
		properties.put("mail.smtp.host", "465");/*Porta do servidor*/
		properties.put("mail.smtp.socketFactory.port", "465");/*Especifica a porta a ser conectada pelo socket*/
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");/*Classe socket de conexão ao smtp*/
    }
}
