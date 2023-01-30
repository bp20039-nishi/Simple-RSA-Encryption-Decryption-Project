import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


// 2つの素数p,qからeを生成するクラス
public class GenerateE {
    long p;                         // 素数p
    long q;                         // 素数q
    long l;                         // (p-1)(q-1)
    long e;                         // lと互いに素な正の整数
    ArrayList<Integer> factor;      // lの素因数を格納
    Scanner scan = new Scanner(System.in);

    // コンストラクタ
    public GenerateE(long p, long q){
        this.p = p;
        this.q = q;

        // lを計算、lの素因数を求める
        factor = findFactor(calcL(p,q));
        // lの因数と一致しない正の整数 e を求める
        this.e = makeE(this.l, factor);
    }


    // p, qからlを計算するメソッド
    public long calcL(long p, long q) {

        // lの計算、画面表示
        System.out.print("l (= (p-1)*(q-1)) を計算します ▼");
        scan.nextLine();

        this.l = ( p-1 )*( q-1 );


        System.out.print("l = " + l + " ▼");
        scan.nextLine();
        System.out.println();

        return l;
    }


    // 引数lを素因数分解、素因数をリストに格納して返すメソッド
    public ArrayList<Integer> findFactor(long l){
        int i = 2;
        ArrayList<Integer> factor = new ArrayList<>();


        System.out.print("lの素因数を探します ▼");
        scan.nextLine();

        // lの因数を2から順に探す
        while(true) {
            // i(2~)で割り切れるならば
            if ( l % i == 0 ) {
                // iがまだ因数として登録されていなければリストに追加
                if (!factor.contains(i)) factor.add(i);
                // lをiで割る
                l = l / i;
                // 探索終了時
                if( l == 1 ) break;
                // iを2に戻して（下のi++を含めて）探索を続ける
                else i = 1;
            }
            i++;
        }

        System.out.print("結果");
        // 素因数を画面表示
        for(i=0; i < factor.size(); i++){
            System.out.print("\n素因数" + i + "つ目：" + factor.get(i));
        }
        System.out.print(" ▼");
        scan.nextLine();
        System.out.println();

        return factor;
    }


    // 渡された素因数に対して、互に素な正の整数eを作成するメソッド
    public long makeE(long l, ArrayList<Integer> factor){
        int i;
        long e;
        Random r = new Random();


        System.out.print("lと互いに素な正の整数eを生成します ▼");
        scan.nextLine();

        while(true){
            // 仮の整数e(2<e<l)を作成
            while(true) {
                e = r.nextInt((100) + 2);
                if (l >= e) break;
            }

            // 互いに素か判定
            for(i=0; i<factor.size(); i++)
                // factorにeの因数が含まれていた場合、eを再生成
                if( e % factor.get(i) == 0) break;

            // factorに含まれるすべての数を因数に持たなかった場合、eをこの数に決定して終了
            if( i == factor.size() ) break;
        }

        // eを画面表示
        System.out.print("　公開鍵２　： e = " + e + " ▼");
        scan.nextLine();
        System.out.println();
        System.out.println();

        return e;
    }
}
