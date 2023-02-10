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
        Person Alevtina = new Person.FamilyBuilder("Алевтина", false)
                .setMother(Masha).setFather(Vasya).setSisterOrBrother(Kolya).build();
        Person Vasilisa = new Person.FamilyBuilder("Василиса Петровна", false)
                .setChild(Vasya).build();
        Person Nikolay = new Person.FamilyBuilder("Николай Иванович", true)
                .setChild(Vasya).build();
        Person Olga = new Person.FamilyBuilder("Ольга Бузова", false)
                .setChild(Masha).build();
        Person Timur = new Person.FamilyBuilder("Тимур Батрутдинов", true)
                .setChild(Masha).build();
        Person Filipp = new Person.FamilyBuilder("Филипп Киркоров", true)
                .setChild(Nikolay).build();
        Person WonderTea = new Person.FamilyBuilder("Чудо Чай", true).setMother(Alevtina).build();
        Person Korzhik = new Person.FamilyBuilder("Коржик", true).setMother(Alevtina)
                .setSisterOrBrother(WonderTea).build();
        Person iRobloxQueen = new Person.FamilyBuilder("iRobloxQueen", false).setMother(Alevtina)
                .setSisterOrBrother(Korzhik).build();
    }
}
