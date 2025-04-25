package stream.v1;

import java.util.*;
import java.util.stream.Collectors;

public class StudentMain {

    //https://freedium.cfd/https://medium.com/illumination/java-8-stream-api-commonly-asked-interview-questions-2a57081044ef
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));
        //1. Find names starting with 'A'
        List<Student> startWithA = list.stream().filter(s -> s.getFirstName().startsWith("A")).toList();

        System.out.println("Start with A:: ");
        startWithA.forEach(System.out::println);
        System.out.println("\n END-- \n\n");

        //2. Group The Student By Department Names
        Map<String, List<Student>> groupByDeptName = list.stream().collect(Collectors.groupingBy(s -> s.getDepartmantName()));

        System.out.println("Group by Dept::");
        groupByDeptName
                .forEach((key, value) -> System.out.println("dept: " + key + " | Students count: " + value.size()));
        System.out.println("\n END--- \n\n");
        //3. Find the total count of student using stream
        long count = list.stream().count();
        System.out.println("Count: " + count);
        System.out.println("\n END---- \n\n");

        //4. Find the max age of student
        System.out.println("MAX AGE::");
        Optional<Student> max = list.stream().max(Comparator.comparing(Student::getAge));
        System.out.println("Max stu age: " + max);
        System.out.println("\n END--- \n\n");


        System.out.println("ALL Dept Names::");
        list.stream().map(Student::getDepartmantName)
                .distinct().toList().forEach(System.out::println);
        System.out.println("\n END-- \n\n");

        // Find the count of student in each department
        System.out.println("Dept wise Count::");
        list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
                .forEach((k, v) -> System.out.println("Dept: " + k + " | count: " + v));
        System.out.println("\n END-- \n\n");

        // Find the list of students whose age is less than 30
        System.out.println("Less than 30 Age stu::");
        list.stream()
                .filter(s -> s.getAge() < 30)
                .toList().forEach(System.out::println);
        System.out.println("\n END-- \n\n");

        // Find the average age of male and female students
        System.out.println("Gender Avg age::");
        list.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)))
                .forEach((k, v) -> System.out.println("Gender: " + k + " | avg: " + v));
        System.out.println("\n END-- \n\n");

        // Find the department who is having maximum number of students
        System.out.println("maxNoOfStudents::");
        list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
                .entrySet()
                .stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);
        System.out.println("\n END-- \n\n");

        // 11. Find the Students who stays in Delhi and sort them by their names
        System.out.println("Find the Students who stays in Delhi and sort them by their names::");
        list.stream()
                .filter(s -> s.getCity().equals("Delhi"))
                .sorted(Comparator.comparing(Student::getFirstName))
                .toList().forEach(System.out::println);
        System.out.println("\n END-- \n\n");

        //12. Find the average rank in all departments
        System.out.println("Find the average rank in all departments::");
        list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)))
                .forEach((k, v) -> System.out.println("Dept: " + k + " | avg rank: " + v));
        System.out.println("\n END-- \n\n");


        //13. Find the highest rank in each department
        System.out.println("Find the highest rank in each department::");
        list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName,
                        Collectors.maxBy(Comparator.comparing(Student::getRank))))
                .forEach((k, v) -> System.out.println("Dept: " + k + " | high rank stu: " + v.get()));

        System.out.println("\n END-- \n\n");

        //14. Find the list of students and sort them by their rank
        System.out.println("Find the list of students and sort them by their rank::");
        list.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .toList().forEach(System.out::println);

        System.out.println("\n END-- \n\n");

        //15. Find the student who has second rank
        System.out.println("Find the student who has second rank::");
        Optional<Student> first = list.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .skip(1).findFirst();
        System.out.println(first.get());

        System.out.println("\n END-- \n\n");
    }
}
