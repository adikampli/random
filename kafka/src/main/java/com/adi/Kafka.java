package com.adi;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class Kafka {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        properties.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://127.0.0.1:8081");

        // Idempotent config
        properties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        properties.put(ProducerConfig.RETRIES_CONFIG, Integer.MAX_VALUE);
        properties.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 5);
        properties.put(ProducerConfig.ACKS_CONFIG, "all");

        //high throughput config
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 32 * 1024);
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 20);
        properties.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");

        KafkaProducer<String, Customer> producer = new KafkaProducer<>(properties);

        Customer customer = Customer.newBuilder()
                .setAge(10)
                .setFirstName("Adi")
                .setEmailSubscribed(false)
                .build();
        // shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            producer.flush();
            producer.close();
        }));

        String topic = "test_topic";
        ProducerRecord<String, Customer> record1 = new ProducerRecord<>(topic, customer);
        producer.send(record1, ((recordMetadata, e) -> System.out.println(recordMetadata.partition())));

        Properties consumerProperties = new Properties();
        consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        consumerProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "test-app");
        consumerProperties.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://127.0.0.1:8081");
//        consumerProperties.put("specific.avro.reader", "true");

        KafkaConsumer<String, Customer> consumer = new KafkaConsumer<>(consumerProperties);
 /*       TopicPartition topicPartition = new TopicPartition(topic, 0);
        consumer.assign(Collections.singletonList(topicPartition));
        consumer.seek(topicPartition, 2L);
        logger.info("Value: " + record.value() + "\n"
                + "Key: " + record.key() + "\n"
                + "Topic: " + record.topic() + "\n"
                + "Partition: " + record.partition() + "\n"
                + "Offset: " + record.offset());*/
        consumer.subscribe(Collections.singletonList(topic));
        while (true) {
            ConsumerRecords<String, Customer> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, Customer> record : records) {
                System.out.println("Value: " + record.value() + "\n"
                        + "Key: " + record.key() + "\n"
                        + "Topic: " + record.topic() + "\n"
                        + "Partition: " + record.partition() + "\n"
                        + "Offset: " + record.offset());
            }
        }


    }
}
