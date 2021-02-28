package com.demo.producer.kafkaproducer.model;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ModelTransfer {

	private Long id;
	private String nome;
	private LocalDateTime data;
	
}
