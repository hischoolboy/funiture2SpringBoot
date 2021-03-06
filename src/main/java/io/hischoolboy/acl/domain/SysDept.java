package io.hischoolboy.acl.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysDept {

    private Integer id;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 所属供应商
     */
    private int supplierId;
    /**
     * 部门层级
     */
    private String level;
    /**
     * 部门所在层级序号
     */
    private int seq;
    /**
     * 备注
     */
    private String remark;
    /**
     * 所属父部门
     */
    private int parentId;
    /**
     * 操作者
     */
    private String operator;
    /**
     * 操作者ip
     */
    private String operateIp;
    /**
     * 操作时间
     */
    private Date operateTime;
}
