import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    private Person(String name, String surname, Integer age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age != null;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age != null ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (age != null) {
            age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setSurname(this.surname);
        if (this.hasAddress()) {
            childBuilder.setAddress(this.address);
        }
        childBuilder.setAge(0);
        return childBuilder;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + surname.hashCode() + (age != null ? age.hashCode() : 0) + (address != null ? address.hashCode() : 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return name.equals(person.name) && surname.equals(person.surname) && (age != null ? age.equals(person.age) : person.age == null) && (address != null ? address.equals(person.address) : person.address == null);
    }

    public static class PersonBuilder {
        private String name;
        private String surname;
        private Integer age;
        private String address;

        public PersonBuilder setName(String name) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Имя не может быть пустым или null");
            }
            this.name = name;
            return this;
        }

        public PersonBuilder setSurname(String surname) {
            if (surname == null || surname.isEmpty()) {
                throw new IllegalArgumentException("Фамилия не может быть пустой или null");
            }
            this.surname = surname;
            return this;
        }

        public PersonBuilder setAge(int age) {
            if (age < 0) {
                throw new IllegalArgumentException("Возраст не может быть отрицательным");
            }
            this.age = age;
            return this;
        }

        public PersonBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            if (name == null || surname == null) {
                throw new IllegalStateException("Необходимо ввести Имя и Фамилию");
            }
            return new Person(name, surname, age, address);
        }
    }
}
