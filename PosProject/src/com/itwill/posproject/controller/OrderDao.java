package com.itwill.posproject.controller;

import java.util.List;

import com.itwill.posproject.view.Order;

public class OrderDao {

   private static OrderDao instance;

   public static OrderDao getInstance() {
          if (instance == null) {
               instance = new OrderDao();
           }
           
           return instance;
       }
       //<----- singleton

   public List<Order> order() {
      // TODO Auto-generated method stub
      return null;
   }

   public List<com.itwill.posproject.model.Order> read() {
      // TODO Auto-generated method stub
      return null;
   }
   }
