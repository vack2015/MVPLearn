package org.vackapi.mvplearn.mvp2.moudle;

/**
 * Created by Administrator on 2016/8/2.
 */
public class CanKingItem {

    private String id;
    private String post_date;
    private String post_title;
    private String guid;
    private String img_src;
    private int img_width;
    private int img_height;

    public CanKingItem(String id, String post_date, String post_title, String guid, String img_src, int img_width, int img_height) {
        this.id = id;
        this.post_date = post_date;
        this.post_title = post_title;
        this.guid = guid;
        this.img_src = img_src;
        this.img_width = img_width;
        this.img_height = img_height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public int getImg_width() {
        return img_width;
    }

    public void setImg_width(int img_width) {
        this.img_width = img_width;
    }

    public int getImg_height() {
        return img_height;
    }

    public void setImg_height(int img_height) {
        this.img_height = img_height;
    }
}
