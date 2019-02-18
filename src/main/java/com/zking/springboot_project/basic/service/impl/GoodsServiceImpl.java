package com.zking.springboot_project.basic.service.impl;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.basic.mapper.GoodsMapper;
import com.zking.springboot_project.basic.model.Goods;
import com.zking.springboot_project.basic.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;


    /**
     * 分页查询
     *
     * @param goods
     * @param pageBean
     * @return
     */
    @Override
    public List<Map<String, Object>> queryGoodsPage(Goods goods, PageBean pageBean) {
        return goodsMapper.queryGoodsPage(goods);
    }

    /**
     * 增加
     *
     * @param goods
     * @return
     */
    @Override
    public int insert(Goods goods) {
        Goods good = goodsMapper.querySingGood(goods.getName());
        int a = 0;
        if (good ==null) {
            goodsMapper.insert(goods);
            a = 1;
        }
        return a;
    }

    //删除
    @Override
    public int deleteByPrimaryKey(Goods goods) {
        return goodsMapper.deleteByPrimaryKey(goods);
    }

    //修改商品类型
    @Override
    public int updateGoodsById(Goods goods) {
        Goods good = goodsMapper.querySingGood(goods.getName());
        boolean updateto=false;
        if(good!=null){
            if(good.getId()==goods.getId()&&good.getName().equals(goods.getName())){
                updateto=true;
            }
        }
        int a=0;
        if(good==null||updateto){
            goodsMapper.updateGoodsById(goods);
            a=1;
        }
        return a;
    }

    //根据供应商id查询商品
    @Override
    public List<Goods> queryGoodsid(Goods goods) {
        return goodsMapper.queryGoodsid(goods);
    }

    //根据商品name查询单价
    public List<Goods> queryGoodsbyname(Goods goods) {
        return goodsMapper.queryGoodsbyname(goods);
    }

    @Override
    public List<Goods> querylist() {
        return goodsMapper.querylist();
    }

    @Override
    public List<Goods> queryGood() {
        return goodsMapper.queryGood();
    }
}
