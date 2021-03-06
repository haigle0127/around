package cn.haigle.around.admin.menu.dao;

import cn.haigle.around.admin.menu.dao.provider.AdminMenuDaoProvider;
import cn.haigle.around.admin.menu.entity.ao.AdminMenuAO;
import cn.haigle.around.admin.menu.entity.bo.AdminTreeBO;
import cn.haigle.around.admin.menu.entity.vo.AdminMenuVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 惨黛管理DAO
 * @author haigle
 * @date 2019/8/23 10:16
 */
@Mapper
@Repository
public interface AdminMenuDao {

    /**
     * 查询菜单列表
     * @param id 菜单ID
     * @return List<AdminMenuVo> 菜单列表
     * @author haigle
     * @date 2019/8/23 10:17
     */
    @SelectProvider(type = AdminMenuDaoProvider.class, method = "list")
    List<AdminMenuVO> list(Long id);

    /**
     * 查询菜单所有数据
     * @return List<AdminMenuAllListPo>
     * @author haigle
     * @date 2019/9/2 15:16
     */
    @SelectProvider(type = AdminMenuDaoProvider.class, method = "allList")
    List<AdminTreeBO> adminMenuAllPoList();

    /**
     * 保存菜单
     * @param m AdminMenuDto
     * @param uid 操作人ID
     * @author haigle
     * @date 2019/8/23 13:17
     */
    @InsertProvider(type = AdminMenuDaoProvider.class, method = "save")
    void save(AdminMenuAO m, Long uid);

    /**
     * 更新父级是否有子集菜单
     * @param parentId 菜单ID
     * @param hasChildren 0,1
     * @author haigle
     * @date 2019/8/28 10:15
     */
    @Update("update sys_menu set has_children=#{hasChildren} where id=#{parentId}")
    void updateHasChildren(Long parentId, int hasChildren);

    /**
     *更新菜单
     * @param m AdminMenuDto
     * @param uid 操作人ID
     * @author haigle
     * @date 2019/8/23 13:17
     */
    @UpdateProvider(type = AdminMenuDaoProvider.class, method = "update")
    void update(AdminMenuAO m, Long uid);

    /**
     * 删除菜单
     * @param id 菜单ID
     * @author haigle
     * @date 2019/8/23 13:18
     */
    @Delete("DELETE FROM sys_menu WHERE id=#{id}")
    void delete(Long id);

    /**
     * 删除角色菜单关联
     * @param menuId 菜单ID
     * @author haigle
     * @date 2019/8/23 16:52
     */
    @Delete("delete FROM sys_role_menu where menu_id=#{menuId}")
    void deleteRoleMenu(Long menuId);

    /**
     * 获取菜单ID
     * @param parentId 菜单ID
     * @return 菜单ID
     * @author haigle
     * @date 2019/8/27 14:40
     */
    @Select("select IFNULL(NULL, 0) from sys_menu where id = #{parentId}")
    Long getIsMenu(Long parentId);

    /**
     * 获取菜单有无子集
     * @param parentId 菜单ID
     * @return 菜单ID
     * @author haigle
     * @date 2019/8/29 13:17
     */
    @Select("select IFNULL(NULL, 0) from sys_menu where parent_id = #{parentId} limit 1")
    Long getIsChildren(Long parentId);

    /**
     * 获取菜单是否有子集标识
     * @param parentId 菜单ID
     * @return boolean
     * @author haigle
     * @date 2019/8/28 10:12
     */
    @Select("select has_children from sys_menu where id = #{parentId}")
    boolean menuIsHasChildren(Long parentId);

    /**
     * 获取子菜单数
     * @param parentId 菜单ID
     * @return int
     * @author haigle
     * @date 2019/8/28 10:51
     */
    @Select("select count(*) from sys_menu where parent_id = #{parentId}")
    int menuChildrenCount(Long parentId);

    /**
     * 获取父ID
     * @param id 菜单ID
     * @return Long 父ID
     * @author haigle
     * @date 2019/8/28 11:20
     */
    @Select("select parent_id from sys_menu where id = #{id}")
    Long menuIsParentId(Long id);

    /**
     * 获取菜单ID列表
     * @param id 角色ID
     * @return List<Long>
     * @author haigle
     * @date 2019/9/3 16:02
     */
    @Select("select menu_id from sys_role_menu where role_id = #{id}")
    List<Long> getRoleMenuList(Long id);

    /**
     * 判断权限标识是否存在
     * @param power 权限标识
     * @return Long
     * @author haigle
     * @date 2019/9/10 10:42
     */
    @Select("select IFNULL(NULL, 0) from sys_menu where power = #{power}")
    Long getIsPower(String power);

    /**
     * 判断权限标识是否存在
     * @param power 权限标识
     * @param id 权限ID
     * @return Long
     * @author haigle
     * @date 2019/9/10 10:43
     */
    @Select("select IFNULL(NULL, 0) from sys_menu where id != #{id} and power = #{power}")
    Long getIsPowerNotId(String power, Long id);

}
