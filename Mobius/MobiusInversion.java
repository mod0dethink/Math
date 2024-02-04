import java.util.Scanner;

public class MobiusInversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n: "); 
        int n = scanner.nextInt();
        System.out.println("メビウス関数の返り値: " + mobius(n)); 
        
        System.out.println("1から" + n + "までの整数における互いに素な数のペアの数: " + calculateCoprimePairs(n));
    }

    private static int mobius(int n) {
        if (n == 1) return 1;
        int primeCount = 0;
        if (n % 2 == 0) {
            primeCount++;
            n /= 2;
            if (n % 2 == 0) return 0; 
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                primeCount++;
                n /= i;
                if (n % i == 0) return 0; 
            }
        }
        if (n > 2) primeCount++; 
        return (primeCount % 2 == 0) ? 1 : -1;
    }
    
    private static long calculateCoprimePairs(int n) {
        long count = 0;
        for (int i = 1; i <= n; i++) {
            count += mobius(i) * (n / i) * (n / i);
        }
        return (count - 1) / 2; 
    }
}
