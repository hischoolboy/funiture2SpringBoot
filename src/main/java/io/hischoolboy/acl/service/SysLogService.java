package io.hischoolboy.acl.service;import io.hischoolboy.acl.convert.BaseConvert;import io.hischoolboy.acl.convert.LogConvert;import io.hischoolboy.acl.dao.SysLogDao;import io.hischoolboy.acl.domain.SysAcl;import io.hischoolboy.acl.domain.SysAclModule;import io.hischoolboy.acl.domain.SysBase;import io.hischoolboy.acl.domain.SysDept;import io.hischoolboy.acl.domain.SysLog;import io.hischoolboy.acl.domain.SysRole;import io.hischoolboy.acl.domain.SysUser;import io.hischoolboy.acl.dto.LogSearchDto;import io.hischoolboy.acl.enums.LogType;import io.hischoolboy.acl.vo.LogPara;import io.hischoolboy.beans.JsonMapper;import io.hischoolboy.beans.PageQuery;import io.hischoolboy.beans.PageResult;import com.google.common.base.Joiner;import lombok.extern.slf4j.Slf4j;import org.springframework.stereotype.Service;import javax.annotation.Resource;import java.util.List;@Slf4j@Servicepublic class SysLogService {    @Resource    private SysLogDao sysLogDao;    public PageResult<SysLog> getPageByFuzzySearch(LogPara para, PageQuery page) {        BaseConvert.checkPara(page);        LogSearchDto dto = LogConvert.of(para);        int count = sysLogDao.countFuzzySearch(dto);        if (count > 0) {            List<SysLog> list = sysLogDao.fuzzySearch(dto, page);            return PageResult.<SysLog>builder().total(count).data(list).build();        }        return PageResult.<SysLog>builder().build();    }    public SysLog findById(int id) {        return sysLogDao.findById(id);    }    public void saveAclLog(SysAcl before, SysAcl after) {        SysBase base = BaseConvert.of();        SysLog sysLog = SysLog.builder().targetId(after.getId()).type(LogType.ACL.getCode()).oldValue(JsonMapper.obj2String(before))                .newValue(JsonMapper.obj2String(after)).operator(base.getOperator()).operateIp(base.getOperateIp()).build();        safetySaveLog(sysLog);    }    public void saveAclModuleLog(SysAclModule before, SysAclModule after) {        SysBase base = BaseConvert.of();        SysLog sysLog = SysLog.builder().targetId(after == null ? before.getId() : after.getId()).type(LogType.ACL_MODULE.getCode())                .oldValue(JsonMapper.obj2String(before)).newValue(JsonMapper.obj2String(after)).operator(base.getOperator()).operateIp(base.getOperateIp())                .build();        safetySaveLog(sysLog);    }    public void saveUserLog(SysUser before, SysUser after) {        SysBase base = BaseConvert.of();        SysLog sysLog = SysLog.builder().targetId(after.getId()).type(LogType.USER.getCode()).oldValue(JsonMapper.obj2String(before))                .newValue(JsonMapper.obj2String(after)).operator(base.getOperator()).operateIp(base.getOperateIp()).build();        safetySaveLog(sysLog);    }    public void saveRoleLog(SysRole before, SysRole after) {        SysBase base = BaseConvert.of();        SysLog sysLog = SysLog.builder().targetId(after == null ? before.getId() : after.getId()).type(LogType.ROLE.getCode())                .oldValue(JsonMapper.obj2String(before)).newValue(JsonMapper.obj2String(after)).operator(base.getOperator()).operateIp(base.getOperateIp())                .build();        safetySaveLog(sysLog);    }    public void saveDeptLog(SysDept before, SysDept after) {        SysBase base = BaseConvert.of();        SysLog sysLog = SysLog.builder().targetId(after == null ? before.getId() : after.getId()).type(LogType.DEPT.getCode())                .oldValue(JsonMapper.obj2String(before)).newValue(JsonMapper.obj2String(after)).operator(base.getOperator()).operateIp(base.getOperateIp())                .build();        safetySaveLog(sysLog);    }    public void saveRoleAclLog(int roleId, List<Integer> beforeList, List<Integer> afterList) {        SysBase base = BaseConvert.of();        SysLog sysLog = SysLog.builder().targetId(roleId).type(LogType.ROLE_ACL.getCode()).oldValue(Joiner.on(",").join(beforeList))                .newValue(JsonMapper.obj2String(Joiner.on(",").join(afterList))).operator(base.getOperator()).operateIp(base.getOperateIp()).build();        safetySaveLog(sysLog);    }    public void saveRoleUserLog(int roleId, List<Integer> beforeList, List<Integer> afterList) {        SysBase base = BaseConvert.of();        SysLog sysLog = SysLog.builder().targetId(roleId).type(LogType.ROLE_USER.getCode()).oldValue(Joiner.on(",").join(beforeList))                .newValue(JsonMapper.obj2String(Joiner.on(",").join(afterList))).operator(base.getOperator()).operateIp(base.getOperateIp()).build();        safetySaveLog(sysLog);    }    private void safetySaveLog(SysLog sysLog) {        try {            sysLogDao.save(sysLog);        } catch (Throwable e) {            log.error("add log exception, {}", JsonMapper.obj2String(sysLog), e);        }    }}