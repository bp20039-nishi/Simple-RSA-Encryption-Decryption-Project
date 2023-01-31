import java.util.Scanner;


// 暗号文(数値)を平文(数値)に復号するクラス
public class DecodeNum {
    long N;
    long d;
    long c;
    long mAfter;                  // 暗号文を復号した平文(数値)
    Scanner scan = new Scanner(System.in);

    // コンストラクタ
    public DecodeNum(long N, long d, long c){
        this.N = N;
        this.d = d;
        this. c = c;

        this.mAfter = decodeC();

    }

    // 暗号文(数値)を平文(数値)に復号する
    public long decodeC(){
        long a;                 // 復号で繰り返し使用する cLong % N を格納


        System.out.printf("暗号文cをN(=%d),d(=%d)を用いて復号します ▼",N ,d );
        scan.nextLine();
        System.out.println("\nしばらくお待ちください。(dが大きいと時間がかかることがあります)");
        System.out.println();

        // cをNで割った余りを計算する
        a = c % N;
        mAfter = a;

        // 余りをe乗していく
        for(long i=1; i<d; i++){
            mAfter = mAfter * a;
            // 計算結果がNよりも大きくなったら、また余りを計算する
            if( mAfter > N )
                mAfter = mAfter % N;
        }

        // 結果表示
        System.out.print("復号完了！！ ▼");
        scan.nextLine();
        System.out.print("　　平文　　： m = " + mAfter + " ▼");
        scan.nextLine();

        System.out.println();
        System.out.println();

        return mAfter;
    }
}

