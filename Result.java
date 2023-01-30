import java.util.Scanner;


// 結果発表を行うクラス
public class Result {
    Scanner scan = new Scanner(System.in);

    // 平文が文字列の場合
    public Result(EncodeString encode, DecodeString decode){

        System.out.print(
                "/*****************\n" +
                " !!!!!結果発表!!!!!\n" +
                "*****************/ ▼");
        scan.nextLine();
        System.out.println();


        // 暗号化前の平文を表示を表示
        System.out.print("　　原文　：　" + encode.mBefore + " ▼");
        scan.nextLine();
        System.out.println();

        // 複合した結果生成された平文を表示
        System.out.print("　復号後　：　" + decode.mAfter + " ▼");
        scan.nextLine();
        System.out.println();

        System.out.print("よって、、、、、、、、 ▼");
        scan.nextLine();
        System.out.println();


        // 2つを比較
        if (encode.mBefore.equals(decode.mAfter)) {
            System.out.print(
                    "＿人人人人人人人人人＿\n" +
                    "＞ 　複合成功!!!　 ＜\n" +
                    "￣Y^Y^Y^Y^Y^Y^Y^Y￣ ▼");
            scan.nextLine();

        } else {
            System.out.print("復号失敗。。。 ▼");
            scan.nextLine();
        }

        System.out.println();
        System.out.println("お疲れさまでした！");
    }



    // 平文が数値の場合
    public Result(EncodeNum encode, DecodeNum decode) {

        System.out.print(
                "/*****************\n" +
                " !!!!!結果発表!!!!!\n" +
                "*****************/ ▼");
        scan.nextLine();
        System.out.println();

        System.out.print("　　原文　　：　" + encode.mBefore + " ▼");
        scan.nextLine();
        System.out.println();

        System.out.print("　　復号後　：　" + decode.mAfter + " ▼");
        scan.nextLine();
        System.out.println();

        System.out.print("よって、、、、、、、、 ▼");
        scan.nextLine();
        System.out.println();

        if ( encode.mBefore == decode.mAfter ) {
            System.out.print("＿人人人人人人人人人＿\n" +
                    "＞ 　複合成功!!!　 ＜\n" +
                    "￣Y^Y^Y^Y^Y^Y^Y^Y￣ ▼");
            scan.nextLine();

        } else {
            System.out.print("復号失敗。。。 ▼");
            scan.nextLine();
        }

        System.out.println();
        System.out.println("お疲れさまでした！");
    }
}
