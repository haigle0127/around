package cn.haigle.around.admin.login.entity.query;

import cn.haigle.around.common.base.validator.Login;
import cn.haigle.around.common.base.validator.LoginByEmail;
import cn.haigle.around.common.base.validator.Save;
import cn.haigle.around.common.base.validator.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * 登录参数
 * @author haigle
 * @date 2019/6/21 8:48
 */
@ApiModel
@Data
public class AdminLoginQuery {

    @ApiModelProperty(value = "账号", example = "940121265@qq.com")
    @NotBlank(message = "请输入账号", groups = {Update.class})
    private String account;

    @ApiModelProperty(value = "密码", example = "123456")
    @NotBlank(message = "请输入密码", groups = {Login.class, LoginByEmail.class, Save.class})
    @Min(value = 5, message = "密码必须大于等于六位", groups = {Save.class, LoginByEmail.class, Update.class})
    private String password;

    @ApiModelProperty(value = "验证码", example = "1234")
    @NotBlank(message = "验证码不能为空", groups = {Save.class})
    private String captcha;

}
