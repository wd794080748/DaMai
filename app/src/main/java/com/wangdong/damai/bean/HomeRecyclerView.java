package com.wangdong.damai.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wd794 on 2016/3/18 0018.
 */
public class HomeRecyclerView implements Serializable{


    private List<String> buttonImgs;
    /**
     * type : 1
     * title : 「积分享优惠」
     * list : [{"title":"","type":2,"picUrl":"http://static.damai.cn/mapi/2016-03-04/2fd49249-cbe3-4806-a67d-e886d282cda5.jpg","context":"http://dui.m.damai.cn/20160224-jfzfqg/","subTitle":""}]
     */

    private List<ListEntity> list;

    public void setButtonImgs(List<String> buttonImgs) {
        this.buttonImgs = buttonImgs;
    }

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public List<String> getButtonImgs() {
        return buttonImgs;
    }

    public List<ListEntity> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "HomeRecyclerView{" +
                "buttonImgs=" + buttonImgs +
                ", list=" + list +
                '}';
    }

    public static class ListEntity implements Serializable{
        @Override
        public String toString() {
            return "ListEntity{" +
                    "title='" + title + '\'' +
                    ", list=" + list +
                    '}';
        }

        private String title;
        /**
         * title :
         * type : 2
         * picUrl : http://static.damai.cn/mapi/2016-03-04/2fd49249-cbe3-4806-a67d-e886d282cda5.jpg
         * context : http://dui.m.damai.cn/20160224-jfzfqg/
         * subTitle :
         */

        private List<ListitemEntity> list;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setList(List<ListitemEntity> list) {
            this.list = list;
        }

        public String getTitle() {
            return title;
        }

        public List<ListitemEntity> getList() {
            return list;
        }

        public static class ListitemEntity implements Serializable {
            private String title;

            @Override
            public String toString() {
                return "ListitemEntity{" +
                        "title='" + title + '\'' +
                        ", picUrl='" + picUrl + '\'' +
                        ", context='" + context + '\'' +
                        '}';
            }

            private String picUrl;
            private String context;

            public void setTitle(String title) {
                this.title = title;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public void setContext(String context) {
                this.context = context;
            }

            public String getTitle() {
                return title;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public String getContext() {
                return context;
            }
        }
    }
}
