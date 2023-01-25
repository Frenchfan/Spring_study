package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    //можно через запятую перечислить сразу несколько конфиг файлов
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        Dog myDog = context.getBean("myPet", Dog.class);
        Dog yourDog = context.getBean("myPet", Dog.class);
//        myDog.setName("Belka");
//        yourDog.setName("Strelka");
        System.out.println("Переменные ссылаются на один и тот же объект?");
        System.out.println(myDog == yourDog);
        System.out.println(myDog);
        System.out.println(yourDog);
//        System.out.println(myDog.getName());
//        System.out.println(yourDog.getName());
        context.close();
    }
}
