package main.java.pricelistClass;

import static org.junit.Assert.*;

public class PriceListTest {
    private PriceList pr = new PriceList();
    @org.junit.Test
    public void addGood() throws Exception {
        pr = new PriceList();
        pr.addGood("Зачет", 10.2);
        assertEquals(pr.toString(),"1575514053 Зачет:10.2\n");
    }

    @org.junit.Test
    public void editName() throws Exception {
        pr = new PriceList();
        pr.addGood("Зачет", 10.2);
        pr.editName(1575514053, "Экзамен");
        pr.editPrice(1575514053, 120.11);
        assertEquals(pr.toString(),"1575514053 Экзамен:120.11\n");
    }

    @org.junit.Test
    public void remove() throws Exception {
        pr = new PriceList();
        pr.addGood("Зачет", 10.2);
        pr.addGood("Экзамен", 120.11);
        assertEquals(pr.toString(), "1204418495 Экзамен:120.11\n" +
                "1575514053 Зачет:10.2\n");
        pr.remove(1204418495);
        assertEquals(pr.toString(),"1575514053 Зачет:10.2\n");
    }

    @org.junit.Test
    public void getTotalPrice() throws Exception {
        pr = new PriceList();
        pr.addGood("Зачет", 10.2);
        assertTrue(Double.compare(pr.getTotalPrice(1575514053,10),102.0) == 0);
    }

}