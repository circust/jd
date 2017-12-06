package cn.itcast.dao;

import org.apache.solr.client.solrj.SolrQuery;

import cn.itcast.pojo.SearchResult;

public interface ProductsDao {
	
	/**
	 * DAO:数据访问层--访问索引库
	 * 参数:SolrQuery
	 * 方法名:queryProductsWithCondition
	 */
	public SearchResult queryProductsWithCondition(SolrQuery solrQuery);

}
