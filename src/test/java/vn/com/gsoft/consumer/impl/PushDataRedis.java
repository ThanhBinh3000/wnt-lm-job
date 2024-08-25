package vn.com.gsoft.consumer.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.com.gsoft.consumer.constant.ENoteType;
import vn.com.gsoft.consumer.model.dto.GiaoDichHangHoaRes;
import vn.com.gsoft.consumer.service.GiaoDichHangHoaService;
import vn.com.gsoft.consumer.service.RedisListService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Slf4j
class PushDataRedis {
    @Autowired
    private GiaoDichHangHoaService giaoDichHangHoaService;
    @Test
    void archiveData() throws Exception {
       giaoDichHangHoaService.archiveData();
    }
}