package main.java.pricelistClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PriceList {
    private Map<Integer,Good> priceList = new HashMap<Integer, Good>();
    static class Good{
        private String name;
        private Integer price;
        private Integer rightPrice;
        public Good (String name, int pr, int r){
            this.name = name;
            this.price = pr;
            this.rightPrice = r;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Good good = (Good) o;
            return price == good.price &&
                    rightPrice == good.rightPrice &&
                    Objects.equals(name, good.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price, rightPrice);
        }

        @Override
        public String toString() {
            return String.format("%s:%d.%2d", name, price, rightPrice);
        }
    }
    /**
     * add a good and price to the list
     * @param name - name of a code.
     * @param price - price of a code.
     * @return hashcode as code with good and price
     *
     */
    public int addGood(int code, String name, String price){
        if(priceList.get(code) != null) return -1;
        String[] tmp = price.split("\\.");
        if(tmp.length > 2) return -1;
        priceList.put(code,new Good(name, Integer.valueOf(tmp[0]), round(Integer.valueOf(tmp[1]))));
        return code;
    }

    /**
     *
     * @param code - code of good
     * @param nName - new name of good
     */

    public boolean editName(int code, String nName){
        if(priceList.get(code)==null) return false;
        priceList.get(code).name = nName;
        return true;
    }

    private int round(int pr){
        if(pr < 10) return pr * 10;
        while(pr > 100){
            int t = pr % 10;
            pr /= 10;
            if(t > 4) pr++;
        }
        return pr;
    }

    /**
     * @param code - code of good
     * @param nPrice - new price of good
     */

    public boolean editPrice(int code, String nPrice){
        String[] tmp = nPrice.split("\\.");
        if(tmp.length > 2) return false;
        if(priceList.get(code)==null) return false;
        int left = Integer.valueOf(tmp[0]);
        int right = round(Integer.valueOf(tmp[1]));
        priceList.get(code).price = left;
        priceList.get(code).rightPrice = right;
        return true;
    }

    /**
     * remove good from the price list
     * @param code - code of good
     */
    public void remove(int code){
        priceList.remove(code);
    }

    /**
     *
     * @param code - code of good
     * @param num - number of products
     * @return total price of products
     */
    public double getTotalPrice(int code, int num){
        if(priceList.get(code)==null) return -1;
        return (double) (priceList.get(code).price * num) + (double) (priceList.get(code).rightPrice * num) /100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceList priceList1 = (PriceList) o;
        return Objects.equals(priceList, priceList1.priceList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(priceList);
    }

    public Good getGood(int code){
        return priceList.get(code);

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(Map.Entry e : priceList.entrySet()){
            res.append(e.getKey()).append(" ").append(e.getValue().toString()).append("\n");
        }
        return res.toString();
    }
}