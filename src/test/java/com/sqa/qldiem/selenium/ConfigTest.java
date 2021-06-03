/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.selenium;

import com.sqa.qldiem.dao.impl.SubjectDAO;
import com.sqa.qldiem.model.SubjectModel;
import com.sqa.qldiem.utils.BackupDatabase;
import java.io.IOException;
import java.util.List;
import javax.validation.constraints.AssertFalse;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/**
 *
 * @author Administrator
 */
public class ConfigTest {
    WebDriver driver;
    List<WebElement> rows;
    
    @Before
    public void loadDriver() {
        System.setProperty("webdriver.edge.driver", "D:\\Lib\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
    }
    
    @AfterClass
    public static void backupDatabase() throws IOException {
        BackupDatabase.restore();
    }
    
    public void commomMethod() throws InterruptedException {
        driver.get("http://localhost:8080/qldiem/trang-chu");

        String title = driver.getTitle();
        assertEquals("Trang chủ", title);
        
        Thread.sleep(1000);

        WebElement btnFormLogin = driver.findElement(By.id("btn-login"));
        btnFormLogin.click();
        
        title = driver.getTitle();
        assertEquals("Đăng nhập", title);
        
        Thread.sleep(1000);
        
        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");
        
        Thread.sleep(1000);
        
        WebElement btnLogin = driver.findElement(By.id("btn-login"));
        btnLogin.click();
        
        Thread.sleep(1000);

        WebElement button = driver.findElement(By.id("cauhinh"));
        button.click();
        
        title = driver.getTitle();
        assertEquals("Cấu hình môn học", title);
        
        Thread.sleep(1000);
    }
    
    public void commonMethod_2() throws InterruptedException {
        commomMethod();
        WebElement input = driver.findElement(By.id("myInput"));
        input.sendKeys("Java");
        
        rows = driver.findElements(By.xpath("//table//tr[@class='body' and not(contains(@style,'display: none;'))]"));   
        
        for(WebElement row : rows) {
            WebElement name = row.findElement(By.className("td_name"));
            assertTrue(name.getAttribute("innerHTML").trim().contains("Java"));
        }
        
        Thread.sleep(1000);
    }
    
    @Test
    public void testLoginRequired_NotLogin() throws Exception {
        driver.get("http://localhost:8080/qldiem/trang-chu");

        String title = driver.getTitle();
        assertEquals("Trang chủ", title);
        
        Thread.sleep(1000);

        WebElement button = driver.findElement(By.id("cauhinh"));
        button.click();
        
        title = driver.getTitle();
        assertEquals("Đăng nhập", title);
        
        WebElement msg = driver.findElement(By.id("message")); 
        assertEquals("Cần đăng nhập", msg.getAttribute("innerHTML").trim());
        
        Thread.sleep(1000);
        driver.quit();
    }
    
    @Test
    public void testLoginRequired_StudentLogin() throws Exception {
        driver.get("http://localhost:8080/qldiem/trang-chu");

        String title = driver.getTitle();
        assertEquals("Trang chủ", title);
        
        Thread.sleep(1000);

        WebElement btnFormLogin = driver.findElement(By.id("btn-login"));
        btnFormLogin.click();
        
        title = driver.getTitle();
        assertEquals("Đăng nhập", title);
        
        Thread.sleep(1000);
        
        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys("sv1");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");
        
        Thread.sleep(1000);
        
        WebElement btnLogin = driver.findElement(By.id("btn-login"));
        btnLogin.click();
        
        Thread.sleep(1000);

        WebElement button = driver.findElement(By.id("cauhinh"));
        button.click();
        
        title = driver.getTitle();
        assertEquals("Đăng nhập", title);
        
        WebElement msg = driver.findElement(By.id("message")); 
        assertEquals("Không có quyền truy cập", msg.getAttribute("innerHTML").trim());
        
        Thread.sleep(1000);
        driver.quit();
    }
    
    @Test
    public void testLoginRequired_LecturerLogin() throws Exception {
        driver.get("http://localhost:8080/qldiem/trang-chu");

        String title = driver.getTitle();
        assertEquals("Trang chủ", title);
        
        Thread.sleep(1000);

        WebElement btnFormLogin = driver.findElement(By.id("btn-login"));
        btnFormLogin.click();
        
        title = driver.getTitle();
        assertEquals("Đăng nhập", title);
        
        Thread.sleep(1000);
        
        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys("gv3");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");
        
        Thread.sleep(1000);
        
        WebElement btnLogin = driver.findElement(By.id("btn-login"));
        btnLogin.click();
        
        Thread.sleep(1000);

        WebElement button = driver.findElement(By.id("cauhinh"));
        button.click();
        
        title = driver.getTitle();
        assertEquals("Đăng nhập", title);
        
        WebElement msg = driver.findElement(By.id("message")); 
        assertEquals("Không có quyền truy cập", msg.getAttribute("innerHTML").trim());
        
        Thread.sleep(1000);
        driver.quit();
    }
    
    @Test
    public void testLoginRequired_EmployeeLogin() throws Exception {
        driver.get("http://localhost:8080/qldiem/trang-chu");

        String title = driver.getTitle();
        assertEquals("Trang chủ", title);
        
        Thread.sleep(1000);

        WebElement btnFormLogin = driver.findElement(By.id("btn-login"));
        btnFormLogin.click();
        
        title = driver.getTitle();
        assertEquals("Đăng nhập", title);
        
        Thread.sleep(1000);
        
        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");
        
        Thread.sleep(1000);
        
        WebElement btnLogin = driver.findElement(By.id("btn-login"));
        btnLogin.click();
        
        Thread.sleep(1000);

        WebElement button = driver.findElement(By.id("cauhinh"));
        button.click();
        
        title = driver.getTitle();
        assertEquals("Cấu hình môn học", title);
        
        Thread.sleep(1000);
        driver.quit();
    }
    
    @Test
    public void testSearch_CH_30() throws Exception {
        commomMethod();
        
        WebElement input = driver.findElement(By.id("myInput"));
        input.sendKeys("Java");
        
        List<WebElement> rows = driver.findElements(By.cssSelector(
                "[class='myTable'] [class='body'] [class='td_name']"));
        for(WebElement row : rows) {
            assertTrue(row.getAttribute("innerHTML").trim().contains("Java"));
        }
        
        Thread.sleep(1000);
        driver.quit();
    }
    
    @Test
    public void testSearch_CH_31() throws Exception {
        commomMethod();
        
        WebElement input = driver.findElement(By.id("myInput"));
        input.sendKeys("SQA");
        
        List<WebElement> rows = driver.findElements(By.cssSelector(
                "[class='myTable'] [class='body'] [class='td_name']"));
        for(WebElement row : rows) {
            assertTrue(row.getAttribute("innerHTML").trim().contains("SQA"));
        }
        
        Thread.sleep(1000);
        driver.quit();
    }
    
    @Test
    public void testSearch_CH_32() throws Exception {
        commomMethod();
        
        WebElement input = driver.findElement(By.id("myInput"));
        input.sendKeys("jAvA");
        
        List<WebElement> rows = driver.findElements(By.cssSelector(
                "[class='myTable'] [class='body'] [class='td_name']"));
        for(WebElement row : rows) {
            assertTrue(row.getAttribute("innerHTML").trim().contains("jAvA"));
        }
        
        Thread.sleep(1000);
        driver.quit();
    }
    
    @Test
    public void testSearch_CH_33() throws Exception {
        commomMethod();
        
        WebElement input = driver.findElement(By.id("myInput"));
        input.sendKeys("ja");
        
        List<WebElement> rows = driver.findElements(By.cssSelector(
                "[class='myTable'] [class='body'] [class='td_name']"));
        for(WebElement row : rows) {
            assertTrue(row.getAttribute("innerHTML").trim().contains("ja"));
        }
        
        Thread.sleep(1000);
        driver.quit();
    }
    
    @Test
    public void testSearch_CH_34() throws Exception {
        commomMethod();
        
        WebElement input = driver.findElement(By.id("myInput"));
        input.sendKeys("Java ");
        
        List<WebElement> rows = driver.findElements(By.cssSelector(
                "[class='myTable'] [class='body'] [class='td_name']"));
        assertTrue(!rows.isEmpty());
        for(WebElement row : rows) {
            assertTrue(row.getAttribute("innerHTML").trim().contains("Java "));
        }
        
        Thread.sleep(1000);
        driver.quit();
    }
    
    @Test
    public void testSearch_CH_35() throws Exception {
        commomMethod();
        
        WebElement input = driver.findElement(By.id("myInput"));
        input.sendKeys(" ");
        
        List<WebElement> rows = driver.findElements(By.cssSelector(
                "[class='myTable'] [class='body'] [class='td_name']"));
        assertTrue(!rows.isEmpty());
        for(WebElement row : rows) {
            assertTrue(row.getAttribute("innerHTML").trim().contains(" "));
        }
        
        Thread.sleep(1000);
        driver.quit();
    }
    
    @Test
    public void testUpdate_CH_36() throws Exception {
        commonMethod_2();
        
        WebElement btnUpdate = rows.get(0).findElement(By.className("td_btn_edit"));
        btnUpdate.click();
        
        WebElement quantity = driver.findElement(By.id("frm_quantity"));
        quantity.clear();
        quantity.sendKeys("0");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        quantity.equals(driver.switchTo().activeElement());
        
        Thread.sleep(1000);
        
        driver.quit();
    }
    
    @Test
    public void testUpdate_CH_37() throws Exception {
        commonMethod_2();
        
        WebElement btnUpdate = rows.get(0).findElement(By.className("td_btn_edit"));
        btnUpdate.click();
        
        WebElement quantity = driver.findElement(By.id("frm_quantity"));
        quantity.clear();
        quantity.sendKeys("1.1");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        quantity.equals(driver.switchTo().activeElement());
        
        Thread.sleep(1000);
        
        driver.quit();
    }
    
    @Test
    public void testUpdate_CH_38() throws Exception {
        commonMethod_2();
        
        WebElement btnUpdate = rows.get(0).findElement(By.className("td_btn_edit"));
        btnUpdate.click();
        
        WebElement point = driver.findElement(By.id("frm_point1"));
        point.clear();
        point.sendKeys("-1");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        point.equals(driver.switchTo().activeElement());
        
        Thread.sleep(1000);
        
        driver.quit();
    }
    
    @Test
    public void testUpdate_CH_39() throws Exception {
        commonMethod_2();
        
        WebElement btnUpdate = rows.get(0).findElement(By.className("td_btn_edit"));
        btnUpdate.click();
        
        WebElement point = driver.findElement(By.id("frm_point1"));
        point.clear();
        point.sendKeys("0.1");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        point.equals(driver.switchTo().activeElement());
        
        Thread.sleep(1000);
        
        driver.quit();
    }
    
    @Test
    public void testUpdate_CH_40() throws Exception {
        commonMethod_2();
        
        WebElement btnUpdate = rows.get(0).findElement(By.className("td_btn_edit"));
        btnUpdate.click();
        
        WebElement point = driver.findElement(By.id("frm_point1"));
        point.clear();
        point.sendKeys("101");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        point.equals(driver.switchTo().activeElement());
        
        Thread.sleep(1000);
        
        driver.quit();
    }
    
    @Test
    public void testUpdate_CH_41() throws Exception {
        commonMethod_2();
        
        WebElement btnUpdate = rows.get(0).findElement(By.className("td_btn_edit"));
        btnUpdate.click();
        
        WebElement point = driver.findElement(By.id("frm_point1"));
        point.clear();
        point.sendKeys("0.0");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        Alert alert = driver.switchTo().alert();
        assertEquals("Lỗi: Tổng % 4 đầu điểm phải bằng 100%!", alert.getText());
        
        Thread.sleep(1000);
        
        alert.accept();
        
        assertEquals("0", point.getAttribute("value"));
        
        Thread.sleep(1000);
        
        driver.quit();
    }
    
    @Test
    public void testUpdate_CH_42() throws Exception {
        commonMethod_2();
        
        WebElement btnUpdate = rows.get(0).findElement(By.className("td_btn_edit"));
        btnUpdate.click();
        
        WebElement quantity = driver.findElement(By.id("frm_quantity"));
        quantity.clear();
        quantity.sendKeys("1");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        Thread.sleep(1000);  
        
        WebElement alert = driver.findElement(By.className("alert-success"));
        assertEquals("Sửa thành công", alert.getAttribute("innerHTML"));
        
        Thread.sleep(1000);
        
        driver.quit();
        
        SubjectModel eo = new SubjectModel("Java", 1, 10, 10, 20, 60);
        SubjectModel sj = new SubjectDAO().findSubjectByName("Java");
        assertEquals(eo, sj);
    }
    
    @Test
    public void testUpdate_CH_43() throws Exception {
        commonMethod_2();
        
        WebElement btnUpdate = rows.get(0).findElement(By.className("td_btn_edit"));
        btnUpdate.click();
        
        WebElement quantity = driver.findElement(By.id("frm_quantity"));
        quantity.clear();
        quantity.sendKeys("1.0");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        Thread.sleep(1000);  
        
        WebElement alert = driver.findElement(By.className("alert-success"));
        assertEquals("Sửa thành công", alert.getAttribute("innerHTML"));
        
        Thread.sleep(1000);
        
        driver.quit();
        
        SubjectModel eo = new SubjectModel("Java", 1, 10, 10, 20, 60);
        SubjectModel sj = new SubjectDAO().findSubjectByName("Java");
        assertEquals(eo, sj);
    }
    
    @Test
    public void testUpdate_CH_44() throws Exception {
        commonMethod_2();
        
        WebElement btnUpdate = rows.get(0).findElement(By.className("td_btn_edit"));
        btnUpdate.click();
        
        WebElement point1 = driver.findElement(By.id("frm_point1"));
        point1.clear();
        point1.sendKeys("0.0");
        
        WebElement point2 = driver.findElement(By.id("frm_point2"));
        point2.clear();
        point2.sendKeys("20");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        Thread.sleep(1000);  
        
        WebElement alert = driver.findElement(By.className("alert-success"));
        assertEquals("Sửa thành công", alert.getAttribute("innerHTML"));
        
        Thread.sleep(1000);
        
        driver.quit();
        
        SubjectModel eo = new SubjectModel("Java", 1, 0, 20, 20, 60);
        SubjectModel sj = new SubjectDAO().findSubjectByName("Java");
        assertEquals(eo, sj);
    }
    
    @Test
    public void testAdd_CH_45() throws Exception {
        commomMethod();
        
        WebElement btnAdd = driver.findElement(By.className("btn_add"));
        btnAdd.click();
        
        WebElement name = driver.findElement(By.id("frm_name"));
        name.sendKeys("Python");
        WebElement quantity = driver.findElement(By.id("frm_quantity"));
        quantity.sendKeys("0");
        WebElement point1 = driver.findElement(By.id("frm_point1"));
        point1.sendKeys("10");
        WebElement point2 = driver.findElement(By.id("frm_point2"));
        point2.sendKeys("10");
        WebElement point3 = driver.findElement(By.id("frm_point3"));
        point3.sendKeys("20");
        WebElement point4 = driver.findElement(By.id("frm_point4"));
        point4.sendKeys("60");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        quantity.equals(driver.switchTo().activeElement());
        
        Thread.sleep(1000);
        
        driver.quit();
    }
    
    @Test
    public void testAdd_CH_46() throws Exception {
        commomMethod();
        
        WebElement btnAdd = driver.findElement(By.className("btn_add"));
        btnAdd.click();
        
        WebElement name = driver.findElement(By.id("frm_name"));
        name.sendKeys("Python");
        WebElement quantity = driver.findElement(By.id("frm_quantity"));
        quantity.sendKeys("1.1");
        WebElement point1 = driver.findElement(By.id("frm_point1"));
        point1.sendKeys("10");
        WebElement point2 = driver.findElement(By.id("frm_point2"));
        point2.sendKeys("10");
        WebElement point3 = driver.findElement(By.id("frm_point3"));
        point3.sendKeys("20");
        WebElement point4 = driver.findElement(By.id("frm_point4"));
        point4.sendKeys("60");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        quantity.equals(driver.switchTo().activeElement());
        
        Thread.sleep(1000);
        
        driver.quit();
    }
    
    @Test
    public void testAdd_CH_47() throws Exception {
        commomMethod();
        
        WebElement btnAdd = driver.findElement(By.className("btn_add"));
        btnAdd.click();
        
        WebElement name = driver.findElement(By.id("frm_name"));
        name.sendKeys("Python");
        WebElement quantity = driver.findElement(By.id("frm_quantity"));
        quantity.sendKeys("3");
        WebElement point1 = driver.findElement(By.id("frm_point1"));
        point1.sendKeys("-1");
        WebElement point2 = driver.findElement(By.id("frm_point2"));
        point2.sendKeys("10");
        WebElement point3 = driver.findElement(By.id("frm_point3"));
        point3.sendKeys("20");
        WebElement point4 = driver.findElement(By.id("frm_point4"));
        point4.sendKeys("60");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        point1.equals(driver.switchTo().activeElement());
        
        Thread.sleep(1000);
        
        driver.quit();
    }
    
    @Test
    public void testAdd_CH_48() throws Exception {
        commomMethod();
        
        WebElement btnAdd = driver.findElement(By.className("btn_add"));
        btnAdd.click();
        
        WebElement name = driver.findElement(By.id("frm_name"));
        name.sendKeys("Python");
        WebElement quantity = driver.findElement(By.id("frm_quantity"));
        quantity.sendKeys("3");
        WebElement point1 = driver.findElement(By.id("frm_point1"));
        point1.sendKeys("0.1");
        WebElement point2 = driver.findElement(By.id("frm_point2"));
        point2.sendKeys("10");
        WebElement point3 = driver.findElement(By.id("frm_point3"));
        point3.sendKeys("20");
        WebElement point4 = driver.findElement(By.id("frm_point4"));
        point4.sendKeys("60");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        point1.equals(driver.switchTo().activeElement());
        
        Thread.sleep(1000);
        
        driver.quit();
    }
    
    @Test
    public void testAdd_CH_49() throws Exception {
        commomMethod();
        
        WebElement btnAdd = driver.findElement(By.className("btn_add"));
        btnAdd.click();
        
        WebElement name = driver.findElement(By.id("frm_name"));
        name.sendKeys("Python");
        WebElement quantity = driver.findElement(By.id("frm_quantity"));
        quantity.sendKeys("3");
        WebElement point1 = driver.findElement(By.id("frm_point1"));
        point1.sendKeys("101");
        WebElement point2 = driver.findElement(By.id("frm_point2"));
        point2.sendKeys("10");
        WebElement point3 = driver.findElement(By.id("frm_point3"));
        point3.sendKeys("20");
        WebElement point4 = driver.findElement(By.id("frm_point4"));
        point4.sendKeys("60");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        point1.equals(driver.switchTo().activeElement());
        
        Thread.sleep(1000);
        
        driver.quit();
    }
    
    @Test
    public void testAdd_CH_50() throws Exception {
        commomMethod();
        
        WebElement btnAdd = driver.findElement(By.className("btn_add"));
        btnAdd.click();
        
        WebElement name = driver.findElement(By.id("frm_name"));
        name.sendKeys("Python");
        WebElement quantity = driver.findElement(By.id("frm_quantity"));
        quantity.sendKeys("3");
        WebElement point1 = driver.findElement(By.id("frm_point1"));
        point1.sendKeys("0.0");
        WebElement point2 = driver.findElement(By.id("frm_point2"));
        point2.sendKeys("10");
        WebElement point3 = driver.findElement(By.id("frm_point3"));
        point3.sendKeys("20");
        WebElement point4 = driver.findElement(By.id("frm_point4"));
        point4.sendKeys("60");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        Alert alert = driver.switchTo().alert();
        assertEquals("Lỗi: Tổng % 4 đầu điểm phải bằng 100%!", alert.getText());
        
        Thread.sleep(1000);
        
        alert.accept();
        
        assertEquals("0", point1.getAttribute("value"));
        
        Thread.sleep(1000);
        
        driver.quit();
    }
    
    @Test
    public void testAdd_CH_51() throws Exception {
        commomMethod();
        
        WebElement btnAdd = driver.findElement(By.className("btn_add"));
        btnAdd.click();
        
        WebElement name = driver.findElement(By.id("frm_name"));
        name.sendKeys("Java");
        WebElement quantity = driver.findElement(By.id("frm_quantity"));
        quantity.sendKeys("3");
        WebElement point1 = driver.findElement(By.id("frm_point1"));
        point1.sendKeys("10");
        WebElement point2 = driver.findElement(By.id("frm_point2"));
        point2.sendKeys("10");
        WebElement point3 = driver.findElement(By.id("frm_point3"));
        point3.sendKeys("20");
        WebElement point4 = driver.findElement(By.id("frm_point4"));
        point4.sendKeys("60");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        Thread.sleep(1000);
        
        WebElement alert = driver.findElement(By.className("alert-danger"));
        
        assertEquals("Thêm không thành công! Môn học đã tồn tại", alert.getAttribute("innerHTML"));
        
        Thread.sleep(1000);
        
        driver.quit();
    }
    
    @Test
    public void testAdd_CH_52() throws Exception {
        commomMethod();
        
        WebElement btnAdd = driver.findElement(By.className("btn_add"));
        btnAdd.click();
        
        WebElement name = driver.findElement(By.id("frm_name"));
        name.sendKeys("Python1");
        WebElement quantity = driver.findElement(By.id("frm_quantity"));
        quantity.sendKeys("1");
        WebElement point1 = driver.findElement(By.id("frm_point1"));
        point1.sendKeys("10");
        WebElement point2 = driver.findElement(By.id("frm_point2"));
        point2.sendKeys("10");
        WebElement point3 = driver.findElement(By.id("frm_point3"));
        point3.sendKeys("20");
        WebElement point4 = driver.findElement(By.id("frm_point4"));
        point4.sendKeys("60");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        Thread.sleep(1000);
        
        WebElement alert = driver.findElement(By.className("alert-success"));
        
        assertEquals("Thêm thành công", alert.getAttribute("innerHTML"));
        
        Thread.sleep(1000);
        
        driver.quit();
        
        SubjectModel eo = new SubjectModel("Python1", 1, 10, 10, 20, 60);
        SubjectModel sj = new SubjectDAO().findSubjectByName("Python1");
        assertEquals(eo, sj);
    }
    
    @Test
    public void testAdd_CH_53() throws Exception {
        commomMethod();
        
        WebElement btnAdd = driver.findElement(By.className("btn_add"));
        btnAdd.click();
        
        WebElement name = driver.findElement(By.id("frm_name"));
        name.sendKeys("Python2");
        WebElement quantity = driver.findElement(By.id("frm_quantity"));
        quantity.sendKeys("1.0");
        WebElement point1 = driver.findElement(By.id("frm_point1"));
        point1.sendKeys("10");
        WebElement point2 = driver.findElement(By.id("frm_point2"));
        point2.sendKeys("10");
        WebElement point3 = driver.findElement(By.id("frm_point3"));
        point3.sendKeys("20");
        WebElement point4 = driver.findElement(By.id("frm_point4"));
        point4.sendKeys("60");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        Thread.sleep(1000);
        
        WebElement alert = driver.findElement(By.className("alert-success"));
        
        assertEquals("Thêm thành công", alert.getAttribute("innerHTML"));
        
        Thread.sleep(1000);
        
        driver.quit();
        
        SubjectModel eo = new SubjectModel("Python2", 1, 10, 10, 20, 60);
        SubjectModel sj = new SubjectDAO().findSubjectByName("Python2");
        assertEquals(eo, sj);
    }
    
    @Test
    public void testAdd_CH_54() throws Exception {
        commomMethod();
        
        WebElement btnAdd = driver.findElement(By.className("btn_add"));
        btnAdd.click();
        
        WebElement name = driver.findElement(By.id("frm_name"));
        name.sendKeys("Python3");
        WebElement quantity = driver.findElement(By.id("frm_quantity"));
        quantity.sendKeys("1");
        WebElement point1 = driver.findElement(By.id("frm_point1"));
        point1.sendKeys("0.0");
        WebElement point2 = driver.findElement(By.id("frm_point2"));
        point2.sendKeys("20");
        WebElement point3 = driver.findElement(By.id("frm_point3"));
        point3.sendKeys("20");
        WebElement point4 = driver.findElement(By.id("frm_point4"));
        point4.sendKeys("60");
        
        Thread.sleep(1000);
        
        WebElement btnSave = driver.findElement(By.className("btn_save"));
        btnSave.click();
        
        Thread.sleep(1000);
        
        WebElement alert = driver.findElement(By.className("alert-success"));
        
        assertEquals("Thêm thành công", alert.getAttribute("innerHTML"));
        
        Thread.sleep(1000);
        
        driver.quit();
        
        SubjectModel eo = new SubjectModel("Python3", 1, 0, 20, 20, 60);
        SubjectModel sj = new SubjectDAO().findSubjectByName("Python3");
        assertEquals(eo, sj);
    }
   
    @Test
    public void testDelete_CH_55() throws Exception {
        commonMethod_2();
        
        WebElement btnDelete = driver.findElement(By.className("btn-danger"));
        btnDelete.click();
        
        Thread.sleep(1000);
        
        Alert alert = driver.switchTo().alert();
        
        Thread.sleep(1000);
        
        assertEquals("Bạn có chắc chắn muốn xoá?", alert.getText());
        
        Thread.sleep(1000);
        
        alert.dismiss();
        
        Thread.sleep(1000);
        
        driver.quit();
        
        assertTrue(new SubjectDAO().findSubjectByName("Java") != null);
    }
    
    @Test
    public void testDelete_CH_56() throws Exception {
        commonMethod_2();
        
        WebElement btnDelete = driver.findElement(By.className("btn-danger"));
        btnDelete.click();
        
        Thread.sleep(1000);
        
        Alert alert = driver.switchTo().alert();
        
        Thread.sleep(1000);
        
        assertEquals("Bạn có chắc chắn muốn xoá?", alert.getText());
        
        Thread.sleep(1000);
        
        alert.accept();
        
        WebElement msg = driver.findElement(By.className("alert-success"));
        assertEquals("Xoá thành công", msg.getAttribute("innerHTML").trim());
        
        Thread.sleep(1000);
        
        driver.quit();
        
        assertTrue(new SubjectDAO().findSubjectByName("Java") == null);
    }
    
//    @Test
//    public void testUpdate_CH_61() throws Exception {
//        commonMethod_2();
//        
//        WebElement btnUpdate = rows.get(0).findElement(By.className("td_btn_edit"));
//        btnUpdate.click();
//        
//        WebElement point1 = driver.findElement(By.id("frm_point1"));
//        point1.clear();
//        point1.sendKeys("0");
//        
//        WebElement point2 = driver.findElement(By.id("frm_point2"));
//        point2.clear();
//        point2.sendKeys("20");
//        
//        Thread.sleep(1000);
//        
//        WebElement btnSave = driver.findElement(By.className("btn_save"));
//        btnSave.click();
//        
//        Thread.sleep(1000);  
//        
//        WebElement alert = driver.findElement(By.className("alert-success"));
//        assertEquals("Sửa thành công", alert.getAttribute("innerHTML"));
//        
//        Thread.sleep(1000);
//        
//        WebElement btnTrackPoint = driver.findElement(By.id("theodoidiem"));
//        btnTrackPoint.click();
//        
//        Thread.sleep(1000);
//        
//        WebElement semester = driver.findElement(By.name("semester"));
//        semester.sendKeys("Kì 1 năm 2020-2021");
//        WebElement faculty = driver.findElement(By.name("faculty"));
//        faculty.sendKeys("CNTT");
//        WebElement subject = driver.findElement(By.name("subject"));
//        subject.sendKeys("Java");
//        WebElement subclass = driver.findElement(By.name("subclassroom"));
//        subject.sendKeys("JAVA_01");
//        
//        Thread.sleep(1000);
//        
//        WebElement btnFilter = driver.findElement(By.className("btn-primary"));
//        btnFilter.click();
//        
//        Thread.sleep(1000);
//        
//        WebElement p1 = driver.findElement(By.id("p1"));
//        WebElement p2 = driver.findElement(By.id("p2"));
//        WebElement p3 = driver.findElement(By.id("p3"));
//        WebElement p4 = driver.findElement(By.id("p4"));
//        
//        assertEquals("Điểm CC (10%)", p1.getAttribute("innerHTML"));
//        assertEquals("Điểm BT (10%)", p2.getAttribute("innerHTML"));
//        assertEquals("Điểm TH (20%)", p3.getAttribute("innerHTML"));
//        assertEquals("Điểm KTHP (60%)", p4.getAttribute("innerHTML"));
//        
//        driver.quit();
//    }
}
