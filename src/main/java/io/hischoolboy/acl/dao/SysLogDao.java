package io.hischoolboy.acl.dao;import io.hischoolboy.acl.domain.SysLog;import io.hischoolboy.acl.dto.LogSearchDto;import io.hischoolboy.beans.PageQuery;import io.hischoolboy.common.DBRepository;import org.apache.ibatis.annotations.Param;import java.util.List;@DBRepositorypublic interface SysLogDao {    void save(SysLog log);    /**     * 根据id查询某条记录     * 用于撤回某次操作     */    SysLog findById(@Param("id") int id);    /**     * 模糊匹配更新记录     */    List<SysLog> fuzzySearch(@Param("dto") LogSearchDto dto, @Param("page") PageQuery page);    int countFuzzySearch(@Param("dto") LogSearchDto dto);}