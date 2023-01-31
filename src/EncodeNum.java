import java.util.Scanner;


// 平文（数値）を暗号化するクラス
public class EncodeNum {
    long N;
    long e;
    long mBefore;                  // 暗号化前の平文m
    long c;                        // 平文を暗号化した結果。暗号文
    Scanner scan = new Scanner(System.in);

    // コンストラクタ
    public  EncodeNum(long N, long e){
        this.N = N;
        this.e = e;

        // 平文mをキーボードから取得
        while(true){
            this.mBefore = getM();
            if ( mBefore < N ){
                break;
            }
            System.out.print("数値が大きすぎます(N < m)。文の桁数を減らしてください ▼");
            scan.nextLine();
        }

        // mを暗号化する
        this.c = encodeM(this.N, this.e, this.mBefore);
    }


    // キーボードから平文を取得
    public long getM() {
        long m = -1;         // 平文


        // 平文をキーボードから入力
        while( m == -1 ) {

            System.out.println();
            System.out.print("暗号化したい数値(平文：m)を入力してください　->   ");
            m = scan.nextLong();
        }

        return m;
    }


    // 平文mを暗号化し、暗号文cを生成する。(m^eを先に計算せず、分けて計算する)
    public long encodeM(long N, long e, long m){
        long a;
        long c = 0;                   // 暗号文

        System.out.printf("平文mからN(=%d)とe(=%d)を用いて暗号文cを生成します ▼",N ,e);
        scan.nextLine();
        System.out.println();
        System.out.println();
        System.out.println("しばらくお待ちください。。。。");
        System.out.println();

        // mをNで割った余りを計算する
        a = m % N;
        c = a;


        // 余りをe乗していく
        for(int i=1; i < e ; i++){
            c =  c * a;
            // 計算結果がNよりも大きくなったら、また余りを計算する
            if( c > N ){
                c = c % N;
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

