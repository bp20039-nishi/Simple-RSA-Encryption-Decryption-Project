// ユークリッドの互除法で生じる式の係数を保存するクラス
public class EuclidTerm {
    /*-----------------------------------------------
    ユークリッドの互除法で生じる式の係数を以下のように保存する
         l = e * afterTimes + afterPlus
    ---------------------------------------------- */
    long e;
    long l;
    long afterTimes;
    long afterPlus;

    public EuclidTerm(long l, long e, long afterTimes, long afterPlus){
        this.l = l;
        this.e = e;
        this.afterTimes = afterTimes;
        this.afterPlus = afterPlus;

    }
}
