package cn.czcxy.xj.basicclient.goods.mapper;


import cn.czcxy.xj.basicclient.goods.entity.Goods;
import cn.czcxy.xj.core.platform.base.model.DataSourceRequest;
import cn.czcxy.xj.core.util.EntityUtil;

import java.util.Map;

/**
 * 产品档案动态查询
 *
 * @author weihua
 * @create 2017-05-16 14:21
 */
public class GoodsDynaSqlProvider {
    public String findVendorGoodsByVendorId(Map<String, Object> map) {
        StringBuilder sql = new StringBuilder();
        String vendorId = map.get("vendorId").toString();
        DataSourceRequest dataSourceRequest = (DataSourceRequest) map.get("dataSourceRequest");
        sql.append("SELECT * from eidp_goods_archive WHERE id not in ( ");
        sql.append("SELECT goods_id from eidp_vendor_goods where vendor_id = #{vendorId}");
        sql.append(")  ");
        sql.append(EntityUtil.buidSqlByRequest(dataSourceRequest, Goods.class));
        return sql.toString();
    }
}
