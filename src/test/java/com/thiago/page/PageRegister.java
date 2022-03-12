package com.thiago.page;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageRegister extends CorePage<PageRegister>{

	public PageRegister() {
		this.driver = TLDriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);
	}
		@FindBy(name = "firstName")
	private WebElement inputFistName;

	@FindBy(name = "lastName")
	private WebElement inputLastName;

	@FindBy(name = "email")
	private WebElement inputEmail;

	@FindBy(name = "submit")
	private WebElement bntEnviar;

	@FindBy(name = "country")
	private WebElement selectCountry;

	public PageRegisterSucess preencherformulario() {
		aguardarElementoVisivel(inputFistName);
		preencherCampo(inputFistName, "Carlos");
		preencherCampo(inputLastName, "Silva");
		preencherCampo(inputEmail, "c.henrique.cunha08@gmail.com");
		selectElementByVisibleValue(selectCountry, "BRAZIL");
		click(bntEnviar);
		return new PageRegisterSucess();
	}

}
