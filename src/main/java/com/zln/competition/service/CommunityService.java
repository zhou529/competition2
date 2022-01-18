package com.zln.competition.service;

import com.zln.competition.bean.Community;
import com.zln.competition.mapper.CommunityMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

public interface CommunityService {
    /**
     * 根据主键删除数据
     * @param comId
     * @return
     */
    int deleteByComId(Integer comId);

    /**
     * 添加数据
     * @param community
     * @return
     */
    public int insertCommunity(Community community);

    /**
     * 根据com_name查询id，引入到com_admin表中
     * @param comName
     * @return
     */
    public Community selectCommunityByComName(String comName);

    /**
     * 查询所有数据
     * @return
     */
    public List<Community> selectAllCommunity();

    public List<Community> selectAllByComName(String comName);

    public int updateByCommunity(Community community);

    public Community selectCommunityByComId(Integer comId);

    List<Community> selectCommunityDim(Community communityDim);

    int updateCommunityBrowseByComIdWX(Integer comId);
}
