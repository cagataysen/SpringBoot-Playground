import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGenerator {
        public List<Integer> generatePrimes(int limit) {
            List<Integer> primes = new ArrayList<>();
            for (int i = 2; i <= limit; i++) {
                if (isPrime(i)) {
                    primes.add(i);
                }
            }
            return primes;
        }


        private boolean isPrime(int number) {
            if (number <= 1) {
                return false;
            }
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }




    /*
    * is there any out of limit prime number in the primes
    * is there any not prime number
    * is there 1
    * */

/*
* if limit is equal or higher than 2, it should contain 2
* if the limit is the prime number, is it on the list
* other prime numbers
*
* */

    public void checkOutOfLimitPrimeNumberInPrimes(){
        PrimeNumberGenerator primeNumberGenerator;
        for(int i: primes){
            if()
        }
        boolean two = false;
        if(limit >= 2){
            two = true;
        }
        if(two == true){
            assertEquals(, primeNumberGenerator.generatePrimes(5));
        }
        
    }
