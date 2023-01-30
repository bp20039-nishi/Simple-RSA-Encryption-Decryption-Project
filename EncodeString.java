import java.math.BigInteger;
import java.util.Scanner;


// 平文(文字列)を数値化し、暗号化するクラス
public class EncodeString {
    long N;
    long e;
    String mBefore;                 // 暗号化前の平文
    BigInteger m;                   // 平文を数値に変換
    BigInteger c;                   // 数値変換後の平文を暗号化した結果。暗号文
    Scanner scan = new Scanner(System.in);


    // コンストラクタ
    public  EncodeString(long N, long e){
        this.N = N;
        this.e = e;

        // 平文mをキーボードから取得したのち、数値に変換
        while(true){
            this.m = mToBigInt( getM() );
            if (m.compareTo(BigInteger.valueOf(N))<0){
                break;
            }
            System.out.print("数値が大きすぎます(N > m)。文の桁数を減らしてください ▼");
            scan.nextLine();
        }

        // mを暗号化する
        this.c = encodeM(this.N, this.e, this.m);
    }


    // キーボードから文字列で平文を取得するメゾット
    public String getM() {
        String m = "";         // 平文


        // 平文をキーボードから入力
        while( m.equals("")) {
            System.out.println();
            System.out.printf("暗号化したい文(平文：m)を入力してください　->   ");
            m = scan.nextLine();
        }

        // 入力内容を文字列に保存
        this.mBefore = m;

        return m;
    }


    // 引数の文字列をBigInteger型の数値に変換して返すメソッド
    public BigInteger mToBigInt(String m){
        BigInteger mBigInt = BigInteger.valueOf(0);    // 平文を数値に変換したもの


        System.out.printf("\nmを数値に変換します ▼");
        scan.nextLine();


        // String型からBigInteger型に、256進数を利用し変換
        for(int i=0; i<m.length(); i++){
            mBigInt = mBigInt.multiply(BigInteger.valueOf(256));
            mBigInt = mBigInt.add(BigInteger.valueOf(m.charAt(i)));
        }

        // 結果表示
        System.out.println("　　平文　　： m = " + m);
        System.out.print("　数値変換後： m = " + mBigInt + " ▼");
        scan.nextLine();
        System.out.println();
        return mBigInt;
    }


    // 平文mを暗号化し、暗号文cを生成するメソッド(m^eを先に計算せず、分けて計算する)
    public BigInteger encodeM(long N, long e, BigInteger m){
        BigInteger c;                   // 暗号文

        System.out.printf("平文mからN(=%d)とe(=%d)を用いて暗号文cを生成します ▼",N ,e);
        scan.nextLine();
        System.out.println("\nしばらくお待ちください。。。。");
        System.out.println();
        // mをNで割った余りを計算する
        c = m.mod(BigInteger.valueOf(N));


        // 余りをe乗していく
        for(int i=1; i < e ; i++){
            c = c.multiply(m.mod(BigInteger.valueOf(N)));
            // 計算結果がNよりも大きくなったら、また余りを計算する
            if(c.compareTo(BigInteger.valueOf(N)) > 0 ){
                c = c.mod(BigInteger.valueOf(N));
            }
        }

        // 結果表示
        System.out.print("暗号化完了！！ ▼");
        scan.nextLine();
        System.out.print("　　暗号文　： c = " + c + " ▼");
        scan.nextLine();
        System.out.println();
        System.out.println();

        return c;
    }

}
