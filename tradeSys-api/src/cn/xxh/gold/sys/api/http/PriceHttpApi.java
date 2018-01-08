package cn.xxh.gold.sys.api.http;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.PseudoColumnUsage;
import java.util.List;
import java.util.Properties;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

import cn.xxh.ResourcesUtil;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.vo.PriceVo;

public class PriceHttpApi {

	static String tradeProviderUrl = "";
	static {
		 Properties properties = ResourcesUtil.getPropertiesFromFile("config-tradeProvider.properties");
		 tradeProviderUrl = properties.getProperty("tradeProviderUrl");
		 if(tradeProviderUrl==null){
			 throw new RuntimeException("找不到config-tradeProvider.properties配置项tradeProviderUrl");
		 }
	}
	
	public ResBo findPricedo() {

		try {
			String url = tradeProviderUrl+"Price/findPrice.do";
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse response = client.execute(get);
			String str = EntityUtils.toString(response.getEntity(),"utf-8");
			ResBo resbo = JSON.parseObject(str, ResBo.class);
			  List<PriceVo> priceVo = JSON.parseArray(resbo.getData().toString(),
					PriceVo.class);
			resbo.setData(priceVo);
			return resbo;
		} catch (ClientProtocolException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;

	}

}
