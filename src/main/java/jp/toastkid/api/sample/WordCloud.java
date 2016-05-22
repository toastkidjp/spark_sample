package jp.toastkid.api.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.toastkid.libs.tinysegmenter.TinySegmenter;

import org.apache.commons.lang3.StringUtils;

import spark.ModelAndView;
import spark.TemplateViewRoute;

/**
 * Word Cloud App.
 * @author Toast kid
 *
 */
public class WordCloud {

    /** 使用するテンプレート. */
    private static final String VIEW_TEMPLATE = "word_cloud.ftl";

    /** line separator. */
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /** width of word-cloud. */
    private static final int WIDTH  = 600;

    /** height of word-cloud. */
    private static final int HEIGHT =  400;

    /** Title. */
    private static final String TITLE = "Word Cloud";

    /** tiny segmenter. */
    private final TinySegmenter ts = TinySegmenter.getInstance();

    /**
     * @return Route object.
     */
    public TemplateViewRoute index() {
        return (request, response) -> {
            final Map<String, Object> model = new HashMap<>();
            final String sentence = request.queryMap().get("sentence").value();
            if (!StringUtils.isBlank(sentence)) {
                model.put("data",   count(sentence));
            }
            model.put("title",  TITLE);
            model.put("width",  WIDTH);
            model.put("height", HEIGHT);
            model.put("paramSentence", sentence);
            return new ModelAndView(model, VIEW_TEMPLATE);
        };
    }

    /**
     * count words in sentence.
     * @param sentence
     * @return
     */
    private String count(final String sentence) {
        final Map<String, Integer> data = new HashMap<>(100);
        final List<String> list = ts.segment(sentence);
        for (String item : list) {
            item = item.replaceAll("\\s", "");
            if (item.contains(LINE_SEPARATOR)) {
                continue;
            }
            int count = 1;
            if (data.containsKey(item)) {
                count = data.get(item) + count;
            }
            data.put(item, count);
        }
        return extract(data);
    }

    /**
     * extract string from data map.
     * @param data
     * @return
     */
    private String extract(final Map<String, Integer> data) {
        final StringBuilder dataStr = new StringBuilder();
        dataStr.append("[");
        if (!data.isEmpty()) {
            for (final String key : data.keySet()) {
                if (1 < dataStr.length()) {
                    dataStr.append(", ");
                }
                dataStr.append("{\"word\"")
                    .append(": ")
                    .append(doubleQuote(key))
                    .append(",")
                    .append("\"count\": ")
                    .append(doubleQuote(Integer.toString(data.get(key))))
                    .append("}");
            }
        }
        dataStr.append("]");
        return dataStr.toString();
    }

    /**
     * surround double quote.
     * @param str
     * @return
     */
    private static final String doubleQuote(final String str) {
        return "\"" + str + "\"";
    }
}
