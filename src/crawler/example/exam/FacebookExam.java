package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.6/"
				+ "crazyck101/posts?fields=id,link,message,created_time,reactions.limit(0).summary(total_count)&since=1480849200&until=1480856400"
				+ "&access_token=EAACEdEose0cBANDyFU4ybpKLD5JrBpXeWIAzXdi6jpUgcEh9zi8PcADTfHquJr3jbBpXYGZBYsQDjznCAUeIqSQyzNi0mhZAwwIzKHiVmvfoYOa1Mf58m7GBBOXH9Qe2SS5kNnMGUpr8khg1R3acLgkxFoFFZAbstUDnmZBEYwZDZD";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,reactions";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();
			String link = data.select("link").text();
			String message = data.select("message").text();
			String reactions = data.select("reactions").text();


			// FIXIT



			output += id +","+link+"," +message+","+reactions + "\n";


		}

		System.out.println( output );

	} 
}
