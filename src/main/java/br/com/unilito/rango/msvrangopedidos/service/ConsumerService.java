package br.com.unilito.rango.msvrangopedidos.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerService {

	@KafkaListener(topics = "${lito}", groupId = "teste")
	public void consumer(String message) {
		log.info("Consumindo: {}", message);
	}
}
