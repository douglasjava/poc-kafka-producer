package com.demo.producer.kafkaproducer.core.producer;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.demo.producer.kafkaproducer.model.ModelTransfer;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicProducer {

	private static final String TOPIC_NAME = "topico.comando.teste";

	private final KafkaTemplate<String, String> kafkaTemplate;

	public void send(String message) {
		log.info("Payload enviado: {}", message);

		String chave = UUID.randomUUID().toString();

		ModelTransfer transfer = new ModelTransfer();
		transfer.setId(50L);
		transfer.setNome("Douglas Dias");
		transfer.setData(LocalDateTime.now());

		Gson gson = new Gson();

		String json = gson.toJson(transfer);

		kafkaTemplate.send(TOPIC_NAME, chave, json);
		
		log.info("Payload enviado: {}", json);

	}

}
