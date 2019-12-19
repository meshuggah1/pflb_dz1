package ru.kudryavcev_kb.dz_1;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestMain {
    Main main;

    @BeforeClass
    public void setUp(){
        main = new Main();
    }

    @BeforeTest
    public void beforeEachTest(){
        System.out.println(Thread.currentThread().getId());
    }

    @DataProvider(name = "numberProvider_1")
    public Object[][] dataProvider1(){
        return new Object[][]{
                {3, "11"},{0, "0"},{-800, "1111111111111111111111111111111111111111111111111111110011100000"}
        };
    }

    @Test(description = "decimalToBinary_Positive_Test", dataProvider = "numberProvider_1")
    public void testDecimalToBinaryPos(int i, String expected_res){

        Assert.assertEquals(main.decimalToBinary(i), expected_res);
    }

    @Test(description = "decimalToBinary_Negative_Test")
    public void testDecimalToBinaryNeg(){
        // проверим, что такой некорректный ввод наш метод обманет
        Assert.assertEquals(main.decimalToBinary(0b101), "101");
    }

    @DataProvider(name = "numberProvider_2")
    public Object[][] dataProvider2(){
        return new Object[][]{
                {13, "d"},{0, "0"},{-800, "fffffffffffffce0"}
        };
    }

    @Test(description = "decimalToHex_Test", dataProvider = "numberProvider_2")
    public void testDecimalToHex(int i, String expected_res){

        Assert.assertEquals(main.decimalToHex(i),expected_res);
    }

    @Test(description = "decimalToHex_NegativeTest")
    public void testDecimalToHexNeg(){
        // проверим, что такой некорректный ввод наш метод обманет
        Assert.assertNotEquals(main.decimalToHex(0b101), "101");
    }

    @DataProvider(name = "numberProvider_3")
    public Object[][] dataProvider3(){
        return new Object[][]{
                {11000, "25370"},{1001, "1751"}
        };
    }

    @Test(description = "binaryToOctal_Test", dataProvider = "numberProvider_3")
    public void testBinaryToOCtal(int i, String expected_res){

        Assert.assertEquals(main.binaryToOctal(i), expected_res);
    }

    @DataProvider(name = "dataProvider_4")
    public Object[][] dataProvider4(){
        return new Object[][]{
                {"1"}, {"-800"},
                {"0b1001"}, {"1b"}
        };
    }

    @Test(description = "validateNum_Test", dataProvider = "dataProvider_4")
    public void testValidateNum(String s){

        Assert.assertTrue(main.validateNum(s));
    }

    @Test(description = "validateNum_TestNegative")
    public void testValidateNumNeg(){

        Assert.assertFalse(main.validateNum("Java"));
    }
}
