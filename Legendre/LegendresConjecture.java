package Legendre;

import java.util.Scanner;

// ルジャンドル予想を計算する
public class LegendresConjecture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long maxN = (long)Math.sqrt(Long.MAX_VALUE)-1;

        while (true) {
            System.out.print("nを入力してください (1<=n<="+maxN+"):");
            long n = scanner.nextLong();
            //オーバーフロー対策
            if (n < 1 || n > maxN) {
                System.out.println("入力が範囲外です。1から" + maxN + "の間で入力してください");
                continue;
            }

            boolean primeFound = false;
            for (long i = n * n; i < (n + 1) * (n + 1); i++) {
                if (isPrime(i)) {
                    primeFound = true;
                    break;
                }
            }

            if (primeFound) {
                System.out.println("残念、" + n + "(n)と" + (n * n) + "(n^2)の間に素数が存在します");
            } else {
                System.out.println("すごい！ n = " + n + "はルジャンドル予想の反例です！おめでとう！！");
            }
        }
    }

    public static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}