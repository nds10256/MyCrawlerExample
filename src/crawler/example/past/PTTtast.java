package crawler.example.past;

import com.github.abola.crawler.CrawlerPack;
import org.apache.commons.logging.impl.SimpleLog;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 */
public class PTTtast {
	// commit test
	public static void main(String[] args) {
// input20
		// set to debug level
		//CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_DEBUG);

		// turn off logging
		CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

		// 遠端資料路徑
		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1481429592.A.979.html";

		Document jsoup = CrawlerPack.start().addCookie("over18","1").getFromHtml(uri);

		System.out.println(
				CrawlerPack.start()
				
				// 參數設定
			    .addCookie("over18","1")	// 設定cookie
				//.setRemoteEncoding("big5")// 設定遠端資料文件編碼
				
				// 選擇資料格式 (三選一)推
				//.getFromJson(uri)
			    //.getFromHtml(uri)
			    //.getFromXml(uri)
			    .getFromHtml(uri)

			    // 這兒開始是 Jsoup Document 物件操作
			    //.select("span:contains(推)")
		);
				for(Element elem : jsoup.select("#main-content *")){
                elem.remove();
						System.out.println(elem.toString());}

                    System.out.println(jsoup.select("#main-content").text());

}
	}

