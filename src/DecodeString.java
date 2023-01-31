import java.math.BigInteger;
import java.util.Scanner;


// 暗号文（数値）を平文（数値）に、さらに平文（文字列）に変換するクラス
public class DecodeString {
    long N;
    long d;
    BigInteger c;                 // 暗号文
    BigInteger m;                 // 暗号文を復号した平文(数値)
    String mAfter;                // 平文(数値)を変換した平文(文字列)
    Scanner scan = new Scanner(System.in);

    // コンストラクタ
    public DecodeString(long N, long d, BigInteger c){
        this.N = N;
        this.d = d;
        this.c = c;

        // 暗号文(数値)を平文(数値)に復号
        this.m = decodeC();

        // 平文(数値)を平文(文字列)に変換
        this.mAfter = mToString(m);
    }


    // 暗号文(数値)を平文(数値)に復号するメソッド
    public BigInteger decodeC(){
        long cLong = c.longValue();   // 暗号文(BigInteger型)を暗号文(long型)に変換
        c.longValueExact();           // 変換が成功したか判断
        long a;                       // 復号で繰り返し使用する cLong % N を格納
        long mLong;                   // 復号した結果の平文(数値)


        System.out.printf("暗号文cをN(=%d),d(=%d)を用いて復号します ▼",N ,d );
        scan.nextLine();
        System.out.println();
        System.out.println("しばらくお待ちください。(dが大きいと時間がかかることがあります)");   // 文字数が多い、dが大きいと時間がとてもかかる
        System.out.println();

        // cをNで割った余りを計算する
        a = cLong % N;
        mLong = a;

        // 余りをe乗していく
        for(long i=1; i<d; i++){
            mLong = mLong*a;
            // 計算結果がNよりも大きくなったら、また余りを計算する
            if(mLong > N )
                mLong = mLong % N;
        }

        // 結果表示
        System.out.print("復号完了！！ ▼");
        scan.nextLine();
        System.out.print("平文（数値）： m = " + mLong + " ▼");
        scan.nextLine();
        System.out.println();
        System.out.println();

        m = BigInteger.valueOf(mLong);
        return m;
    }


    // 数値になっている平文を文字列に変換し直す
    public String mToString(BigInteger mBigInt){
        String mString;              // 平文(数値)を変換した平文(文字列)


        System.out.print("mを文字列に変換し直します ▼");
        scan.nextLine();
        System.out.println();

        // 復号（英語、記号のみ）
        StringBuilder sb = new StringBuilder();
        while(mBigInt.compareTo(BigInteger.ZERO) > 0) {
            int rem = mBigInt.mod(BigInteger.valueOf(256)).shortValue();
            sb.append((char) rem);
            mBigInt = mBigInt.divide(BigInteger.valueOf(256));
        }
        mString = sb.reverse().toString();


        // 結果表示
        System.out.print("復号完了！！ ▼");
        scan.nextLine();
        System.out.print("　　平文　　： m = " + mString + " ▼");
        scan.nextLine();
        System.out.println();
        System.out.println();

        return mString;
    }
}
