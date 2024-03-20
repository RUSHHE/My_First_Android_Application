package com.example.myapplication;

import java.util.List;

public class ContactMode {
  private String GroupName;
  private List<ChildDataBean> ChildData;

  public String getGroupName() {
    return GroupName;
  }

  public void setGroupName(String groupName) {
    GroupName = groupName;
  }

  public List<ChildDataBean> getChildData() {
    return ChildData;
  }

  public void setChildData(List childData) {
    ChildData = childData;
  }

  public static class ChildDataBean {
    private String ChildName;
    private String ChildIcon;
    private String ChildAbout;

    public String getChildName() {
      return ChildName;
    }

    public void setChildName(String childName) {
      ChildName = childName;
    }

    public String getChildIcon() {
      return ChildIcon;
    }

    public void setChildIcon(String childIcon) {
      ChildIcon = childIcon;
    }

    public String getChildAbout() {
      return ChildAbout;
    }

    public void setChildAbout(String ChildAbout) {
      this.ChildAbout = ChildAbout;
    }
  }
}
