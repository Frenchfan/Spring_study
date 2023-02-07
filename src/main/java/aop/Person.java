package aop;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


public class Person {

    private static Set<Person> family = new HashSet<>();

    private String nameSurname;
    private boolean sex;
    private Person mother;
    private Person father;
    private Person child;
    private Person sisterOrBrother;

    private Person(FamilyBuilder familyBuilder) {
        this.nameSurname = familyBuilder.nameSurname;
        this.sex = familyBuilder.sex;
        if (Optional.ofNullable(familyBuilder.mother).isPresent()) this.setMother(familyBuilder.mother);
        if (Optional.ofNullable(familyBuilder.father).isPresent()) this.setFather(familyBuilder.father);
        if (Optional.ofNullable(familyBuilder.child).isPresent()) this.setChild(familyBuilder.child);
        if (Optional.ofNullable(familyBuilder.sisterOrBrother).isPresent())
            this.setSisterOrBrother(familyBuilder.sisterOrBrother);
        family.add(this);
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public boolean isSex() {
        return sex;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public Person getChild() {
        return child;
    }

    public Person getSisterOrBrother() {
        return sisterOrBrother;
    }

    public static Set<Person> getFamily() {
        return family;
    }

    public void setMother(Person mother) {
        this.mother = mother;
        mother.child = this;
    }

    public void setFather(Person father) {
        this.father = father;
        father.child = this;
    }

    public void setChild(Person child) {
        this.child = child;
        if (sex) child.father = this;
        else child.mother = this;
    }

    public void setSisterOrBrother(Person sisterOrBrother) {
        this.sisterOrBrother = sisterOrBrother;
        sisterOrBrother.sisterOrBrother = this;
    }

    @Override
    public String toString() {
        String outMother = Optional.ofNullable(mother).isEmpty() ? "" :
                ", маму зовут: " + mother.getNameSurname();

        String outFather = Optional.ofNullable(father).isEmpty() ? "" :
                ", папу зовут: " + father.getNameSurname();

        String outChild = Optional.ofNullable(child).isEmpty() ? "" :
                ", ребенка зовут: " + child.getNameSurname();

        String outSisterOrBrother = Optional.ofNullable(sisterOrBrother).isEmpty() ? "" :
                ", сестру/брата зовут: " + sisterOrBrother.getNameSurname();

        return "Член семьи " +
                "с именем " + nameSurname +
                outMother +
                outFather +
                outSisterOrBrother +
                outChild;
    }
    public static class FamilyBuilder {
        private final String nameSurname;
        private final boolean sex;
        private Person mother;
        private Person father;
        private Person child;
        private Person sisterOrBrother;


        public FamilyBuilder(String nameSurname, boolean sex) {
            this.nameSurname = nameSurname;
            this.sex = sex;
        }

        public FamilyBuilder setMother(Person mother) {
            this.mother = mother;
            return this;
        }

        public FamilyBuilder setFather(Person father) {
            this.father = father;
            return this;
        }

        public FamilyBuilder setChild(Person child) {
            this.child = child;

            return this;
        }

        public FamilyBuilder setSisterOrBrother(Person sisterOrBrother) {
            this.sisterOrBrother = sisterOrBrother;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }
}
