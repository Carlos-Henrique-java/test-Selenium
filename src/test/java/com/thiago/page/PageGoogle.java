package com.thiago.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;
import org.testng.Assert;

public class PageGoogle extends CorePage<PageGoogle>{

	
	public PageGoogle() {
		this.driver = TLDriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(name = "q")
	private WebElement inputTextSearch;
	
	@FindBy(name = "btnK")
	private WebElement bntSearch;

	@FindBy(xpath = "//*[@id=\"oFNiHe\"]/p/a/b/i")
	private WebElement labelRecursividade;
	
	
	public PageGoogle buscarNoGoogle(String busca) {
		aguardarElementoVisivel(inputTextSearch);
		preencherCampo(inputTextSearch,busca);
		inputTextSearch.submit();
		return this;
	}
	public void validarTextoSearch(){
		aguardarElementoVisivel(labelRecursividade);
		Assert.assertEquals("recursividade",getTextElement(labelRecursividade));
	}
	
}
