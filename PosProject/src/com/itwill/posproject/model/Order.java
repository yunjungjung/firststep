
package com.itwill.posproject.model;

public class Order {
   
   public static final class Entity {
   // 데이터베이스 테이블 이름을 상수로 선언.
      public static final String TBL_MENUS = "Order";

      // 데이터베이스 "Order" 테이블의 컬럼 이름들을 상수로 선언.
      public static final String COL_NAMES = "name";
      public static final String COL_PRICE = "price";
      public static final String COL_NUMBER = "number";
      public static final String COL_TOTLAPRICE = "totalprice";

   }
   private String names;
   private int price;
   private int number;
   private int totalprice;
   
   public Order() {}

   public Order(String names, int price, int number, int totalprice) {
      super();
      this.names = names;
      this.price = price;
      this.number = number;
      this.totalprice = totalprice;
   }

   public String getNames() {
      return names;
   }

   public void setNames(String names) {
      this.names = names;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public int getNumber() {
      return number;
   }

   public void setNumber(int number) {
      this.number = number;
   }

   public int getTotalprice() {
      return totalprice;
   }

   public void setTotalprice(int totalprice) {
      this.totalprice = totalprice;
   }

   @Override
   public String toString() {
      return "Order [names=" + names + ", price=" + price + ", number=" + number + ", totalprice=" + totalprice + "]";
   

   }
   
   
}
