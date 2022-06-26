package com.bolingcavalry.basic.service;

import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.bolingcavalry.basic.bean.Product;

import java.util.function.BiConsumer;

/**
 * @program: elasticsearch-tutorials
 * @description: 文档相关服务的接口
 * @author: za2599@gmail.com
 * @create: 2022-06-26 11:11
 **/
public interface ProductService {

    /**
     * 根据文档id查找文档
     * @param index
     * @param id
     * @return
     * @throws Exception
     */
    Product search(String index, String id) throws Exception;

    /**
     * 新增一个文档
     * @param index 索引名
     * @param product 文档对象
     * @return
     */
    IndexResponse createByFluentDSL(String index, Product product) throws Exception;

    /**
     * 新增一个文档
     * @param index 索引名
     * @param product 文档对象
     * @return
     */
    IndexResponse createByBuilderPattern(String index, Product product) throws Exception;

    /**
     * 异步新增文档
     * @param index
     * @param product
     * @param action
     */
    void createAnsync(String index, Product product, BiConsumer<IndexResponse, Throwable> action);

    /**
     * 用JSON字符串创建文档
     * @param index
     * @param id
     * @param jsonContent
     * @return
     */
    IndexResponse createByJSON(String index, String id, String jsonContent) throws Exception;
}
