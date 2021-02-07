package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Pong;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PingController {
	
	@GetMapping("/ping")
	public ResponseEntity<Pong> ping() {
		log.info("ping controller");
		return ResponseEntity.ok().body(new Pong("PONG"));
	}

}
