package in.automationtesting.casos.caso2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@DisplayName("Teste automatizado para os 4 casos")
public class CasosTeste {
    @Test
    @DisplayName("Cenário 1")
    public void Caso1() throws InterruptedException {
        String extesionPath = System.getProperty("user.dir") + "/src/adblock-plus-crx-master/bin/Adblock-Plus_v1.12.4.crx";
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(extesionPath));
        //Abrir chrome
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver(options);
        //Trata o problema do carregamento da pagina, ele aguarda a pagina carregar
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Abrir site
        navegador.get("https://demo.automationtesting.in/Register.html");
        //Cadastro
        //Insere nome e sobrenome
        WebElement nome = navegador.findElement(By.cssSelector("input[ng-model=\"FirstName\"]"));
        nome.sendKeys("Rodrigo");
        WebElement sobrenome = navegador.findElement(By.cssSelector("input[ng-model=\"LastName\"]"));
        sobrenome.sendKeys("Eduardo");
        //Insere endereço
        WebElement adress = navegador.findElement(By.cssSelector("textarea[ng-model=\"Adress\"]"));
        adress.sendKeys("Rua Nilo Peçanha, 1950 - Lourival");
        //Insere Email
        WebElement email = navegador.findElement(By.cssSelector("input[ng-model=\"EmailAdress\"]"));
        email.sendKeys("rodrigoteste@gmail.com");
        //Insere Telefone
        WebElement phone = navegador.findElement(By.cssSelector("input[ng-model=\"Phone\"]"));
        phone.sendKeys("86995567345");
        //Seleciona sexo
        WebElement sexo = navegador.findElement(By.cssSelector("input[value=\"Male\"]"));
        sexo.click();
        //Seleciona hobbies
        List<WebElement> checkboxes = navegador.findElements(By.cssSelector("input[type=\"checkbox\"]"));
        for(WebElement checkbox : checkboxes){
            if(!checkbox.isSelected()){
                checkbox.click();
            }
        }
        Thread.sleep(5000);
        //Seleciona linguagens;
        try{
            WebElement click_idi = navegador.findElement(By.cssSelector("#basicBootstrapForm > div:nth-child(7) > div > multi-select"));
            click_idi.click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        WebElement select_idi = navegador.findElement(By.cssSelector("#basicBootstrapForm > div:nth-child(7) > div > multi-select > div:nth-child(2) > ul > li:nth-child(1)"));
        select_idi.click();
        //Seleciona skills
        WebElement ele_skill = navegador.findElement(By.cssSelector("select[id=\"Skills\"]"));
        Select elem_skill = new Select(ele_skill);
        elem_skill.selectByValue("AutoCAD");
        //Seleciona Select Country
        WebElement ele_country = navegador.findElement(By.cssSelector("select[id=\"country\"]"));
        Select elem_country = new Select(ele_country);
        elem_country.selectByValue("Australia");
        //Seleciona ano
        WebElement ele_year = navegador.findElement(By.cssSelector("select[id=\"yearbox\"]"));
        Select year = new Select(ele_year);
        year.selectByValue("2000");
        //Seleciona mes
        WebElement ele_month = navegador.findElement(By.cssSelector("select[ng-model=\"monthbox\"]"));
        Select month = new Select(ele_month);
        month.selectByValue("September");
        //Seleciona data
        WebElement ele_date = navegador.findElement(By.cssSelector("select[id=\"daybox\""));
        Select date = new Select(ele_date);
        date.selectByValue("14");
        //Insere senha
        String password = "12345678";
        WebElement passwod = navegador.findElement(By.cssSelector("input[id=\"firstpassword\"]"));
        passwod.sendKeys(password);
        //Confirm senha
        WebElement conf_password = navegador.findElement(By.cssSelector("input[id=\"secondpassword\"]"));
        conf_password.sendKeys(password);

        navegador.quit();



    }
    @Test
    @DisplayName("Cenário2")
    public void Caso2() throws InterruptedException {
        String extesionPath = System.getProperty("user.dir") + "/src/adblock-plus-crx-master/bin/Adblock-Plus_v1.12.4.crx";
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(extesionPath));
        //Abrir chrome
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver(options);
        //Trata o problema do carregamento da pagina, ele aguarda a pagina carregar
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        //Abrir site
        navegador.get("https://demo.automationtesting.in/Register.html");

