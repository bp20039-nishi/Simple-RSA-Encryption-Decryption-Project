import java.util.Scanner;

// 参考にしたサイト：https://docs.oracle.com/javase/jp/8/docs/api/java/math/BigInteger.html

/*--------------------------------------------
このプログラムでできること

文字列と数値のRSA暗号方式による暗号化と復号化。
また、それらの成功判定。

--------------------------------------------*/




// メインクラス
public class Main {

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int mIs = 0;


        System.out.print(
                "/*****************\n" +
                "　　　　RSA暗号　　　　\n" +
                "******************/\n\n\n");


        System.out.print("開始します ▼　（以下 '▼' = 改行で次の処理へ）");
        scan.nextLine();
        System.out.println();


        // 素数を生成(素数の大きさ27ビットがＮが大きすぎない限界値)
        GeneratePrimeNumber genPrim = new GeneratePrimeNumber(27);


        // 生成した2つの素数からl,eを生成
        GenerateE genE = new GenerateE(genPrim.p, genPrim.q);


        // l,eからユークリッドの互除法を利用してdを生成
        GenerateD genD = new GenerateD(genE.l, genE.e);


        // 暗号化する平文の種類を選択
        while(true) {
            System.out.println("暗号化したい文章の種類を選択してください");
            System.out.printf("１：文字（英数字のみ3文字まで）　　　２：数値（0~%d）\n", genPrim.N);
            mIs = scan.nextInt();

            if( mIs == 1 || mIs == 2 ) break;
        }


        // 文字mを暗号化 & 復号化 & 結果発表
        if( mIs == 1) {
            // 暗号化
            EncodeString encode = new EncodeString(genPrim.N, genE.e);
            // 復号化
            DecodeString decode = new DecodeString(genPrim.N, genD.d, encode.c);
            // 結果発表
            Result result = new Result(encode,  decode);
        }
        // 数値mを暗号化 & 復号化 & 結果発表
        else {
            // 暗号化
            EncodeNum encode = new EncodeNum(genPrim.N, genD.e);
            // 復号化
            DecodeNum decode = new DecodeNum(genPrim.N, genD.d, encode.c);
            // 結果発表
            Result result = new Result(encode,  decode);
        }
    }
}
