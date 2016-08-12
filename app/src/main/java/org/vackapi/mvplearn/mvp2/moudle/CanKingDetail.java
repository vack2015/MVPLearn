package org.vackapi.mvplearn.mvp2.moudle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by Administrator on 2016/8/10.
 */
public class CanKingDetail {

    private String id;
    private String post_date;
    private String post_title;
    private String guid;
    private String post_content;

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

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        Document document= Jsoup.parse(post_content);
        Elements elements=document.getElementsByTag("img");
        for(int i=0;i<elements.size();i++){
            elements.get(i).attr("width","100%").attr("height","auto");
        }
        post_content=document.toString();
        this.post_content = post_content;
    }
}
