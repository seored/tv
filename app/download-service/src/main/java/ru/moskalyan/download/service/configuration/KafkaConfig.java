package ru.moskalyan.download.service.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import ru.moskalyan.download.service.dto.DownloadRequestDto;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
	
	  @Value("${kafka.bootstrap-servers}")
	  private String bootstrapServers;
	
	  @Bean
	  public Map<String, Object> producerConfigs() {
	    Map<String, Object> props = new HashMap<>();
	    // list of host:port pairs used for establishing the initial connections to the Kakfa cluster
	    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
	        bootstrapServers);
	    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	        StringSerializer.class);
	    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	    return props;
	  }
	  
	  @Bean
	  public Map<String, Object> consumerConfigs() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, "moskalyan");
	    return props;
	  }

	  @Bean
	  public ProducerFactory<String,DownloadRequestDto> producerFactory() {
	    return new DefaultKafkaProducerFactory<>(producerConfigs());
	  }
	  
	  @Bean
	  public KafkaTemplate<String, DownloadRequestDto> kafkaTemplate() {
	    return new KafkaTemplate<>(producerFactory());
	  }
	  
	  @Bean
	  public ConsumerFactory<String, DownloadRequestDto> consumerFactory() {
	    return new DefaultKafkaConsumerFactory<>(
	    		consumerConfigs(),
				new StringDeserializer(),
				new JsonDeserializer<>(DownloadRequestDto.class));
	  }
	  
	  @Bean
	  public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, DownloadRequestDto>> kafkaListenerContainerFactory() {
	    ConcurrentKafkaListenerContainerFactory<String, DownloadRequestDto> factory
				= new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactory());
	    factory.setReplyTemplate(kafkaTemplate());
	    return factory;
	  }
	  
}

