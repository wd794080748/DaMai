package com.wangdong.damai.bean;

import java.util.List;

/**
 * Created by wd794 on 2016/3/7 0007.
 */
public class Concert {

    /**
     * ProjectID : 95888
     * Name : 2016田馥甄世界巡回演唱会武汉站
     * PriceStr : 200,300,500,700,900,1200,1500
     * priceName : 200-1500元
     * ShowTime : 2016.09.03
     * SiteStatus : 8
     * cityname : 武汉市
     * VenName : 湖北洪山体育馆
     * VenId : 733
     * IsXuanZuo : 1
     * Mark : 重磅热荐
     * openSum : 168040
     * recommendation : 重磅热荐
     */

    private List<ListEntity> list;

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public List<ListEntity> getList() {
        return list;
    }

    public static class ListEntity {
        private int ProjectID;
        private String Name;
        private String priceName;
        private String ShowTime;
        private int SiteStatus;
        private String cityname;
        private String VenName;
        private int IsXuanZuo;

        public void setProjectID(int ProjectID) {
            this.ProjectID = ProjectID;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public void setPriceName(String priceName) {
            this.priceName = priceName;
        }

        public void setShowTime(String ShowTime) {
            this.ShowTime = ShowTime;
        }

        public void setSiteStatus(int SiteStatus) {
            this.SiteStatus = SiteStatus;
        }

        public void setCityname(String cityname) {
            this.cityname = cityname;
        }

        public void setVenName(String VenName) {
            this.VenName = VenName;
        }

        public void setIsXuanZuo(int IsXuanZuo) {
            this.IsXuanZuo = IsXuanZuo;
        }

        public int getProjectID() {
            return ProjectID;
        }

        public String getName() {
            return Name;
        }

        public String getPriceName() {
            return priceName;
        }

        public String getShowTime() {
            return ShowTime;
        }

        public int getSiteStatus() {
            return SiteStatus;
        }

        public String getCityname() {
            return cityname;
        }

        public String getVenName() {
            return VenName;
        }

        public int getIsXuanZuo() {
            return IsXuanZuo;
        }

        @Override
        public String toString() {
            return "ListEntity{" +
                    "ProjectID=" + ProjectID +
                    ", Name='" + Name + '\'' +
                    ", priceName='" + priceName + '\'' +
                    ", ShowTime='" + ShowTime + '\'' +
                    ", SiteStatus=" + SiteStatus +
                    ", cityname='" + cityname + '\'' +
                    ", VenName='" + VenName + '\'' +
                    ", IsXuanZuo=" + IsXuanZuo +
                    '}';
        }
    }
}
