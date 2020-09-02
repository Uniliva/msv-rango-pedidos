package br.com.unilito.rango.msvrangopedidos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.github.uniliva.librangobase.enums.TopicosKafka;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProducerService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		log.info("Postando mensagem no topico: {}", TopicosKafka.TOPICO_PEDIDO);
		this.kafkaTemplate.send(TopicosKafka.TOPICO_PEDIDO.toString(), message);
	}

}
