package hal.u22.works.team.a.web.tools;

public class Tools {

    /**
     * 数値をカンマ区切りの数値にし、Stringで返す
     * @param num
     * @return
     */
    public static String intToStringCom(int num) {
        String StrNum = String.valueOf(num);
        StringBuffer sb = new StringBuffer(StrNum);
        StrNum = sb.reverse().toString();
        String CommNum ="";
        for(int i = 1; StrNum.length()>= i ; i++) {
            CommNum += StrNum.charAt(i-1);

            if(i%3 ==0 && !(StrNum.length() < i+1)) {
                CommNum +=",";
            }
        }
        sb= new StringBuffer(CommNum);
        CommNum = sb.reverse().toString();
        return CommNum;
    }


    /**
     * 数字をカンマ区切りの数値にし、Stringで返す
     * @param num
     * @return
     */
    public static String StrNumToStringCom(String num) {
        StringBuffer sb = new StringBuffer(num);
        String StrNum = sb.reverse().toString();
        String CommNum ="";
        for(int i = 1; StrNum.length()>= i ; i++) {
            CommNum += StrNum.charAt(i-1);

            if(i%3 ==0 &&!(StrNum.length() < i+1 )) {
                CommNum +=",";
            }
        }
        sb= new StringBuffer(CommNum);
        CommNum = sb.reverse().toString();
        return CommNum;
    }

    /**
     * カンマ区切りされた数値をカンマなしにStringで返す
     * @param ComNum
     * @return
     */
    public static String StringComToString(String ComNum) {
        String StrNum = "";
        for(int i = 0; ComNum.length() > i ; i++) {
            if(!",".equals(String.valueOf(ComNum.charAt(i)))) {
                StrNum += ComNum.charAt(i);
            }
        }

        return StrNum;

    }

}

