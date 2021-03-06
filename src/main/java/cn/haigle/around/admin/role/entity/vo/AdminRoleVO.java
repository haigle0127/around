package cn.haigle.around.admin.role.entity.vo;

import cn.haigle.around.common.entity.BaseVO;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户角色
 * @author haigle
 * @date 2019-06-09 14:11
 */
@Getter
@Setter
public class AdminRoleVO extends BaseVO {

    private String name;
    private String ename;
    private String description;

}
