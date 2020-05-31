package com.sidh.springboot.practice.genericdb.ui.service.externalServiceCalls.dblayer;

import com.sidh.springboot.practice.genericdb.dtos.entity.ObjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@Service
public class OTService {
    private String baseurl;
    private String singleurl;
    private String childrenurl;
    private RestTemplate restTemplate;

    public OTService(@Autowired RestTemplate restTemplate,
                     @Value("${external.dblayer.baseurl}") String baseurl,
                     @Value("${external.dblayer.ot.getOnePath}") String getOnePath,
                     @Value("${external.dblayer.ot.getChildrenPath}") String getChildrenPath) {
        this.restTemplate = restTemplate;
        this.baseurl = baseurl;
        this.singleurl = baseurl + getOnePath;
        this.childrenurl = baseurl + getChildrenPath;
    }

    public List<ObjectType> getChildrenObjectType(int id) {
        RequestEntity<Void> requestEntity = new RequestEntity<>(HttpMethod.GET, URI.create(String.format(childrenurl, id)));
        ResponseEntity<List<ObjectType>> response = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<ObjectType>>() {
        });
        if (response.getStatusCode().is2xxSuccessful())
            return response.getBody();
        return Collections.emptyList();
    }

    public ObjectType getObjectType(int id) {
        ResponseEntity<ObjectType> response = restTemplate.getForEntity(String.format(singleurl, id), ObjectType.class);
        if (response.getStatusCode().is2xxSuccessful())
            return response.getBody();
        return null;
    }
}