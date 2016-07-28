package org.bittiger.group5.apps;

import org.bittiger.group5.model.App;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/all", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
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

    public void findTopApps() {

    }

    public void searchAppByName() {

    }


}
