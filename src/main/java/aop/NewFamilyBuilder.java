package aop;


import aop.Person.FamilyBuilder;

public class NewFamilyBuilder {
    public static void main(String[] args) {
        GenerateFamily();
        Person.getFamily().forEach(System.out::println);
    }

    private static void GenerateFamily() {
        Person Vasya = new FamilyBuilder("Вася", true).build();
        Person Masha = new FamilyBuilder("Маша", false).build();
        Person Kolya = new FamilyBuilder("Коля", true)
                .setMother(Masha).setFather(Vasya).build();
        Person Alevtina = new FamilyBuilder("Алевтина", false)
                .setMother(Masha).setFather(Vasya).setSisterOrBrother(Kolya).build();
        Person Vasilisa = new FamilyBuilder("Василиса Петровна", false)
                .setChild(Vasya).build();
        Person Nikolay = new FamilyBuilder("Николай Иванович", true)
                .setChild(Vasya).build();
        Person Olga = new FamilyBuilder("Ольга Бузова", false)
                .setChild(Masha).build();
        Person Timur = new FamilyBuilder("Тимур Батрутдинов", true)
                .setChild(Masha).build();
        Person Filipp = new FamilyBuilder("Филипп Киркоров", true)
                .setChild(Nikolay).build();
    }
}
