package EulerPhi;

import java.util.Scanner; 

public class EulerPhi {
    
    // オイラーのファイ関数を計算するメソッド
    public static int phi(int n) {
        int result = n; // nと互いに素な数の個数を初期化
        
        for (int p = 2; p * p <= n; ++p) {
            if (n % p == 0) {
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }
        
        if (n > 1) {
            result -= result / n;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("nを入力してください: ");
            int n = scanner.nextInt();
            System.out.println("phi(" + n + ") = " + phi(n));
            System.out.println();   
        }
    }
}