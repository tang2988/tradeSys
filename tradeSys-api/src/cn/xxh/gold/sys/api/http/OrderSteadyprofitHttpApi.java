package cn.xxh.gold.sys.api.http;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import cn.xxh.ResourcesUtil;
import cn.xxh.decrypt.MD5;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.vo.OrderAndProductVo;
import cn.xxh.gold.vo.OrderProductVo;
import cn.xxh.gold.vo.OrderSteadyprofitVo;

import com.alibaba.fastjson.JSON;

public class OrderSteadyprofitHttpApi {

	static String tradeProviderUrl = "";

	static{
		Properties props = ResourcesUtil.getPropertiesFromFile("config-tradeProvider.properties");
		tradeProviderUrl = props.getProperty("tradeProviderUrl");
		if(tradeProviderUrl==null){
			throw new RuntimeException("config-tradeProvider.properties找不到tradeProviderUrl配置项");
		}
	}
	
	public ResBo addorder(Long productId, Long userId, BigDecimal totalOrder,
			String md5_salt) {
		
		// 加密
		TreeMap<String, String> signMap = new TreeMap<String, String>();
		signMap.put("productId", productId + "");
		signMap.put("userId", userId + "");
		signMap.put("totalOrder", totalOrder + "");

		String signStr = signMap.toString() + md5_salt;
		System.out.println(signStr);
		String md5Signture = MD5.generateMD5(signStr);

		String url = tradeProviderUrl+"OrderSteadyprofitApi/addorder?productId="
				+ productId
				+ "&userId="
				+ userId
				+ "&totalOrder="
				+ totalOrder
				+ "&md5Signture=" + md5Signture + "";
		CloseableHttpClient http = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(url);
		String entity = "";
		try {
			CloseableHttpResponse rsp = http.execute(get);
			entity = EntityUtils.toString(rsp.getEntity(), "utf-8");
			ResBo resBo = JSON.parseObject(entity, ResBo.class);

			return resBo;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResBo Pay(Long orderId, Long userId, String md5_salt) {

		TreeMap<String, String> tree = new TreeMap<String, String>();
		tree.put("orderId", orderId + "");
		tree.put("userId", userId + "");
		String string = tree.toString() + md5_salt;
		String md5str = MD5.generateMD5(string);
		try {
			String url = tradeProviderUrl +"OrderSteadyprofitApi/Pay?orderId="
					+ orderId
					+ "&userId="
					+ userId
					+ "&md5Signture="
					+ md5str
					+ "";
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse closeableHttpResponse = client.execute(get);
			String str = EntityUtils.toString(
					closeableHttpResponse.getEntity(), "utf-8");
			ResBo resbo = JSON.parseObject(str, ResBo.class);
			OrderSteadyprofitVo orderSteadyprofitVo = JSON.parseObject(resbo
					.getData().toString(), OrderSteadyprofitVo.class);
			resbo.setData(orderSteadyprofitVo);
			System.out.println(orderSteadyprofitVo);
			return resbo;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ResBo CancelOrder(Long orderId, String md5_salta) {
		TreeMap<String, String> treeMap = new TreeMap<String, String>();

		treeMap.put("orderId", orderId + "");
		String string = treeMap.toString() + md5_salta;
		String generateMD5 = MD5.generateMD5(string);
		String url = tradeProviderUrl+"OrderSteadyprofitApi/CancelOrder?orderId="
				+ orderId + "&md5Signture="+generateMD5+ "";
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(url);
		try {
			CloseableHttpResponse closeableHttpResponse = httpClient
					.execute(get);
			String str = EntityUtils.toString(
					closeableHttpResponse.getEntity(), "utf-8");
			ResBo resbo = JSON.parseObject(str, ResBo.class);
			OrderSteadyprofitVo orderSteadyprofitVo = JSON.parseObject(resbo
					.getData().toString(), OrderSteadyprofitVo.class);
			resbo.setData(orderSteadyprofitVo);
			System.out.println(orderSteadyprofitVo);
			return resbo;
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResBo CarryInterest(Long orderId) {
		/*
		 * TreeMap<String, String> treeMap = new TreeMap<String, String>();
		 * treeMap.put("orderId", orderId+""); String string =
		 * treeMap.toString()+md5_saltaa; String generateMD5 =
		 * MD5.generateMD5(string);
		 */
		try {
			String url = tradeProviderUrl+"OrderSteadyprofitApi/CarryInterest?orderId="
					+ orderId + "";
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse response = httpClient.execute(get);
			String str = EntityUtils.toString(response.getEntity(), "utf-8");
			ResBo resbo = JSON.parseObject(str, ResBo.class);
			return resbo;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ResBo Payment(Long orderId) {

		try {
			String url = tradeProviderUrl+"OrderSteadyprofitApi/Payment?orderId="
					+ orderId + "";
			CloseableHttpClient http = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse response = http.execute(get);
			String str = EntityUtils.toString(response.getEntity(), "utf-8");
			ResBo resBo = JSON.parseObject(str, ResBo.class);
			return resBo;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ResBo Overtime(Long orderId) {

		try {
			String url = tradeProviderUrl+"OrderSteadyprofitApi/Overtime?orderId="
					+ orderId + "";
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse resp = client.execute(get);
			String str = EntityUtils.toString(resp.getEntity(), "utf-8");
			ResBo resbo = JSON.parseObject(str, ResBo.class);
			return resbo;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResBo findOrderAndPrductprofitUserId(Long userId, String md5_salta) {
	
		TreeMap<String, String> treeMap = new TreeMap<String, String>();

		treeMap.put("userId", userId + "");
		String string = treeMap.toString() + md5_salta;
		String generateMD5 = MD5.generateMD5(string);
		try {
			String url = tradeProviderUrl+"OrderSteadyprofitApi/findOrderAndPrduct?userId="
					+ userId + "&md5Signture=" + generateMD5 + "";
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse resp = client.execute(get);
			String str = EntityUtils.toString(resp.getEntity(), "utf-8");
			ResBo resBo = JSON.parseObject(str, ResBo.class);
			if(resBo!=null){
				List<OrderAndProductVo> ist = JSON.parseArray(resBo.getData()
						.toString(), OrderAndProductVo.class);
				resBo.setData(ist);
				System.out.println(resBo);
				return resBo;
			}else{
				return null;
			}
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	public ResBo OrderAndProductprofitUserIdAndOrderId(Long userId, Long orderId,String md5String) {

		TreeMap<String, String> map  = new TreeMap<String, String>();
		map.put("userId", userId+"");
		map.put("orderId", orderId+"");
		 String md5yan = map.toString()+md5String;
		  String generateMD5 = MD5.generateMD5(md5yan);
		  
		try {
			String url = tradeProviderUrl+"OrderSteadyprofitApi/TheOrderDetails?userId="
					+ userId + "&orderId=" + orderId + "&md5Signture="+generateMD5+"";
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse response = client.execute(get);
			String str = EntityUtils.toString(response.getEntity(), "utf-8");
			ResBo resBo = JSON.parseObject(str, ResBo.class);
			OrderProductVo orderProductVo = JSON.parseObject(resBo.getData()
					.toString(), OrderProductVo.class);
			resBo.setData(orderProductVo);
			System.out.println(resBo);
			return resBo;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ResBo tableOrderAndproductAndOrderId(Long orderId) {

		try {
			String url = tradeProviderUrl+"OrderSteadyprofitApi/TableOrderAndproductAndOrderId.do?orderId="
					+ orderId + "";
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse response = client.execute(get);
			String str = EntityUtils.toString(response.getEntity(), "utf-8");

			ResBo resBo = JSON.parseObject(str, ResBo.class);

			return resBo;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

}
