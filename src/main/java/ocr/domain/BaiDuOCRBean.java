package ocr.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author myzd
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaiDuOCRBean {
  private Long log_id;
  private int direction;
  private int words_result_num;
  private List<Words_result> words_result;
  private int language;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Words_result {
    private String words;
    private Probability probability;

    @Data
    public static class Probability {
      private double variance;
      private double average;
      private double min;
    }
  }
}