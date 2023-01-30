import java.util.ArrayList;
import java.util.Scanner;



// eとlからd（秘密鍵）を生成するクラス
public class GenerateD {
    long l;
    long e;
    long d;                         // edをℓで割ったときの余りが1となるような正の整数（秘密鍵）
    Scanner scan = new Scanner(System.in);


    // コンストラクタ
    public GenerateD(long l, long e) {
        this.l = l;
        this.e = e;

        euclid(l, e);
    }

    // ユークリッドの互除法を行い、dを見つけるメソッド
    public long euclid(long l, long e){
        int i;
        long afterTimes;
        long afterPlus;
        ArrayList<EuclidTerm> termList = new ArrayList<>();  // 互除法で生じたの式の項の情報を保存するリスト
        long d;


        System.out.printf("lとeに関してユークリッドの互除法を行います ▼");
        scan.nextLine();
        System.out.print("結果");


        // ユークリッドの互除法を行い、それぞれの式の項をEuclidTermクラスに保存
        while (true){
            // ユークリッドの互除法の終了判定
            if( l % e == 0 ) break;
            // 余りを計算
            afterPlus = l % e;
            // 割った数を計算
            afterTimes = l / e;
            // 余り、割った数を保存
            EuclidTerm term = new EuclidTerm(l, e, afterTimes, afterPlus);
            termList.add(term);

            // 式を画面表示
            System.out.print( "\n" + term.l + " = " + term.e + " * " + term.afterTimes + " + " + term.afterPlus );

            // 次の式へ移る準備
            l = e;
            e = term.afterPlus;
        }

        System.out.printf(" ▼");
        scan.nextLine();
        System.out.println();


        System.out.printf("ユークリッドの互除法の結果より、edをℓで割ったときの余りが1となるような正の整数d（秘密鍵）を計算します ▼");
        scan.nextLine();
        System.out.print("結果");


        // ユークリッドの互除法によってできた式からdを求める
        // 一番下（最後に作成した式）から考えていく
        for(i=termList.size()-1; i>0; i--) {
            // 一つ上の式の商にあたる部分の代入を行う
            termList.get(i - 1).afterTimes =
                    termList.get(i - 1).afterTimes * termList.get(i).afterTimes;
            termList.get(i - 1).l =
                    termList.get(i - 1).l * termList.get(i).afterTimes;


            // 一つ上の式で、eに当たる数でくくった場合、余りが1となるか、-1となるかで場合分け
            // あまり1の時
            if (termList.get(i).e * termList.get(i).afterTimes % termList.get(i - 1).e == 1) {
                // くくった結果のeの係数
                termList.get(i - 1).afterTimes += termList.get(i).e * termList.get(i).afterTimes / termList.get(i - 1).e;
                // くくった結果の余り
                termList.get(i - 1).afterPlus = 1;
            }
            // あまり-1の時
            else {
                termList.get(i - 1).afterTimes += termList.get(i).e * termList.get(i).afterTimes / termList.get(i - 1).e + 1;
                termList.get(i - 1).afterPlus = -1;
            }


            // 式表示
            System.out.print( "\n" + termList.get(i-1).l + " = " + termList.get(i-1).e + " * " + termList.get(i-1).afterTimes +
                    " + " + termList.get(i-1).afterPlus);
        }
        System.out.print(" ▼ ");
        scan.nextLine();

        // 最後の式で、余りが-1の場合（= ユークリッドの互除法でできた式の数が奇数個の場合）、さらに式変形を行う。
        if(termList.size() % 2 == 1){
            System.out.printf("「+1」よりさらに式変形して。。。 ▼ ");
            scan.nextLine();

            termList.get(0).afterTimes = termList.get(0).afterTimes * (termList.get(0).e - 1) + 1;
        }


        // dが判明
        d = termList.get(0).afterTimes;
        this.d = d;
        System.out.printf("　　秘密鍵　： d = " + d + " ▼ ");
        scan.nextLine();
        System.out.println();
        System.out.println();


        System.out.print(
                "/************************\n" +
                "   暗号化の準備が整いました　 \n" +
                "************************/ ▼ ");
        scan.nextLine();
        System.out.println("\n");

        return d;
    }

}
