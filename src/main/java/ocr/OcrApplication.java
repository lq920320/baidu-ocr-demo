package ocr;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.ocr.AipOcr;
import ocr.domain.BaiDuOCRBean;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.HashMap;
import java.util.List;

/**
 * @author liuqian
 * @date 2018/5/28 10:50
 */
@SpringBootApplication
@EntityScan(basePackageClasses = {OcrApplication.class})
public class OcrApplication {

  public static void main(String[] args) {
    AipOcr aipOcr = new AipOcr("", "", "");
    String imgData = "C:\\image\\20180528120156.jpg";
    HashMap<String, String> options = new HashMap<>(16);
    JSONObject jsonObject = aipOcr.general(imgData, options);
    System.out.println(jsonObject);
    BaiDuOCRBean baiDuOCRBean = com.alibaba.fastjson.JSONObject.toJavaObject(JSON.parseObject(jsonObject.toString()), BaiDuOCRBean.class);
    List<BaiDuOCRBean.Words_result> list = baiDuOCRBean.getWords_result();
    for (BaiDuOCRBean.Words_result aList : list) {
      System.out.println(aList.getWords());
    }
  }
}
