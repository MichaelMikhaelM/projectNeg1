import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver","/home/rog/chromedriver");

        Javalin app =  Javalin.create(config ->
                {
                    config.addStaticFiles("/", Location.CLASSPATH);
                }
        ).start(9000);

        System.setProperty("webdriver.chrome.driver","/home/rog/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:9000");

        final String[] num1 = new String[1];
        final String[] num2 = new String[1];
        final String[] num3 = new String[1];
        final String[] num4 = new String[1];
        final String[] num5 = new String[1];
        final String[] num6 = new String[1];
        final String[] num7 = new String[1];
        final String[] num8 = new String[1];

        //Thread.sleep(5000);
        app.get("/", ctx ->
                {
                    num1[0] = ctx.queryParam("num11");
                    num2[0] = ctx.queryParam("num22");
                    num3[0] = ctx.queryParam("num33");
                    num4[0] = ctx.queryParam("num44");
                    num5[0] = ctx.queryParam("num55");
                    num6[0] = ctx.queryParam("num66");
                    num7[0] = ctx.queryParam("num77");
                    num8[0] = ctx.queryParam("num88");

                    ctx.result("done");
                }

                );


        Thread.sleep(25000);
        WebElement wb1 = driver.findElement(By.id("num1_add"));
        WebElement wb2 = driver.findElement(By.id("num2_add"));

        WebElement wb3 = driver.findElement(By.id("num1_sub"));
        WebElement wb4 = driver.findElement(By.id("num2_sub"));

        WebElement wb5 = driver.findElement(By.id("num1_mul"));
        WebElement wb6 = driver.findElement(By.id("num2_mul"));

        WebElement wb7 = driver.findElement(By.id("num1_div"));
        WebElement wb8 = driver.findElement(By.id("num2_div"));



        wb1.sendKeys(num1[0]);
        wb2.sendKeys(num2[0]);
        wb3.sendKeys(num3[0]);
        wb4.sendKeys(num4[0]);
        wb5.sendKeys(num5[0]);
        wb6.sendKeys(num6[0]);
        wb7.sendKeys(num7[0]);
        wb8.sendKeys(num8[0]);


        app.get("/add", ctx ->
                {
                    String n1a = ctx.queryParam("num1_add");
                    String n2a = ctx.queryParam("num2_add");

                    ctx.result(String.valueOf(Integer.parseInt(n1a)+Integer.parseInt(n2a)));
                }
        );

        app.get("/sub", ctx ->
                {
                    String n1a = ctx.queryParam("num1_sub");
                    String n2a = ctx.queryParam("num2_sub");

                    ctx.result(String.valueOf(Integer.parseInt(n1a)-Integer.parseInt(n2a)));
                }
        );

        app.get("/mult", ctx ->
                {
                    String n1a = ctx.queryParam("num1_mul");
                    String n2a = ctx.queryParam("num2_mul");

                    ctx.result(String.valueOf(Integer.parseInt(n1a)*Integer.parseInt(n2a)));
                }
        );

        app.get("/div", ctx ->
                {
                    String n1a = ctx.queryParam("num1_div");
                    String n2a = ctx.queryParam("num2_div");

                    ctx.result(String.valueOf(Float.parseFloat(n1a)/Float.parseFloat(n2a)));
                }
        );


        WebElement btn1 = driver.findElement(By.id("btn-add"));
        WebElement btn2 = driver.findElement(By.id("btn-sub"));
        WebElement btn3 = driver.findElement(By.id("btn-mul"));
        WebElement btn4 = driver.findElement(By.id("btn-div"));

        Thread.sleep(2000);
        btn1.click();
        Thread.sleep(1000);
        btn2.click();
        Thread.sleep(1000);
        btn3.click();
        Thread.sleep(1000);
        btn4.click();




    }

}
