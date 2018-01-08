package cn.xxh.gold.sys.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xxh.gold.sys.dao.PriceDao;

@Service
public class GoldPriceServiceImpl implements GoldPriceService {
	
	@Autowired
	PriceDao priceDao;
	
	// TODO 金价接口更新此字段
	public static BigDecimal goldPrice = new BigDecimal("300");

	/*public ResBo addprice(PriceVo priceVo) {

		try {

			String url = "http://www.maijinbei.com/getPrice.do";
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse response = client.execute(get);
			String str = EntityUtils.toString(response.getEntity(), "utf-8");
			ResBo resBo = JSON.parseObject(str, ResBo.class);
			OrderProductVo orderProductVo = JSON.parseObject(resBo.getData()toString(), OrderProductVo.class);
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}*/
}
