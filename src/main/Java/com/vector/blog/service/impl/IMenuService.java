package com.vector.blog.service.impl;

import com.vector.blog.mapper.MenuMapper;
import com.vector.blog.model.Menu;
import com.vector.blog.service.MenuService;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by vector on 2017/4/20.
 */
@Service("MenuService")
public class IMenuService implements MenuService{
    @Resource
    MenuMapper menuMapper;


    public List<Menu> getTopLevelMenu(){
        return menuMapper.getTopLevelMenu();
    }

    public List<Menu> getSecondLevel(List<Menu> menus){

        for(Menu menu : menus)
        {

            List<Menu> menus1 = menuMapper.getSecondLevelMenu(menu.getMenuId());
            if(menus1 != null){
                menu.setMenus(menus1);
            }
        }

        return menus;
    }

}
