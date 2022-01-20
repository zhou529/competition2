package com.zln.competition.mapper;

import com.zln.competition.bean.Community;

import java.util.List;

public interface CommunityMapper {
    /**
     * 根据主键删除数据
     * @param comId
     * @return
     */
    int deleteByComId(Integer comId);

    //添加功能
    public int insertCommunity(Community community);

    //根据comName查询数据
    public Community selectCommunityByComName(String comName);

    //查询所有数据
    public List<Community> selectAllCommunity();

    //根据comId查询数据
    public List<Community> selectAllByComName(String comName);

    //根据comId查询数据
    public Community selectCommunityByComId(Integer comId);

    int updateByCommunity(Community community);

    List<Community> selectCommunityDim(Community communityDim);

    int updateCommunityBrowseByComIdWX(Integer comId);

    List<Community> hot_community();
}
