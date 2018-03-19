package main.java.pricelistClass;

import java.util.HashMap;
import java.util.Map;

 public class PriceList {
     private Map<Integer,Good> priceList = new HashMap<Integer, Good>();
     static class Good{
         private String name;
         private double price;
         public Good (String name, double pr){
             this.name = name;
             this.price = pr;
         }

         @Override
         public boolean equals(Object o) {
             if (this == o) return true;
             if (o == null || getClass() != o.getClass()) return false;

             Good good = (Good) o;

             if (Double.compare(good.price, price) != 0) return false;
             return name.equals(good.name);
         }

         @Override
         public int hashCode() {
             int result;
             long temp;
             result = name.hashCode();
             temp = Double.doubleToLongBits(price);
             result = 31 * result + (int) (temp ^ (temp >>> 32));
             return result;
         }

         @Override
         public String toString() {
             return name + ":" + price;
         }
     }
     /**
      * add a good and price to the list
      * @param name - name of a code.
      * @param price - price of a code.
      * @return hashcode as code with good and price
      *
      */
     public int addGood(String name,double price){
         Good tmp = new Good(name,price);
         priceList.put(tmp.hashCode(),tmp);
         return tmp.hashCode();
     }

     /**
      *
      * @param code - code of good
      * @param nName - new name of good
      */

     public void editName(int code, String nName){
         priceList.get(code).name = nName;
     }

     /**
      *
      * @param code - code of good
      * @param nPrice - new price of good
      */

     public void editPrice(int code, double nPrice){
         priceList.get(code).price = nPrice;
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
         return priceList.get(code).price * num;
     }

     @Override
     public String toString() {
         StringBuilder res = new StringBuilder();
         for(Map.Entry e : priceList.entrySet()){
             res.append(e.getKey()).append(" ").append(e.getValue()).append("\n");
         }
         return res.toString();
     }
 }