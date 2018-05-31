
import com.alibaba.fastjson.JSON;
import com.baidu.aip.util.Base64Util;
import ocr.domain.BaiDuOCRBean;
import ocr.utils.FileUtil;
import ocr.utils.HttpUtil;
import org.junit.Test;

import java.net.URLEncoder;
import java.util.List;

/**
 * @author liuqian
 * @date 2018/5/28 11:21
 */
public class TestOcr {

  @Test
  public void testOcr() throws Exception {
    String token = "";
    String imgData = "C:\\image\\20180528171250.jpg";
    String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate?access_token=" + token;
    String base64 = Base64Util.encode(FileUtil.readFileByBytes(imgData));
    String param = "image=" + URLEncoder.encode(base64, "UTF-8") + "&language_type=CHN_ENG&detect_direction=true&detect_language=true&probability=true";
    String result = HttpUtil.post(url, token, param);
    BaiDuOCRBean baiDuOCRBean = com.alibaba.fastjson.JSONObject.toJavaObject(JSON.parseObject(result), BaiDuOCRBean.class);
    List<BaiDuOCRBean.Words_result> list = baiDuOCRBean.getWords_result();
    for (BaiDuOCRBean.Words_result aList : list) {
      System.out.println(aList.getWords());
    }
  }
}
