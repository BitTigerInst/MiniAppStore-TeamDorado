package org.bittiger.group5.apps;

import org.bittiger.group5.model.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by Ian on 7/25/2016.
 */

@RestController
public class AppController {

    @Autowired
    private AppRepository appRepository;

    @RequestMapping(value = "/find/all", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<App> findAllApps() {
        return appRepository.findAll();
    }

/*    public Iterable<App> findAppsByGenre() {
        return appRe
    }

    public void findTopApps() {

    }

    public void searchAppByName() {

    }*/


}
