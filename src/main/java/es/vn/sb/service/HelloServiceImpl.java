package es.vn.sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.elastic.apm.api.CaptureSpan;
import co.elastic.apm.api.ElasticApm;
import co.elastic.apm.api.Span;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private RestTemplate myRestTemplate;
    
    @Value("${service-2.url}")
    String url;

    @CaptureSpan
	public String helloDirect() {
    	Span span = ElasticApm.currentSpan();
		span.addLabel("service", "entrada al servicio");
		span.addLabel("llamada", String.format("Llamada al servicio con url %s", url));
		return myRestTemplate.getForEntity(url, String.class).getBody();
	}
    
}   
