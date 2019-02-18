package com.zking.springboot_project.pur.service.impl;

import com.zking.springboot_project.basic.mapper.GoodsMapper;
import com.zking.springboot_project.basic.model.Goods;
import com.zking.springboot_project.pur.mapper.ShopcartMapper;
import com.zking.springboot_project.pur.model.Shopcart;
import com.zking.springboot_project.pur.service.IShopcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShopcartServiceImpl implements IShopcartService {

    @Autowired
    private ShopcartMapper shopcartMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public int deleteByPrimaryKey(Integer cartid) {
        return shopcartMapper.deleteByPrimaryKey(cartid);
    }

    @Override
    public int insert(Shopcart record) {

        //1查询购物车里是否有当前增加的商品
        Shopcart shopcart = shopcartMapper.querygoodid(record.getGoodid());
        if(null==shopcart){
            Goods goods=new Goods();
            goods.setId(record.getGoodid());
            Goods g = goodsMapper.queryGoodsbynames(goods);
            record.setGoodname(g.getName());
            return shopcartMapper.insert(record);
        }else{
            int num=shopcart.getNum();
            float sub=shopcart.getSubtotal();
            num+=record.getNum();
            sub+=record.getSubtotal();
            record.setNum(num);
            record.setSubtotal(sub);
            return shopcartMapper.updategoodid(record);
        }
    }

    @Override
    public List<Map<String, Object>> queryCartLst() {
        return shopcartMapper.queryCartLst();
    }

    @Override
    public Shopcart querygoodid(Integer id) {
        return shopcartMapper.querygoodid(id);
    }

    @Override
    public int updategoodid(Shopcart shopcart) {
        return shopcartMapper.updategoodid(shopcart);
    }
}
