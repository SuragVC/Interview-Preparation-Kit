import javax.swing.text.html.HTMLDocument;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class StreamWithList {
    public static List<Integer> numbers = Arrays.asList(32,54,87,100,2,2,3526,45,878,90,752,44,9,2,78,36,225,4,7,65,82,166,166,897,455,2,4,78,44,66);
    public static void main(String[] args) {
        //Q. Find the count of elements in numbers
        long count=numbers.stream().count();
        System.out.println(count);
        //Q. Find the minimum of the list
        OptionalInt minimum=numbers.stream().mapToInt(Integer::intValue).min();
        System.out.println(minimum.getAsInt());
        //Q. Find the maximum from the list
        OptionalInt maximum=numbers.stream().mapToInt(Integer::intValue).max();
        System.out.println(maximum.getAsInt());
        //Q. Find the odd numbers from the list
        List<Integer>oddNumbers=numbers.stream().filter(n->n%2!=0).collect(Collectors.toList());
        System.out.println(oddNumbers);
        //Q. Find the even numbers from the list
        List<Integer>evenNumbers=numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
        System.out.println(evenNumbers);
        //Q. Find the numbers which are divisible by 5
        List<Integer>divisibleByFive=numbers.stream().filter(n->n%5==0).collect(Collectors.toList());
        System.out.println(divisibleByFive);
        //Q. Find the sum of the numbers in the list
        Double sum=numbers.stream().mapToDouble(Integer::intValue).sum();
        System.out.println(sum);
        //Q. Multiply 2 with all numbers in the list
        List<Integer>multipliedByTwo=numbers.stream().map(n->n*2).collect(Collectors.toList());
        System.out.println(multipliedByTwo);
        //Q. Divide 3 with all numbers in the list
        List<Integer>dividedByThree=numbers.stream().map(n->n/3).collect(Collectors.toList());
        System.out.println(dividedByThree);
        //Q. Find the distinct elements of the list
        List<Integer>distinctElements=numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctElements);
        //Q. Print the first 5 elements of the list
        numbers.stream().limit(5).forEach(System.out::println);
        //Q. Collect first 10 elements of the list
        List<Integer>firstTen=numbers.stream().limit(10).collect(Collectors.toList());
        System.out.println(firstTen);
        //Q. Find the first 5 even elements
        List<Integer>firstFiveEvenNumbers=numbers.stream().filter(n->n%2==0).limit(5).collect(Collectors.toList());
        System.out.println(firstFiveEvenNumbers);
        //Q. Find the first 5 odd numbers sum
        Double sumOfFiveOddNumbers= numbers.stream().filter(n->n%2!=0).limit(5).mapToDouble(Integer::intValue).sum();
        System.out.println(sumOfFiveOddNumbers);
        //Q. Find the sum of first 5 even numbers multiplied by its self
        Double firstFiveEvenNumbersDoubledSum=numbers.stream().filter(n->n%2==0).map(n->n*n).limit(5).mapToDouble(Integer::intValue).sum();
        System.out.println(firstFiveEvenNumbersDoubledSum);
    }
}
