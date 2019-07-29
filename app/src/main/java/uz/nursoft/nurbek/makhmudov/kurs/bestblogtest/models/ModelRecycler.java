package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.models;

public class ModelRecycler {

    String title, desc, like, comment, see, time;

    public ModelRecycler(String title, String desc, String like, String comment, String see, String time) {
        this.title = title;
        this.desc = desc;
        this.like = like;
        this.comment = comment;
        this.see = see;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getLike() {
        return like;
    }

    public String getComment() {
        return comment;
    }

    public String getSee() {
        return see;
    }

    public String getTime() {
        return time;
    }
}
