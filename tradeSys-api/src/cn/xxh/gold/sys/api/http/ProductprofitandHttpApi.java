package cn.xxh.gold.sys.api.http;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

import cn.xxh.ResourcesUtil;
import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.vo.ProductProfitandLossVo;



public class ProductprofitandHttpApi {
	
	static String tradeProviderUrl = "";
	static {
		Properties propertie = ResourcesUtil.getPropertiesFromFile("config-tradeProvider.properties");
		tradeProviderUrl=propertie.getProperty("tradeProviderUrl");
		if(tradeProviderUrl==null){
			
			throw new RuntimeException("config-tradeProvider.properties找不到tradeProviderUrl配置项");
		}
		
	}
	
	public ResBo findByStatus(){
		
		try {
			String uri = tradeProviderUrl+"product/findByStatus";
			CloseableHttpClient client = HttpClientBuilder.create().build();
			
			HttpGet get = new HttpGet(uri);
			CloseableHttpResponse response = client.execute(get);
			String str = EntityUtils.toString(response.getEntity(),"utf-8");
			 ResBo lossVo = JSON.parseObject(str,ResBo.class);
			return lossVo;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public ResBo findProductProfitandLossByProductId(Long productId){
		
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			String  uri = tradeProviderUrl+"product/findById?productId="+productId+"";
			HttpGet get = new HttpGet(uri );
			CloseableHttpResponse response = client.execute(get);
			 String str = EntityUtils.toString(response.getEntity(),"utf-8");
			 ResBo resbo = JSON.parseObject(str,ResBo.class);
			  return resbo;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	public ResBo findByPage(Page page){
		
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			String  uri = tradeProviderUrl+"product/findPage?page="
			+page.getPage()+"&pagesize="+page.getPagesize()+"";
			HttpGet get = new HttpGet(uri );
			CloseableHttpResponse response = client.execute(get);
			 String str = EntityUtils.toString(response.getEntity(),"utf-8");
			 ResBo resbo = JSON.parseObject(str,ResBo.class);
			 page= JSON.parseObject(resbo.getData().toString(), Page.class);

				List<ProductProfitandLossVo> productProfitandLossVoList = JSON.parseArray(page.getDatas().toString(),ProductProfitandLossVo.class);
				page.setDatas(productProfitandLossVoList);			 
				resbo.setData(page);
			 System.out.println(resbo);
			  return resbo;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
