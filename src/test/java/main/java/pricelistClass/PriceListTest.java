package main.java.pricelistClass;

import static org.junit.Assert.*;

public class PriceListTest {
    private PriceList pr = new PriceList();
    @org.junit.Test
    public void addGood() throws Exception {
        pr = new PriceList();
        pr.addGood(1,"Зачет", "10.2");
        assertEquals(pr.toString(),"1 Зачет:10.2\n");
    }

    @org.junit.Test
    public void editName() throws Exception {
        pr = new PriceList();
        pr.addGood(1,"Зачет", "10.2");
        pr.editName(1, "Экзамен");
        pr.editPrice(1, "120.11");
        assertEquals(pr.toString(),"1 Экзамен:120.11\n");
    }

    @org.junit.Test
    public void remove() throws Exception {
        pr = new PriceList();
        pr.addGood(1,"Зачет", "10.2");
        pr.addGood(2,"Экзамен", "120.11");
        assertEquals(pr.toString(), "1 Зачет:10.2\n" +
                " Экзамен:120.11\n");
        pr.remove(2);
        assertEquals(pr.toString(),"1 Зачет:10.2\n");
    }

    @org.junit.Test
    public void getTotalPrice() throws Exception {
        pr = new PriceList();
        pr.addGood(1,"Зачет", "10.2");
        assertTrue(Double.compare(pr.getTotalPrice(1,10),102.0) == 0);
    }

}