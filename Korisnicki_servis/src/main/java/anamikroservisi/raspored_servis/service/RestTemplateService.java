package anamikroservisi.raspored_servis.service;

import org.springframework.web.client.RestTemplate;

public interface RestTemplateService {
    RestTemplate setupRestTemplate(RestTemplate restTemplate);
}
