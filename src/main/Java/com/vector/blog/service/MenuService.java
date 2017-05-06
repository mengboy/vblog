package com.vector.blog.service;

import com.vector.blog.model.Menu;

import java.util.List;

/**
 * Created by vector on 2017/4/20.
 */
public interface MenuService {
    public List<Menu> getTopLevelMenu();
    public List<Menu> getSecondLevel(List<Menu> menus);
}
