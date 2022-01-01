package adventure.ship;

import java.util.Objects;

public class Sailor {

    private final String firstName;
    private final String lastName;
    private final String nickname;
    private final int age;

    public Sailor(String firstName, String lastName, String nickname, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sailor sailor = (Sailor) o;
        return age == sailor.age && firstName.equals(sailor.firstName) &&
                lastName.equals(sailor.lastName) && nickname.equals(sailor.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, nickname, age);
    }

    @Override
    public String toString() {
        return age < 18 ? firstName : lastName;
    }
}
