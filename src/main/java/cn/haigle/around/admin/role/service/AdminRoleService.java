package cn.haigle.around.admin.role.service;

import cn.haigle.around.admin.role.entity.ao.AdminRoleAO;
import cn.haigle.around.admin.role.entity.vo.AdminRoleVO;
import cn.haigle.around.common.base.page.Page;
import cn.haigle.around.common.entity.query.NameQuery;

/**
 * 角色接口
 * @author haigle
 * @date 2019/7/25 14:43
 */
public interface AdminRoleService {

    /**
     * 角色查询
     * @param adminSearchNameQuery 分页搜索
     * @return Page<AdminRoleVo> 分页数据
     * @author haigle
     * @date 2019/7/25 14:46
     */
    Page<AdminRoleVO> list(NameQuery adminSearchNameQuery);

    /**
     * 角色保存
     * @param adminRoleAO AdminRoleAO
     * @param uid 操作人ID
     * @author haigle
     * @date 2019-08-04 21:16
     */
    void save(AdminRoleAO adminRoleAO, Long uid);

    /**
     * 角色更新
     * @param adminRoleAO AdminRoleAO
     * @param uid 操作人ID
     * @author haigle
     * @date 2019-08-04 22:10
     */
    void update(AdminRoleAO adminRoleAO, Long uid);

    /**
     * 角色删除
     * @param id 角色ID
     * @author haigle
     * @date 2019-08-04 22:23
     */
    void delete(Long id);

}
