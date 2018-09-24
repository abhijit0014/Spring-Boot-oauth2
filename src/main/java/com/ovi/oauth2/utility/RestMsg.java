package com.ovi.oauth2.utility;

// A helper class to make our controller output look nice
public class RestMsg {
   private String msg;
   public RestMsg(String msg) {
       this.msg = msg;
   }
   public String getMsg() {
       return msg;
   }
   public void setMsg(String msg) {
       this.msg = msg;
   }
}
