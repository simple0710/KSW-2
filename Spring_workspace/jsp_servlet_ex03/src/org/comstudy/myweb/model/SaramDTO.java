package org.comstudy.myweb.model;

public class SaramDTO {
   int seq;
   String id;
   String name;
   int age;
   
   public SaramDTO() {
      // 디폴트 생성자 - 매개변수가 없는 생성자
      // 생성자 오버로딩 된 상황에서는 개발자가 직접 만든다.
      // 생성자가 하나도 없다면 컴파일러가 컴파일 하기 위해 자동으로 생성 한다.
   }

   public SaramDTO(int seq, String id, String name, int age) {
      // 생성자 오버로딩 : 매개변수가 있는 생성자.
      // 오버로딩 : 같은 이름의 메서드가 같은 클래스에 여러게 존재 할 수 있다.
      // 오버로딩의 시그너처는 매개변수의 타입과 이름이 달라야 한다.
      
      // 필드의 이름과 매개변수의 이름이 동일 할때는 구분을 위해 필드앞에 this붙인다.
      // this 객체 자신을 가리키는 참조이다.
      this.seq = seq;
      this.id = id;
      this.name = name;
      this.age = age;
   }

   public int getSeq() {
      return seq;
   }

   public void setSeq(int seq) {
      this.seq = seq;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   @Override
   public String toString() {
      return "SaramDTO [seq=" + seq + ", id=" + id + ", name=" + name + ", age=" + age + "]";
   }
}