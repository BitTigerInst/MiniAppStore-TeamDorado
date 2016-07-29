package org.bittiger.group5.apps;

import org.bittiger.group5.model.App;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.tophits.TopHitsBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;


/**
 * Created by Ian on 7/25/2016.
 */

@RestController
@RequestMapping("/apps")
public class AppController {

    @Autowired
    private AppRepository appRepository;

    @RequestMapping(value = "", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<App> findAllApps() {
        return appRepository.findAll();
    }

    @RequestMapping(value = "/genres/{genre}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<App> findAppsByGenre(@PathVariable String genre) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchAllQuery()).withFilter(FilterBuilders.termFilter("genres", genre)).build();
        return appRepository.search(searchQuery).getContent();
    }

    @RequestMapping(value = "/top", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<App> findTopApps() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchAllQuery()).withSort(SortBuilders.fieldSort("averageUserRating").order(SortOrder.DESC)).build();
        return appRepository.search(searchQuery).getContent();
    }

    @RequestMapping(value = "/id/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public App findAppById(@PathVariable long id) {
        return appRepository.findByTrackId(id);
    }

    @RequestMapping(value = "/search/{keyword}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<App> findAppsByKeyword(@PathVariable String keyword) {
        return appRepository.findByTrackCensoredNameLike(keyword);
    }

}
