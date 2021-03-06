package org.bittiger.group5.apps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.bittiger.group5.model.App;
import org.bittiger.group5.model.Apps;
import org.bittiger.group5.util.MiniAppConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;

/**
 * Created by Ian on 7/26/2016.
 */
@Component
public class UpdateAppDataSchedule {
    @Autowired
    private AppRepository repository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     *
     */
    @Scheduled(fixedRate = 3600000)
    public void updateAppData() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = MiniAppConstants.SEARCH_TOP_APPS_URL;
        ObjectNode request = getPostRequest();
        repository.deleteAll();
        Apps apps = restTemplate.postForObject(uri, request, Apps.class);
        for (App app : apps.getApps()) {
            repository.save(app);
        }
    }

    /**
     * Need to be refactored
     * @return
     */
    public ObjectNode getPostRequest() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode request = mapper.createObjectNode();
        ObjectNode query = mapper.createObjectNode();
        ObjectNode queryParams = mapper.createObjectNode();
        queryParams.put("from", 0);
        queryParams.put("num", 100);
        queryParams.put("sort", "userRatingCount");
        queryParams.put("sort_order", "desc");
        query.put("name", "Most Popular Apps");
        query.put("platform", "ios");
        query.put("query_params", queryParams);
        request.put("query", query);
        return request;
    }
}
