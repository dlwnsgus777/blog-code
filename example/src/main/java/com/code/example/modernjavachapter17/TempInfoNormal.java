package com.code.example.modernjavachapter17;

import java.util.Random;

public class TempInfoNormal {
   private final String town;
   private final int temp;

   public TempInfoNormal(String town, int temp) {
      this.town = town;
      this.temp = temp;
   }

   public static TempInfoNormal fetch(String town, int tem) {

      return new TempInfoNormal(town, tem);
   }

   @Override
   public String toString() {
      return "TempInfo{" +
            "town='" + town + '\'' +
            ", temp=" + temp +
            '}';
   }

   public String getTown() {
      return town;
   }

   public int getTemp() {
      return temp;
   }
}
