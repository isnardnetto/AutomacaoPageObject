package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CriarMovimentacao extends BasePage {


    public CriarMovimentacao(WebDriver navegar) {
        super(navegar);
    }

    public CriarMovimentacao dataDePagamento(String data){
        navegar.findElement(By.id("data_pagamento")).sendKeys(data);

        return this;
    }
    public CriarMovimentacao descricao(String descricao){
        navegar.findElement(By.id("descricao")).sendKeys(descricao);

        return this;
    }

    public CriarMovimentacao interessado(String interessado){
        navegar.findElement(By.id("interessado")).sendKeys(interessado);

        return this;
    }

    public CriarMovimentacao valor(String valor){
        navegar.findElement(By.id("valor")).sendKeys(valor);

        return this;
    }

    public CriarMovimentacao conta(String conta){
        navegar.findElement(By.id("conta")).sendKeys(conta);

        return this;
    }

    public CriarMovimentacao situacao(){
        navegar.findElement(By.id("status_pago")).click();

        return this;
    }

    public CriarMovimentacao dataDeMovimentacao(String dataMov){
        navegar.findElement(By.id("data_transacao")).sendKeys(dataMov);

        return this;
    }

    public CriarMovimentacao clicarNoBotaoSalvar(){
        navegar.findElement(By.className("btn-primary")).click();

        return this;
    }

    public CriarMovimentacao limparTelaDeDataDePagamento(){
        navegar.findElement(By.id("data_pagamento")).clear();

        return this;
    }

    public CriarMovimentacao preeencherCamposSemDataMovimentacao(String data,String descricao , String interessado ,String valor ,String conta){
        navegar.findElement(By.id("data_pagamento")).sendKeys(data);
        navegar.findElement(By.id("descricao")).sendKeys(descricao);
        navegar.findElement(By.id("interessado")).sendKeys(interessado);
        navegar.findElement(By.id("valor")).sendKeys(valor);
        navegar.findElement(By.id("conta")).sendKeys(conta);
        navegar.findElement(By.id("status_pago")).click();
        navegar.findElement(By.className("btn-primary")).click();


        return this;
    }

    public CriarMovimentacao preeencherCamposSemDataPagamanto(String dataMov,String descricao , String interessado ,String valor ,String conta){
        navegar.findElement(By.id("data_transacao")).sendKeys(dataMov);
        navegar.findElement(By.id("descricao")).sendKeys(descricao);
        navegar.findElement(By.id("interessado")).sendKeys(interessado);
        navegar.findElement(By.id("valor")).sendKeys(valor);
        navegar.findElement(By.id("conta")).sendKeys(conta);
        navegar.findElement(By.id("status_pago")).click();
        navegar.findElement(By.className("btn-primary")).click();


        return this;
    }

    public CriarMovimentacao todosOsCamposPreenchidosDataInvalida(String dataTran,String descricao , String interessado ,String valor ,String conta,String data){
        navegar.findElement(By.id("data_transacao")).sendKeys(dataTran); //futuro
        navegar.findElement(By.id("descricao")).sendKeys(descricao);
        navegar.findElement(By.id("interessado")).sendKeys(interessado);
        navegar.findElement(By.id("valor")).sendKeys(valor);
        navegar.findElement(By.id("conta")).sendKeys(conta);
        navegar.findElement(By.id("status_pago")).click();
        navegar.findElement(By.id("data_pagamento")).sendKeys(data);
        navegar.findElement(By.className("btn-primary")).click();


        return this;
    }


}
