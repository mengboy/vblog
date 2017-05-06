package com.vector.blog.model.admin;

import java.util.LinkedList;

/**
 * Created by vector on 2017/4/17.
 */
public class MenuList {
    private int menuID;
    private String menuTitle;
    private String menuLiId;
    private String Url;
    private LinkedList<MenuList> lists;

    public MenuList(LinkedList<MenuList> llists) {
        this.lists = llists;
    }

    public MenuList(String menuTitle, String url) {
        this.menuTitle = menuTitle;
        Url = url;
    }

    public MenuList(String menuTitle, String menuLiId, String url) {
        this.menuTitle = menuTitle;
        this.menuLiId = menuLiId;
        Url = url;
    }

    public MenuList(String menuTitle, String url, LinkedList<MenuList> lists) {
        this.menuTitle = menuTitle;
        Url = url;
        this.lists = lists;
    }

    public MenuList() {
    }


    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuId() {
        return menuLiId;
    }

    public void setMenuId(String menuId) {
        this.menuLiId = menuId;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public LinkedList<MenuList> getLlists() {
        return lists;
    }

    public void setLlists(LinkedList<MenuList> llists) {
        this.lists = llists;
    }
}
