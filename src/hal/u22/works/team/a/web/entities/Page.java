package hal.u22.works.team.a.web.entities;

public class Page {

    /**
     * ページ数
     */
    private int maxpage;
    /**
     * マージンをどれだけ入れるか
     */
    private int margin;
    /**
     * マージンを入れるか判定
     */
    private boolean margin_flg;

    /**
     * 次表示するページ
     */
    private int i_page;
    /**
     * 前へボタン
     */
    private boolean back_flg;
    /**
     * 次へボタン
     */
    private boolean next_flg;
    /**
     * 1..ボタン
     */
    private boolean min_flg;
    /**
     * ..最大ボタン
     */
    private boolean max_flg;
    /**
     * 現在ページリンクなし判定
     */
    private String one_flg;
    /**
     * 現在ページリンクなし判定
     */
    private String two_flg;
    /**
     * 現在ページリンクなし判定
     */
    private String three_flg;
    /**
     * 現在ページリンクなし判定
     */
    private String four_flg;
    /**
     * 現在ページリンクなし判定
     */
    private String five_flg;
    /**
     * 何件から何件かの初めの件数
     */
    private int first_recode;
    /**
     * 1個目の表示ページ
     */
    private int one;
    /**
     * 2個目の表示ページ
     */
    private int two;
    /**
     * 3個目の表示ページ
     */
    private int three;
    /**
     * 4個目の表示ページ
     */
    private int four;
    /**
     * 5個目の表示ページ
     */
    private int five;
    private int max;
    private int last;

    public Page() {
        this.max = 0;
        this.last = 10;
        this.maxpage = 0;
        this.margin = 0;

        this.margin_flg = false;
        this.back_flg = false;
        this.next_flg = true;
        this.min_flg = false;
        this.max_flg = true;
        this.first_recode = 1;

        this.one = 0;
        this.two = 0;
        this.three = 0;
        this.four = 0;
        this.five = 0;
        this.one_flg = "";
        this.two_flg = "";
        this.three_flg = "";
        this.four_flg = "";
        this.five_flg = "";
    }

    /**
     * 最大件数からページ数を出す
     */
    public void setPageNum(int max) {
        this.max = max;
        this.maxpage = max / 10;
        this.margin = (10 - (max % 10)) * 49 + 16;

        if (margin != 0) {
            this.maxpage++;

        }
        if (this.maxpage < 6) {
            this.max_flg = false;
        }
        if (this.maxpage == 1) {
            this.next_flg = false;
        }

        if (maxpage < 6) {
            this.min_flg = false;
        }
        if (maxpage < 6) {
            this.max_flg = false;
        }

    }

