package org.comstudy21.myweb.common;

public class LogAdvice {
   
   public void printLogging() {
      // AOP 포인트 컷으로 검색된 기능에 추가되는 기능.
      System.out.println(">>>>> printLoging() : 임시 내용 ...");
   }
   
   public void afterLogging() {
      // AOP 포인트 컷으로 검색된 기능에 추가되는 기능.
      System.out.println(">>>>> afterLogging() : 서비스 처리 후 실행 ...");
   }
}