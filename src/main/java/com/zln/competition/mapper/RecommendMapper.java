package com.zln.competition.mapper;

import com.zln.competition.bean.Recommend;

import java.util.List;

public interface RecommendMapper {
    public List<Recommend> selectAllRecommend();

    //根据id删除
    int deleteByRecId(Integer recId);
    //全选删除
    int allDeleteRecommend();
    //多表查询,查询所有数据
    public List<Recommend> selectAllRecommendAndCommunity(Integer comId);

    public Recommend selectRecommendAndCommunityByRecName(String recName);

    public List<Recommend> selectRecommendByRecName(String recName);

    //根据竞赛id查询竞赛信息
    public Recommend selectRecommendById(Integer id);

    //根据社团id查询竞赛信息
    List<Recommend> selectRecommendByComId(Integer comId);

    int insertRecommend(Recommend recommend);

    int updateRecommendByRecId(Recommend record);

    int updateRecImgByRecId(Recommend record);

    int updateRecommendBrowseByRecIdWX(Integer recId);

    List<Recommend> selectRecommendDim(Recommend recommend);

    List<Recommend> hot_category();

    List<Recommend> selectByTag(String openId);

    List<Recommend> recommend_race();

    List<Recommend> recommend_number_for_community();
}
