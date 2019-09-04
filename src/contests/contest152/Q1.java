package contests.contest152;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,4,6,7,9,3,10,9,5,6};
        //int[] arr = new int[]{1,1,2,3};
        //List<Integer> list = findDuplicates(arr);
//        List<Integer> list = new ArrayList<>();
//        for(int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        System.out.println(numPrimeArrangements(2));
        System.out.println(numPrimeArrangements(3));
        System.out.println(numPrimeArrangements(5));

    }


    public static int numPrimeArrangements(int n) {

        int noPrimes = 0;

        for(int number = 2; number<=n; number++){
            //print prime numbers only
            if(isPrime(number)){
                noPrimes++;
            }
        }

        BigInteger count = new BigInteger("1");

        for(int i = 1; i <= noPrimes; i++) {
            count = count.multiply(BigInteger.valueOf(i));
        }


        int remNumbers = n - noPrimes;
        BigInteger restNumbersCount = new BigInteger("1");
        for(int i = 1; i <= remNumbers; i++) {
            restNumbersCount = restNumbersCount.multiply(BigInteger.valueOf(i));
        }


        count = count.multiply(restNumbersCount);
        count = count.mod(new BigInteger("1000000007"));

        return count.intValue();
    }

    public static boolean isPrime(int number){
        for(int i=2; i<number; i++){
            if(number%i == 0){
                return false; //number is divisible so its not prime
            }
        }
        return true; //number is prime now
    }

}
