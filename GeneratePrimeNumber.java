import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;


// 素数を生成するクラス
public class GeneratePrimeNumber {
    long p;                                 // 素数p
    long q;                                 // 素数q
    long N;                                 // p * q の答え
    Scanner scan = new Scanner(System.in);


    // 2つの素数を生成する
    public GeneratePrimeNumber(int primeLength){
        Random r = new Random();


        System.out.print("2つの素数　p, q を生成します ▼ ");
        scan.nextLine();

        // 異なる素数が生成できるまで繰り替えす
        while(true){
            // 素数pを生成
            p = (BigInteger.probablePrime(primeLength >> 1, r)).longValue();
            // 素数qを生成
            q = (BigInteger.probablePrime(primeLength >> 1, r)).longValue();

            // pとqどちらも正でかつ p=q でなければ終了
            if( p != q && p>0 && q>0 ) break;
        }
        // p, q を画面表示
        System.out.print("p = " + p + "\n" +
                         "q = " + q + " ▼");
        scan.nextLine();
        System.out.println();


        // Nを計算
        System.out.print("N (= p*q) を計算します ▼");
        scan.nextLine();

        this.N = p * q;

        System.out.print("　公開鍵１　： N = " + N + " ▼");
        scan.nextLine();
        System.out.println();
        System.out.println();
    }
}
