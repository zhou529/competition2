package com.zln.competition.service;

import com.zln.competition.bean.Recommend;

import java.util.List;

public interface RecommendService {
    public List<Recommend> selectAllRecommend();

    public Recommend selectRecommendAndCommunityByRecName(String recName);

    public Recommend selectRecommendById(Integer id);

    List<Recommend> selectRecommendByComId(Integer comId);

    int deleteByRecId(Integer recId);

    int allDeleteRecommend();

    List<Recommend> selectRecommendByRecName(String recName);

    int insertRecommend(Recommend recommend);

    int updateRecommendByRecId(Recommend record);

    int updateRecommendBrowseByRecIdWX(Integer recId);


    List<Recommend> selectRecommendDim(Recommend recommend);

}
