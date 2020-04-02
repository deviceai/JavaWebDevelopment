package classes;

public class Human {

    public String name;
    public int age;

    public Human() {
        this.name = "default";
        this.age = 1;
    }

        public Human(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return this.age + " " + this.name;
        }

}

