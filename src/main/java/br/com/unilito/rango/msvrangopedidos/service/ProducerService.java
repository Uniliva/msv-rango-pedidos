package br.com.unilito.rango.msvrangopedidos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProducerService {

	@Value("${topic.kafka.pedido}")
	private String topico;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		log.info("Postando mensagem no topico: {}", topico);
		this.kafkaTemplate.send(topico, message);
	}

}
