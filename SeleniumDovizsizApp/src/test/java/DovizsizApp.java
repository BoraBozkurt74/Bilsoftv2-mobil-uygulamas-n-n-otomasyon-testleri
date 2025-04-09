import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.time.Duration;

public class DovizsizApp {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Robot robot = new Robot();

    public DovizsizApp() throws AWTException {
    }


    @BeforeEach
    void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mobil.bilsoft.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtVergiNo"))).sendKeys("********87");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtKullaniciAdi"))).sendKeys("***********74@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtSifre"))).sendKeys("****");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("#btnGiris")).click();
    }

    @Test
    void BilsoftLoginTest() throws InterruptedException {
        driver.get("https://mobil.bilsoft.com/");
        driver.findElement(By.id("txtVergiNo")).sendKeys("05336145387");
        driver.findElement(By.id("txtKullaniciAdi")).sendKeys("bozkurtbora74@gmail.com");
        driver.findElement(By.id("txtSifre")).sendKeys("1234");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(3000); // 3 saniye bekler
        driver.findElement(By.cssSelector("#btnGiris")).click();
    }
    @Test
    void CariHesapOlusturma(){
        driver.findElement(By.xpath("//div[@class='page-content topluSatis']//a[@href='cari_hesaplar.aspx']/div[@class='details cardStyle']")).click();
        driver.findElement(By.cssSelector(".red")).click();
        driver.findElement(By.xpath("//div[@class='col-md-4']/div[2]/input[@class='form-control']")).sendKeys("Raze");
        driver.findElement(By.xpath("//div[@class='col-md-4']/div[@class='col-md-6']/input[@class='form-control']")).sendKeys("Ezgi");
        driver.findElement(By.xpath("//a[@href=\"javascript:__doPostBack('ctl00$ContentPlaceHolderBody$btnKaydet','')\"]")).click();
        driver.findElement(By.cssSelector(".btn[href='cari_hesaplar.aspx']")).click();
    }
    @Test
    void YeniStokKartiOlusturma(){
        driver.findElement(By.xpath("//div[@class='page-content topluSatis']//a[@href='stok_kartlari.aspx']/div[@class='details cardStyle']")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.xpath("//div[@class='box-body']/input[1]")).sendKeys("001");
        driver.findElement(By.id("txtStokAdi")).sendKeys("Laptop");
        driver.findElement(By.xpath("//select[2]")).click();
        driver.findElement(By.xpath("//div[@class='box-body']/input[4]")).clear();
        driver.findElement(By.xpath("//div[@class='box-body']/input[4]")).sendKeys("12000");
        driver.findElement(By.xpath("//div[@class='box-body']/input[5]")).clear();
        driver.findElement(By.xpath("//div[@class='box-body']/input[5]")).sendKeys("20000");
        driver.findElement(By.xpath("//a[contains(.,'KAYDET')]")).click();
        driver.findElement(By.xpath("//a[.='Stok Kartı']")).click();
    }
    @Test
    void YeniStokGrubuOlusturma(){
        driver.findElement(By.xpath("//div[@class='page-content topluSatis']//a[@href='stok_kartlari.aspx']/div[@class='details cardStyle']")).click();
        driver.findElement(By.xpath("//a[.='Gruplar']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-lg green']")).click();
        driver.findElement(By.cssSelector("[placeholder='Grup adı giriniz...']")).sendKeys("Teknoloji");
        driver.findElement(By.cssSelector(".btn-success")).click();
        driver.findElement(By.xpath("//a[.='Stok Grupları']")).click();
    }
    @Test
    void StokMarkalari(){
        driver.findElement(By.xpath("//div[@class='page-content topluSatis']//a[@href='stok_kartlari.aspx']/div[@class='details cardStyle']")).click();
        driver.findElement(By.xpath("//a[.='Markalar']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-lg green']")).click();
        driver.findElement(By.cssSelector("[placeholder='Marka adı giriniz...']")).sendKeys("Asya");
        driver.findElement(By.cssSelector(".btn-success")).click();
        driver.findElement(By.xpath("//a[.='Stok Markaları']")).click();
    }
    @Test
    void AlısYap(){
        driver.findElement(By.xpath("//div[@class='page-content topluSatis']/div[3]/div[3]//div[@class='details cardStyle']")).click();
        driver.findElement(By.xpath("//tr[2]//a[contains(.,'Seç')]")).click();
        driver.findElement(By.cssSelector(".red")).click();
        driver.findElement(By.id("txtUrunAdi_Ekle")).sendKeys("Beypazarı");
        driver.findElement(By.xpath("//div[@class='btn btn-md green']")).click();
        driver.findElement(By.id("kaydet_start")).click();
    }
    @Test
    void SatisYap(){
        driver.findElement(By.xpath("//h4[contains(.,'(F4)')]")).click();
        driver.findElement(By.xpath("//tbody[@id='liste']/tr[1]//a[contains(.,'Seç')]")).click();
        driver.findElement(By.cssSelector(".red")).click();
        driver.findElement(By.id("txtUrunAdi_Ekle")).sendKeys("Ofçay");
        driver.findElement(By.xpath("//div[@class='btn btn-md green']")).click();
        driver.findElement(By.cssSelector(".fa-save")).click();
    }
    @Test
    void CekSenetTahsilati(){
        driver.findElement(By.xpath("//div[@class='page-content topluSatis']//a[@href='cek_liste.aspx']/div[@class='details cardStyle']")).click();
        driver.findElement(By.xpath("//a[.='Yeni Verilen ÇEK/SENET']")).click();
        driver.findElement(By.id("txtTutar")).clear();
        driver.findElement(By.id("txtTutar")).sendKeys("3000");
        driver.findElement(By.id("txtCekSenetNo")).sendKeys("0001");
        driver.findElement(By.xpath("//span[@class='input-group-addon']/i[@class='fa fa-search']")).click();
        driver.findElement(By.xpath("//tbody[@id='cariListesi']/tr[2]//div[@class='btn btn-default']")).click();
        driver.findElement(By.id("btnKaydet")).click();
    }
    @Test
    void BankaHesabiOlusturma(){
        driver.findElement(By.xpath("//div[@class='page-content topluSatis']//a[@href='banka_ozet.aspx']")).click();
        driver.findElement(By.xpath("//a[.='Yeni Banka Hesabı']")).click();
        driver.findElement(By.id("txtBankaAdi")).sendKeys("Ziraat Bankası");
        driver.findElement(By.id("txtsubeAdi")).sendKeys("Merkez");
        driver.findElement(By.id("btnKaydet")).click();
    }
    @Test
    void BankadanBankayaVirman(){
        driver.findElement(By.xpath("//div[@class='page-content topluSatis']//a[@href='banka_ozet.aspx']")).click();
        driver.findElement(By.xpath("//a[.='Bankadan Bankaya Virman']")).click();
        WebElement KaynakBanka = driver.findElement(By.cssSelector(".banka1")); // Odaklanılacak alan
        KaynakBanka.click();
        KaynakBanka.sendKeys(Keys.ARROW_UP);
        KaynakBanka.sendKeys(Keys.ARROW_UP);
        KaynakBanka.sendKeys(Keys.ENTER);
        WebElement HedefBanka = driver.findElement(By.id("drpBankalarHedef"));
        HedefBanka.click();
        HedefBanka.sendKeys(Keys.ARROW_UP);
        HedefBanka.sendKeys(Keys.ENTER);
        driver.findElement(By.id("txtTutar")).sendKeys("5000");
        driver.findElement(By.id("btnKaydet")).click();
        driver.findElement(By.xpath("//a[.='Bankaya Git']")).click();
    }
    @Test
    void YeniKasaOlusturma(){
        driver.findElement(By.xpath("//a[@href='/Kasalar/kasalar.aspx']/div[@class='details cardStyle']")).click();
        driver.findElement(By.cssSelector(".blue")).click();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        WebElement kasaAdInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("kasaAd")));
        kasaAdInput.sendKeys("Merkez");
        robot.keyPress(KeyEvent.VK_TAB);
        WebElement AcıklamaInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("kasaAciklama")));
        AcıklamaInput.sendKeys("Yeni");
        driver.findElement(By.cssSelector("[onclick='kasaEkle();']")).click();



    }
    @Test
    void KasayaParaGirisCikisi() throws AWTException {
        driver.findElement(By.xpath("//a[@href='/Kasalar/kasalar.aspx']/div[@class='details cardStyle']")).click();
        driver.findElement(By.cssSelector(".btn-circle")).click();
        driver.findElement(By.id("girisYap")).click();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        driver.findElement(By.id("girisTutar")).clear();
        driver.findElement(By.id("girisTutar")).sendKeys("200");
        driver.findElement(By.cssSelector("[onclick='girisEkle();']")).click();
    }
    @Test
    void FaturaOlusturma(){
        driver.findElement(By.cssSelector(".bg-yellow-gold > .details")).click();
        driver.findElement(By.xpath("//a[.='Yeni Alış Faturası']")).click();
        driver.findElement(By.xpath("//tbody[@id='liste']/tr[1]//a[contains(.,'Seç')]")).click();
        driver.findElement(By.cssSelector(".red")).click();
        driver.findElement(By.id("txtUrunAdi_Ekle")).sendKeys("İphone");
        driver.findElement(By.xpath("//div[@class='btn btn-md green']")).click();
        driver.findElement(By.id("kaydet_start")).click();
    }
    @Test
    void TaksitTakip(){
        driver.findElement(By.xpath("//a[contains(.,'Taksit Takip')]")).click();
        driver.findElement(By.xpath("//a[contains(.,'Yeni Taksit Oluştur')]")).click();
        driver.findElement(By.cssSelector(".input-group-addon")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cariListesi > tr:nth-of-type(2) .btn")));
        driver.findElement(By.id("txtToplamTutar")).clear();
        driver.findElement(By.id("txtToplamTutar")).sendKeys("8000");
        driver.findElement(By.xpath("//input[@class='form-control ']")).clear();
        driver.findElement(By.xpath("//input[@class='form-control ']")).sendKeys("2000");
        driver.findElement(By.id("btnKaydet")).click();

    }
}
