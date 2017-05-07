package io.hischoolboy.config;

import io.hischoolboy.beans.PageQuery;
import io.hischoolboy.common.DBRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@DBRepository
public interface ConfigurationDao {

    Configuration findByK(@Param("k") String k);

    void updateByK(Configuration configuration);

    void insert(Configuration configuration);

    List<Configuration> getAll();

    List<Configuration> getByPage(PageQuery pageQuery);

    int count();
}
