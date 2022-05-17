package my.home;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new User("Dima",39,Sex.MALE);
        new User("Natasha",45,Sex.FEMALE);
        new User("Marat",14,Sex.MALE);

        User.getAllUsers().forEach(System.out::println);
        System.out.println("____________________________");
        User.getAllUsers(Sex.FEMALE).forEach(System.out::println);
        System.out.println("_____________________________");
        System.out.println(User.getAllAgeUsers());
        System.out.println("________________________________");
        System.out.println(User.getAllAgeUsers(Sex.MALE));
        System.out.println("_____________________________");
        System.out.println(User.getAverageAgeOfAllUsers());
        System.out.println("_____________________________");
        System.out.println(User.getAverageAgeOfAllUsers(Sex.FEMALE));
        System.out.println("_____________________________");
        System.out.println(User.getHowManyUsers());
        System.out.println("_____________________________");
        System.out.println(User.getHowManyUsers(Sex.MALE));
        System.out.println("_____________________________");




        System.out.println( "Hello World!" );
    }
}
