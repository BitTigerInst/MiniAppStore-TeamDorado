package org.bittiger.group5.apps;

import org.bittiger.group5.model.App;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


/**
 * Created by Ian on 7/25/2016.
 */
public interface AppRepository extends ElasticsearchRepository<App, Long> {
    public App findByTrackId(Long id);
    public List<App> findByTrackCensoredNameLike(String keyWord);
}
