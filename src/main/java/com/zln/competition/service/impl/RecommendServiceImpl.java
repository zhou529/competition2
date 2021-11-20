package com.zln.competition.service.impl;

import com.zln.competition.bean.Recommend;
import com.zln.competition.mapper.RecommendMapper;
import com.zln.competition.service.RecommendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {
    @Resource
    RecommendMapper recommendMapper;

    @Override
    public int updateRecommendBrowseByRecIdWX(Integer recId){
        int i = recommendMapper.updateRecommendBrowseByRecIdWX(recId);
        return i;
    }

    @Override
    public List<Recommend> selectRecommendDim(Recommend recommend){
        List<Recommend> recommends = recommendMapper.selectRecommendDim(recommend);
        return recommends;
    }
    @Override
    public int updateRecommendByRecId(Recommend record){
        return recommendMapper.updateRecommendByRecId(record);
    }
    @Override
    public int insertRecommend(Recommend recommend){
        int i = recommendMapper.insertRecommend(recommend);
        return i;
    }

    @Override
    public List<Recommend> selectRecommendByRecName(String recName){
        return recommendMapper.selectRecommendByRecName(recName);
    }

    @Override
    public int deleteByRecId(Integer recId){
        return recommendMapper.deleteByRecId(recId);
    }

    @Override
    public int allDeleteRecommend() {
        return recommendMapper.allDeleteRecommend();
    }

    @Override
    public List<Recommend> selectRecommendByComId(Integer comId){
        return recommendMapper.selectRecommendByComId(comId);
    }


    @Override
    public List<Recommend> selectAllRecommend() {
        List<Recommend> recommends = recommendMapper.selectAllRecommend();
        return recommends;
    }

    @Override
    public Recommend selectRecommendAndCommunityByRecName(String recName){
        Recommend recommend = recommendMapper.selectRecommendAndCommunityByRecName(recName);
        System.out.println("RecommendServiceImpl 的  recommend : " + recommend);
        return recommend;
    }

    @Override
    public Recommend selectRecommendById(Integer id){
        Recommend recommend = recommendMapper.selectRecommendById(id);
        return recommend;
    }

}
