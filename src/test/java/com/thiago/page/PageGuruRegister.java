package com.thiago.page;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageGuruRegister extends CorePage<PageGuruRegister>{

	public PageGuruRegister() {
		this.driver = TLDriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);
	}
	@FindBy(name = "country")
	private WebElement selectCountry;
	
	@FindBy(name = "firstName")
	private WebElement inputFirstName;

	@FindBy(name = "email")
	private WebElement inputEmail;
	
	@FindBy(name = "submit")
	private WebElement bntEnviar;
	
	
	
	public void selectCountry(String country){
		selectElementByVisibleValue(this.selectCountry,country);
	}

	public void preencherNome(String nome){
		preencherCampo(inputFirstName,nome);
	}

	public PageGuruRegisterSucess registraPessoa(String country, String nome, String login){
		aguardarElementoVisivel(bntEnviar);
		preencherCampo(inputEmail, login);
		selectCountry(country);
		preencherNome(nome);
		click(bntEnviar);
		return new PageGuruRegisterSucess();
	}
}
