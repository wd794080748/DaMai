package com.wangdong.damai.bean;

import java.util.List;

/**
 * Created by wd794 on 2016/3/21 0021.
 */
public class HomeCountry {
    /**
     * type : 8
     * title : 「每日专享」
     * list : [{"title":"","type":3,"picUrl":"http://static.damai.cn/mapi/2016-03-18/fffa6005-6bb3-4fa1-8faa-029b589f71e0.jpg","context":"435","subTitle":""},{"title":"","type":8,"picUrl":"http://static.damai.cn/mapi/2016-03-18/86bb0282-8a2e-413a-8fc4-9e894c0476b3.jpg","context":"0","subTitle":""}]
     */

    private List<ListEntity> list;

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public List<ListEntity> getList() {
        return list;
    }

    public static class ListEntity {
        private String title;
        /**
         * title :
         * type : 3
         * picUrl : http://static.damai.cn/mapi/2016-03-18/fffa6005-6bb3-4fa1-8faa-029b589f71e0.jpg
         * context : 435
         * subTitle :
         */

        private List<ListInEntity> list;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setList(List<ListInEntity> list) {
            this.list = list;
        }

        public String getTitle() {
            return title;
        }

        public List<ListInEntity> getList() {
            return list;
        }

        public static class ListInEntity {
            private String title;
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