    /**
     * 次のページを決める
     */
    public void setNowPage(String page) {
        this.i_page = Integer.parseInt(page);

        //ボタン有無処理
        if (this.i_page == 1) {
            this.back_flg = false;
        } else {
            this.back_flg = true;
        }

        if (this.i_page == this.maxpage) {
            this.next_flg = false;
            this.margin_flg = true;
            this.last = max % 10;
        } else {
            this.next_flg = true;
            this.margin_flg = false;
        }

        if (this.i_page < 4 || maxpage < 6) {
            this.min_flg = false;
        } else {
            this.min_flg = true;
        }

        if (this.maxpage - 3 < this.i_page || maxpage < 6) {
            this.max_flg = false;
        } else {
            this.max_flg = true;
        }

        //レコード検索用
        this.first_recode = (this.i_page - 1) * 10;

        //表示ページセット
        if (i_page == 1) {
            this.one = this.i_page;
            this.two = this.i_page + 1;
            this.three = this.i_page + 2;
            this.four = this.i_page + 3;
            this.five = this.i_page + 4;

            this.one_flg = "class= \"page-item active\" style=\"pointer-events: none;\"";
            this.two_flg = "class=\"page-item\"";
            this.three_flg = "class=\"page-item\"";
            this.four_flg = "class=\"page-item\"";
            this.five_flg = "class=\"page-item\"";
        } else if (this.i_page == 2) {
            this.one = this.i_page - 1;
            this.two = this.i_page;
            this.three = this.i_page + 1;
            this.four = this.i_page + 2;
            this.five = this.i_page + 3;

            this.one_flg = "class=\"page-item\"";
            this.two_flg = "class= \"page-item active\" style=\"pointer-events: none;\"";
            this.three_flg = "class=\"page-item\"";
            this.four_flg = "class=\"page-item\"";
            this.five_flg = "class=\"page-item\"";
        } else if (maxpage == 3 && this.i_page == maxpage || maxpage == 4 && this.i_page == maxpage - 1) {
            this.one = this.i_page - 2;
            this.two = this.i_page - 1;
            this.three = this.i_page;
            this.four = this.i_page + 1;
            this.five = this.i_page + 2;
            this.one_flg = "class=\"page-item\"";
            this.two_flg = "class=\"page-item\"";
            this.three_flg = "class= \"page-item active\" style=\"pointer-events: none;\"";
            this.four_flg = "class=\"page-item\"";
            this.five_flg = "class=\"page-item\"";

        } else if (this.i_page == maxpage - 1 && maxpage != 4 || maxpage == 4 && this.i_page == maxpage) {
            this.one = this.i_page - 3;
            this.two = this.i_page - 2;
            this.three = this.i_page - 1;
            this.four = this.i_page;
            this.five = this.i_page + 1;

            this.one_flg = "class=\"page-item\"";
            this.two_flg = "class=\"page-item\"";
            this.three_flg = "class=\"page-item\"";
            this.four_flg = "class= \"page-item active\" style=\"pointer-events: none;\"";
            this.five_flg = "class=\"page-item\"";
        } else if (this.i_page == maxpage && maxpage != 3) {
            this.one = this.i_page - 4;
            this.two = this.i_page - 3;
            this.three = this.i_page - 2;
            this.four = this.i_page - 1;
            this.five = this.i_page;

            this.one_flg = "class=\"page-item\"";
            this.two_flg = "class=\"page-item\"";
            this.three_flg = "class=\"page-item\"";
            this.four_flg = "class=\"page-item\"";
            this.five_flg = "class= \"page-item active\" style=\"pointer-events: none;\"";
        } else {
            this.one = this.i_page - 2;
            this.two = this.i_page - 1;
            this.three = this.i_page;
            this.four = this.i_page + 1;
            this.five = this.i_page + 2;

            this.one_flg = "class=\"page-item\"";
            this.two_flg = "class=\"page-item\"";
            this.three_flg = "class= \"page-item active\" style=\"pointer-events: none;\"";
            this.four_flg = "class=\"page-item\"";
            this.five_flg = "class=\"page-item\"";
        }

    }

    /**
     * 最大件数からページ数を出す
     */
    public int getPage() {
        return this.maxpage;
    }

    public int getMax() {
        return this.max;
    }

    public int getLast() {
        return this.last;
    }

    /**
     * どれだけ空白を入れるのか
     */
    public int getMargin() {
        return this.margin;
    }

    /**
     * 空白を入れるのか判定
     */
    public boolean getMarginFlg() {
        return this.margin_flg;
    }

    /**
     * 前へボタンの有無
     */
    public boolean getBackF() {
        return this.back_flg;
    }

    /**
     * 次へボタンの有無
     */
    public boolean getNextF() {
        return this.next_flg;
    }

    /**
     * 最小ボタンの有無
     */
    public boolean getMinF() {
        return this.min_flg;
    }

    /**
     * 最大ボタンの有無
     */
    public boolean getMaxF() {
        return this.max_flg;
    }

    /**
     * レコード取得
     */
    public int getFirstRecode() {
        return this.first_recode;
    }

    /**
     * 選択ページか判定01
     */
    public String getOneFlg() {
        return this.one_flg;
    }

    /**
     * 選択ページか判定02
     */
    public String getTwoFlg() {
        return this.two_flg;
    }

    /**
     * 選択ページか判定03
     */
    public String getThreeFlg() {
        return this.three_flg;
    }

    /**
     * 選択ページか判定04
     */
    public String getFourFlg() {
        return this.four_flg;
    }

    /**
     * 選択ページか判定05
     */
    public String getFiveFlg() {
        return this.five_flg;
    }

    /**
     * ページ01
     */
    public int getOne() {
        return this.one;
    }

    /**
     * ページ02
     */
    public int getTwo() {
        return this.two;
    }

    /**
     * ページ03
     */
    public int getThree() {
        return this.three;
    }

    /**
     * ページ04
     */
    public int getFour() {
        return this.four;
    }

    /**
     * ページ05
     */
    public int getFive() {
        return this.five;
    }

    /**
     * 次表示するページ
     */
    public int getNextPage() {
        return this.i_page;
    }
}