        //Percorrer
        //Click SwitchTo
        navegador.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/a")).click();
        //Click Frames
        navegador.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/ul/li[3]/a")).click();
        //Click primeiro Iframe demo
        WebElement frame = navegador.findElement(By.xpath("//*[@id='Single']/iframe"));
        navegador.switchTo().frame(frame);
        WebElement textbox = navegador.findElement(By.xpath("/html/body/section/div/div/div/input"));
        textbox.sendKeys("Teste Selenium");
        Thread.sleep(4000);
        navegador.switchTo().defaultContent();

        //Click segundo Iframe demo
        WebElement secondTab = navegador.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a"));
        secondTab.click();

        Thread.sleep(3000);

        navegador.quit();

    }

    @Test
    @DisplayName("Cenario 3")
    public void Caso3() throws Exception {
        String extesionPath = System.getProperty("user.dir") + "/src/adblock-plus-crx-master/bin/Adblock-Plus_v1.12.4.crx";
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(extesionPath));
        //Abrir chrome
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver(options);
        //Trata o problema do carregamento da pagina, ele aguarda a pagina carregar
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Abrir site
        navegador.get("https://demo.automationtesting.in/Register.html");
        //Seleciona Widgets
        WebElement widgets = navegador.findElement(By.cssSelector("a[href=\"Widgets.html\"]"));
        widgets.click();
        Thread.sleep(2000);
        //Seleciona Datepicker
        WebElement datapicker = navegador.findElement(By.cssSelector("a[href=\"Datepicker.html\"]"));
        datapicker.click();
        //Insere primeiro datepicker
        String year = "2000";
        String month = "September";
        String day = "14";


        WebElement input_date1 = navegador.findElement(By.cssSelector("input[id=\"datepicker1\"]"));
        input_date1.click();

        String cmonth = navegador.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText().trim();
        String cyear = navegador.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText().trim();
        WebElement previou;
        while((!cmonth.equals(month)) || (!cyear.equals(year))){
            previou = navegador.findElement(By.xpath("//span[text()=\"Prev\"]"));
            previou.click();
            cmonth = navegador.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText().trim();
            cyear = navegador.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText().trim();
        }
        List<WebElement> dates = navegador.findElements(By.xpath("//a[@class=\"ui-state-default\"]"));
        for(WebElement e: dates){
            if(e.getText().trim().equals(day)){
                e.click();
                break;
            }
        }
        Thread.sleep(2000);
        //Insere segundo datapicker
        WebElement input_date2 = navegador.findElement(By.cssSelector("input[id=\"datepicker2\"]"));
        input_date2.click();
        Thread.sleep(2000);
        WebElement in_year_1 = navegador.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/select[2]"));
        Select yr_1 = new Select(in_year_1);
        yr_1.selectByValue("3/2003");

        WebElement in_month = navegador.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/select[1]"));
        Select mt = new Select(in_month);
        mt.selectByValue("9/2003");

        WebElement in_year_2 = navegador.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/select[2]"));
        Select yr_2 = new Select(in_year_2);
        yr_2.selectByValue("9/2000");

        Thread.sleep(2000);

        WebElement in_day = navegador.findElement(By.cssSelector("a[title=\"Select Thursday, Sep 14, 2000\"]"));
        in_day.click();

        Thread.sleep(3000);

        navegador.quit();
    }
    @Test
    @DisplayName("Cenario 4")
    public void Caso4() throws InterruptedException {
        String extesionPath = System.getProperty("user.dir") + "/src/adblock-plus-crx-master/bin/Adblock-Plus_v1.12.4.crx";
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(extesionPath));
        //Abrir chrome
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver(options);
        //Trata o problema do carregamento da pagina, ele aguarda a pagina carregar
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Abrir site
        navegador.get("https://demo.automationtesting.in/Register.html");
        //Seleciona Widgets
        WebElement widgets = navegador.findElement(By.cssSelector("a[href=\"Widgets.html\"]"));
        widgets.click();
        Thread.sleep(2000);
        //Seleciona Slider
        WebElement button_slider = navegador.findElement(By.cssSelector("a[href=\"Slider.html\"]"));
        button_slider.click();

        WebElement slider = navegador.findElement(By.cssSelector("a[class*=\"ui-slider-handle\"]"));
        Actions actions = new Actions(navegador);
        actions.dragAndDropBy(slider,337,100).release().build().perform();
        slider.click();

    }



}
