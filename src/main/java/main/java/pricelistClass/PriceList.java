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
     public int addGood(int code, String name, String price){
         if(priceList.get(code) != null) return -1;
         String[] tmp = price.split(".");
         if(tmp.length > 2) return -1;
         if(tmp.length == 2 && tmp[1].length() > 4) return -1;
         priceList.put(code,new Good(name,Double.parseDouble(price)));
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

     /**
      *  @param code - code of good
      * @param nPrice - new price of good
      */

     public boolean editPrice(int code, String nPrice){
         String[] tmp = nPrice.split(".");
         if(tmp.length > 2) return false;
         if(tmp.length == 2 && tmp[1].length() > 4) return false;
         if(priceList.get(code)==null) return false;
         priceList.get(code).price = Double.parseDouble(nPrice);
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
         return priceList.get(code).price * num;
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