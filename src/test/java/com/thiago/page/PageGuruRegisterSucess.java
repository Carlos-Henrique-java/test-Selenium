package com.thiago.page;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PageGuruRegisterSucess extends CorePage<PageGuruRegisterSucess>{

	public PageGuruRegisterSucess() {
		this.driver = TLDriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);
	}
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/font/b")
	private WebElement labelLoginSucesso;
	

	public void validarRegistroPessoa(String textoValidador){
		aguardarElementoVisivel(labelLoginSucesso);
		Assert.assertEquals(textoValidador,getTextElement(labelLoginSucesso));
	}
}
