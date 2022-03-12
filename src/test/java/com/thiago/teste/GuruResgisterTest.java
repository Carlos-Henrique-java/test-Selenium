package com.thiago.teste;

import com.thiago.core.InvokedMethodListener;
import com.thiago.page.PageGoogle;
import com.thiago.page.PageRegister;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(InvokedMethodListener.class)
public class GuruResgisterTest {

    @Test
    public void validarRegistroDeConta(){
    new PageRegister().openPage(PageRegister.class,"https://demo.guru99.com/test/newtours/register.php")
            .preencherformulario()
            .validarRegister();






    }
}