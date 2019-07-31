package com.study.feign.interceptor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * FileName: FeignRequestInterceptor Description:
 *
 * @author caozhongyu
 * @create 19-7-31
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor {

  private static final String REQ_METHOD_GET = "GET";

  @Resource
  private ObjectMapper objectMapper;

  @Override
  public void apply(RequestTemplate requestTemplate) {
    if (Objects.equals(requestTemplate.method(), REQ_METHOD_GET) && Objects.nonNull(requestTemplate.body())) {
      try {
        JsonNode jsonNode = objectMapper.readTree(requestTemplate.body());
        requestTemplate.body(null);
        Map<String, Collection<String>> queries = new HashMap<>();
        buildQuery(jsonNode, "", queries);
        requestTemplate.queries(queries);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private void buildQuery(JsonNode jsonNode, String path, Map<String, Collection<String>> queries) {
    // 叶子节点
    if (!jsonNode.isContainerNode()) {
      if (jsonNode.isNull()) {
        return;
      }
      Collection<String> values = queries.get(path);
      if (null == values) {
        values = new ArrayList<>();
        queries.put(path, values);
      }
      values.add(jsonNode.asText());
      return;
    }
    // 数组节点
    if (jsonNode.isArray()) {
      Iterator<JsonNode> it = jsonNode.elements();
      while (it.hasNext()) {
        buildQuery(it.next(), path, queries);
      }
    } else {
      Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
      while (it.hasNext()) {
        Map.Entry<String, JsonNode> entry = it.next();
        if (StringUtils.hasText(path)) {
          buildQuery(entry.getValue(), path + "." + entry.getKey(), queries);
        } else {  // 根节点
          buildQuery(entry.getValue(), entry.getKey(), queries);
        }
      }
    }
  }
}