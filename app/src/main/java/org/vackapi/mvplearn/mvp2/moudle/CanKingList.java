package org.vackapi.mvplearn.mvp2.moudle;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public class CanKingList {

    /**
     * count : 275
     * page : 1
     * list : [{"id":"13788","post_date":"2016-07-30 16:52:54","post_title":"救援者救下一只拴在房子边被忽视的狗","guid":"http://www.canking.com/?p=13788","img_src":"http://img.canking.com/news/2016/07/130.jpg","img_width":710,"img_height":394},{"id":"13783","post_date":"2016-07-29 18:09:14","post_title":"司机驾车撞倒了一只小鹿之后...结果太惊喜","guid":"http://www.canking.com/?p=13783","img_src":"http://img.canking.com/news/2016/07/01-fawn-rescue.jpg","img_width":600,"img_height":1067},{"id":"13779","post_date":"2016-07-29 17:20:06","post_title":"极度罕见，15岁的熊猫妈妈生下双胞胎","guid":"http://www.canking.com/?p=13779","img_src":"http://img.canking.com/news/2016/07/panda1.jpg","img_width":600,"img_height":373},{"id":"13767","post_date":"2016-07-29 16:19:01","post_title":"获救的流浪狗毛发下藏着惊天秘密","guid":"http://www.canking.com/?p=13767","img_src":"http://img.canking.com/news/2016/07/30.jpg","img_width":444,"img_height":593},{"id":"13761","post_date":"2016-07-28 16:28:18","post_title":"当狗发现自己获救时，它做了些什么","guid":"http://www.canking.com/?p=13761","img_src":"http://img.canking.com/news/2016/07/251.jpg","img_width":710,"img_height":399},{"id":"13755","post_date":"2016-07-28 10:43:54","post_title":"一只蝴蝶正勇敢地靠近狮子，这场景太壮观了","guid":"http://www.canking.com/?p=13755","img_src":"http://img.canking.com/news/2016/07/128.jpg","img_width":800,"img_height":498},{"id":"13733","post_date":"2016-07-27 16:49:43","post_title":"小狗的嘴巴被黑胶带缠绕，眼角流泪让人不忍直视","guid":"http://www.canking.com/?p=13733","img_src":"http://img.canking.com/news/2016/07/110.png","img_width":579,"img_height":348},{"id":"13730","post_date":"2016-07-27 12:34:13","post_title":"2000吨的海洋垃圾，拾荒者称它为家：他们生活在垃圾腐烂的的山上，从金属、塑料、针和尸...等中进行筛选，为了每天能赚取1.5英镑","guid":"http://www.canking.com/?p=13730","img_src":"http://img.canking.com/news/2016/07/126.jpg","img_width":962,"img_height":647},{"id":"13701","post_date":"2016-07-26 10:26:41","post_title":"纽约地铁上不允许携带狗狗除非它们被装在袋子里......然后就出现了这样的一幕","guid":"http://www.canking.com/?p=13701","img_src":"http://img.canking.com/news/2016/07/125.jpg","img_width":700,"img_height":926},{"id":"13679","post_date":"2016-07-25 14:31:33","post_title":"有一些东西在岩石的海滩上移动，当他走近时？Oh my God","guid":"http://www.canking.com/?p=13679","img_src":"http://img.canking.com/news/2016/07/120.jpg","img_width":710,"img_height":533}]
     */

    private int count;
    private String page;
    /**
     * id : 13788
     * post_date : 2016-07-30 16:52:54
     * post_title : 救援者救下一只拴在房子边被忽视的狗
     * guid : http://www.canking.com/?p=13788
     * img_src : http://img.canking.com/news/2016/07/130.jpg
     * img_width : 710
     * img_height : 394
     */

    private List<ListBean> list;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String id;
        private String post_date;
        private String post_title;
        private String guid;
        private String img_src;
        private int img_width;
        private int img_height;

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

        @Override
        public String toString() {
            return "{" +
                    "\"id\":\"" + id + '"' +
                    ",\"post_date\":\"" + post_date + "\"" +
                    ",\"post_title\":\"" + post_title + '"' +
                    ",\"guid\":\"" + guid + '"' +
                    ",\"img_src\":\"" + img_src + '"' +
                    ",\"img_width\":\"" + img_width +
                    "\",\"img_height\":\"" + img_height +
                    "\"}";
        }
    }

    @Override
    public String toString() {
        return "{" +
                "\"count\":\"" + count +
                "\",\"page\":\"" + page + '"' +
                ",\"list\":"+list +
                "}";
    }
}
