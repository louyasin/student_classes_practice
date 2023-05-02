import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {


        //COMPLETE THIS CLASS AFTER ALL THE OTHER CLASSES

        /*
        Write a code that asks user to if they would like join your classes
        If the answer is "Yes" from user,then ask user information; firstName, lastName, age, gender, class to join
        ***If user is age is not more than 20, do not allow them to join
        ***If user wants to join any other class except Math and Science, do not allow them to join

        REMEMBER - checkAge and checkClassName methods may throw exceptions. You have to handle them

        Keep asking users the question they would to like join until you have got 3 students overall
        Create MathStudent or ScienceStudent objects based on user's answer for the class they want to join
        Print a "Congratulations! You are registered for {className} class."

        Store all these 3 objects in a collection and print them

        EXPECTED OUTPUT OF THE PROGRAM:
        Print information of all 3 students
        Print how many students are MathStudent with message -> "Math students = {numberOfMathStudents}"
        Print how many students are ScienceStudent with message -> "Science students = {numberOfScienceStudents}"
         */
        Scanner scanner = new Scanner(System.in);
        List<Object> students = new ArrayList<>();
        int totalStudents = 0;
        int numberMathStudents = 0;
        int numberScienceStudents = 0;

        while (totalStudents < 3) {
            System.out.println(UserQuestions.askToJoin);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                try {
                    System.out.println(UserQuestions.askFirstName);
                    String fname = scanner.nextLine();
                    System.out.println(UserQuestions.askLastName);
                    String lname = scanner.nextLine();
                    System.out.println(UserQuestions.askAge);
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    Permission.checkAge(age);

                    System.out.println(UserQuestions.askGender);
                    String gender = scanner.nextLine();
                    System.out.println(UserQuestions.askClassName);
                    String className = scanner.nextLine();
                    Permission.checkClassName(className);

                    if (className.equalsIgnoreCase("math")) {
                        MathStudent mathStudent = new MathStudent(fname, lname, age, gender, className);
                        numberMathStudents++;
                        students.add(mathStudent);
                    } else if (className.equalsIgnoreCase("Science")) {
                        ScienceStudent scienceStudent = new ScienceStudent(fname, lname, age, gender, className);
                        numberScienceStudents++;
                        students.add(scienceStudent);
                    }

                    System.out.println("Congratulations! You are registered for " + className + " class.");
                    totalStudents++;
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }



        System.out.println(students);
        System.out.println("Math students =" + numberMathStudents);
        System.out.println("Science students =" + numberScienceStudents);

    }
}