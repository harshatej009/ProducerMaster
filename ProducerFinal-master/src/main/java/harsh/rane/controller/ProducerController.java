package harsh.rane.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import harsh.rane.model.Patient;
import harsh.rane.service.JsonParse;

@RestController
public class ProducerController
{

	@Autowired
	private KafkaTemplate<String,Patient> kafkaTemplate;
	
	@Autowired
	private JsonParse jsonparse;
	
	private static final Logger LOGGER = LogManager.getLogger(ProducerController.class);
	
	@GetMapping("/produceJson")       
	public void Read()
	{
			kafkaTemplate.send("topic1",jsonparse.getLocalJson()); 
			LOGGER.info("json message has been sent");
	} 
	
}

