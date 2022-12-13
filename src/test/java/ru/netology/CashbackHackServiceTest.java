package ru.netology;

//import static org.testng.Assert.*;
public class CashbackHackServiceTest {
    CashbackHackService service = new CashbackHackService();

    @org.testng.annotations.Test
    // меньше нуля на 1
    public void lessThanZeroBy1() {
        org.testng.Assert.assertThrows(RuntimeException.class, () -> service.remain(-1));
    }

    @org.testng.annotations.Test
    //  равен нулю
    public void equalsZero() {
        org.testng.Assert.assertEquals(service.remain(0), 1000);
    }

    @org.testng.annotations.Test
    //больше нуля на 1
    public void greatThanZeroBy1() {
        org.testng.Assert.assertEquals(service.remain(1), 999);
    }

    @org.testng.annotations.Test
    // меньше лимита
    public void lessThanLimit() {
        org.testng.Assert.assertEquals(service.remain(300), 700);
    }

    @org.testng.annotations.Test
    //меньше лимита на 1
    public void lessThanLimitBy1() {
        org.testng.Assert.assertEquals(service.remain(999), 1);
    }

    @org.testng.annotations.Test
    //равно лимиту
    public void LessToTheLimit() {
        org.testng.Assert.assertEquals(service.remain(1000), 0);
    }

    @org.testng.annotations.Test
    //больше лимита на 1
    public void MoreThanLimitBy1() {
        org.testng.Assert.assertEquals(service.remain(1001), 999);
    }

    @org.testng.annotations.Test
    //больше лимита
    public void OverLimit() {
        org.testng.Assert.assertEquals(service.remain(1500), 500);
    }

    @org.testng.annotations.Test
    //кратно лимиту
    public void MultipleOfTheLimit() {
        org.testng.Assert.assertEquals(service.remain(3000), 0);
    }
}


