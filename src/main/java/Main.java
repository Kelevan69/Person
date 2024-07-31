public class Main {
    public static void main(String[] args) {

        Person mom = new Person.PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        System.out.println("У " + mom + " есть сын, " + son);

        try {
            new Person.PersonBuilder().build();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        try {
            new Person.PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
