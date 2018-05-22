package main.java.pricelistClass;

import static junit.framework.Assert.*;

public class PriceListTest {
    private PriceList pr = new PriceList();
    @org.junit.Test
    public void addGood() throws Exception {
        pr = new PriceList();
        pr.addGood(1,"Зачет", "10.2");
        assertEquals(new PriceList.Good("Зачет", 10, 20),pr.getGood(1));
    }

    @org.junit.Test
    public void editName() throws Exception {
        pr = new PriceList();
        pr.addGood(1,"Зачет", "10.2");
        pr.editName(1, "Экзамен");
        pr.editPrice(1, "120.11");
        assertEquals(new PriceList.Good("Экзамен", 120, 11),pr.getGood(1));
    }

    @org.junit.Test
    public void remove() throws Exception {
        pr = new PriceList();
        pr.addGood(1,"Зачет", "10.2");
        pr.addGood(2,"Экзамен", "120.11");
        assertEquals(new PriceList.Good("Зачет", 10, 20), pr.getGood(1));
        assertEquals(new PriceList.Good("Экзамен", 120, 11), pr.getGood(2));
        pr.remove(2);
        PriceList lst = new PriceList();
        lst.addGood(1,"Зачет","10.2");
        assertEquals(lst,pr);
        assertNull(pr.getGood(2));
    }

    @org.junit.Test
    public void getTotalPrice() throws Exception {
        pr = new PriceList();
        pr.addGood(1,"Зачет", "10.2");
        assertEquals(0, Double.compare(pr.getTotalPrice(1, 10), 102.0));
    }

}