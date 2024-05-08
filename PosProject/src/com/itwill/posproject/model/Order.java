
package com.itwill.posproject.model;

public class Order {
   public static final class Entity {
      // 데이터베이스 테이블 이름을 상수로 선언.
      public static final String TBL_ORDER = "Orders";

      public static final String COL_ORDER_DATE= "ORDER_DATE";
      public static final String COL_MENU = "MENU";
      public static final String COL_PRICE = "PRICE";
   }

   private String orderDate;
   private String menu;
   private int price;
   
   public Order() {}

   public Order(String date, String menu, int price) {
      super();
      this.orderDate = date;
      this.menu = menu;
      this.price = price;
   }

   public String getDate() {
      return orderDate;
   }

   public void setDate(String names) {
      this.orderDate = names;
   }

   public String getMenu() {
      return menu;
   }

   public void setMenu(String names) {
      this.menu = names;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   @Override
   public String toString() {
      return "Order [date=" + orderDate + ", menu=" + menu + ", price=" + price + "]";
   }
}
