package com.zln.competition.service.impl;

import com.zln.competition.bean.Community;
import com.zln.competition.mapper.CommunityMapper;
import com.zln.competition.service.CommunityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {
    @Resource
    CommunityMapper communityMapper;

    @Override
    public List<Community> selectCommunityDim(Community communityDim){
        List<Community> communities = communityMapper.selectCommunityDim(communityDim);
        return communities;
    }

    @Override
    public int updateCommunityBrowseByComIdWX(Integer comId) {
        return communityMapper.updateCommunityBrowseByComIdWX(comId);
    }

    @Override
    public int updateComImg(Community community) {
        return communityMapper.updateComImg(community);
    }

    @Override
    public List<Community> hot_community() {
        return communityMapper.hot_community();
    }

    @Override
    public List<Community> community_click() {
        return communityMapper.community_click();
    }

    @Override
    public Community selectCommunityByComId(Integer comId){
        Community community = communityMapper.selectCommunityByComId(comId);
        return community;
    }

    @Override
    public int updateByCommunity(Community community){
        int i = communityMapper.updateByCommunity(community);
        return i;
    }


    @Override
    public List<Community> selectAllByComName(String comName){
    List<Community> community = communityMapper.selectAllByComName(comName);
        return community;
    }
    @Override
    public List<Community> selectAllCommunity(){
        List<Community> communities = communityMapper.selectAllCommunity();
        return communities;
    }


    @Override
    public Community selectCommunityByComName(String comName){
        Community community = communityMapper.selectCommunityByComName(comName);
        return community;
    }


    //    @Transactional
    @Override
    public int insertCommunity(Community community){
        int i = communityMapper.insertCommunity(community);
        System.out.println("CommunityServiceImpl的insertCommunity方法的返回值i = " + i);
        return i;
    }

    @Override
    public int deleteByComId(Integer comId) {
        int i = communityMapper.deleteByComId(comId);
        System.out.println("CommunityServiceImpl的deleteByPrimaryKey方法的返回值i = " + i);
        return i;
    }
}
