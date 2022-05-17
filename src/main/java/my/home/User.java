package my.home;

import org.graalvm.compiler.api.replacements.Snippet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class User {
    private static Map<Integer, User> allUsers = new HashMap<>();
    private static int countId = 0;
    private int id;
    private String name;
    private int age;
    private Sex sex;

    public User(String name, int age, Sex sex) {

        if (name != null && !name.isEmpty() && age > 0 && sex != null) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            if (!hasUser()) {
                countId++;
                this.id = countId;
                allUsers.put(id, this);
            }
        }
    }

    public static List<User> getAllUsers() {
        return new ArrayList<>(allUsers.values());
    }

    public static List<User> getAllUsers(Sex sex) {
        return allUsers.values().stream().filter(x -> x.sex == sex).collect(Collectors.toList());
    }

    public static int getAllAgeUsers() {
        return allUsers.values().stream().flatMapToInt(x -> IntStream.of(x.age)).sum();
    }

    public static int getAllAgeUsers(Sex sex) {
        return allUsers.values().stream().filter(x -> x.sex == sex).flatMapToInt(x -> IntStream.of(x.age)).sum();
    }

    public static int getHowManyUsers() {
        return allUsers.size();
    }

    public static int getHowManyUsers(Sex sex) {
        return getAllUsers(sex).size();
    }

    public static int getAverageAgeOfAllUsers() {
        return getAllAgeUsers() / getHowManyUsers();
    }

    public static int getAverageAgeOfAllUsers(Sex sex) {
        return getAllAgeUsers(sex) / getHowManyUsers(sex);
    }

    private boolean hasUser() {
        for (User user : allUsers.values()) {
            if (user.equals(this) && user.hashCode() == this.hashCode()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return this.age == user.age && this.name.equals(user.name) && this.sex == user.sex;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
