package com.uniovi.tests;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.uniovi.tests.pageobjects.PO_HomeView;
import com.uniovi.tests.pageobjects.PO_LoginView;
import com.uniovi.tests.pageobjects.PO_PrivateView;
import com.uniovi.tests.pageobjects.PO_Properties;
import com.uniovi.tests.pageobjects.PO_RegisterView;
import com.uniovi.tests.pageobjects.PO_View;
import com.uniovi.tests.util.SeleniumUtils;

public class NotaneitorComplementariosTest extends NotaneitorTests{

	@Test
	public void prueba1() {
		//Vamos al formulario de logueo.
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		//Rellenamos el formulario
		PO_LoginView.fillForm(driver, "99999988F" , "123456" );
		//COmprobamos que entramos en la pagina privada del Profesor
		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id, 'professor-menu')]/a");
		elementos.get(0).click();
		PO_HomeView.clickOption(driver, "/professor/add", "class", "btn btn-primary");
		PO_RegisterView.fillFormProfessor(driver, "22222222R", "Mario", "González", "Lengua");
		PO_View.checkElement(driver, "text", "Mario");
	}
	
	@Test
	public void prueba2() {
		//Vamos al formulario de logueo.
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		//Rellenamos el formulario
		PO_LoginView.fillForm(driver, "99999988F" , "123456" );
		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id, 'professor-menu')]/a");
		elementos.get(0).click();
		PO_HomeView.clickOption(driver, "/professor/add", "class", "btn btn-primary");
		PO_RegisterView.fillFormProfessor(driver, "A", "Mario", "González", "Lengua");
		PO_View.checkKey(driver, "Error.signup.dni.length", PO_Properties.getSPANISH());
	}
	
	@Test
	public void prueba3() {
		//Vamos al formulario de logueo.
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		//Rellenamos el formulario
		PO_LoginView.fillForm(driver, "99999990A" , "123456" );
		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id, 'professor-menu')]/a");
		elementos.get(0).click();
		SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "Agregar profesor", PO_View.getTimeout());
		PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		//Rellenamos el formulario
		PO_LoginView.fillForm(driver, "99999977E" , "123456" );
		List<WebElement> elementos2 = PO_View.checkElement(driver, "free", "//li[contains(@id, 'professor-menu')]/a");
		elementos2.get(0).click();
		SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "Agregar profesor", PO_View.getTimeout());
		
	}
}
