package com.wangdong.damai.bean;

/**
 * Created by wd794 on 2016/3/18 0018.
 */
public class HomeLocalBanner {
    @Override
    public String toString() {
        return "HomeLocalBanner{" +
                "Name='" + Name + '\'' +
                ", ProjectID=" + ProjectID +
                ", Pic='" + Pic + '\'' +
                '}';
    }

    /**
     * Name : 周杰伦萧亚轩潘玮柏巨星荆州演唱会
     * ProjectID : 96748
     * Pic : http://pimg.damai.cn/perform/damai/NewIndexManagement/201603/4101ec3f58974d46aa707aa278a5a406.jpg
     * ProjType : 0
     * Url :
     */

    private String Name;
    private int ProjectID;
    private String Pic;

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setProjectID(int ProjectID) {
        this.ProjectID = ProjectID;
    }

    public void setPic(String Pic) {
        this.Pic = Pic;
    }

    public String getName() {
        return Name;
    }

    public int getProjectID() {
        return ProjectID;
    }

    public String getPic() {
        return Pic;
    }
}
