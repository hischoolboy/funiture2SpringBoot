package io.hischoolboy.business.dao;

import io.hischoolboy.business.domain.FileInfo;
import io.hischoolboy.common.DBRepository;
import org.apache.ibatis.annotations.Param;

@DBRepository
public interface FileInfoDao {

    FileInfo findByMD5(@Param("md5") String md5);

    FileInfo findById(@Param("id") int id);

    void insert(FileInfo fileInfo);
}
