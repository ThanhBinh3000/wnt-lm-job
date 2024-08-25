package vn.com.gsoft.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import vn.com.gsoft.consumer.service.GiaoDichHangHoaService;

@SpringBootApplication
@EnableTransactionManagement
@EnableFeignClients
public class ConsumerApplication {
    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args
        );
    }

}
