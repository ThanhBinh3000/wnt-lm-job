package vn.com.gsoft.consumer.service.impl;


import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.consumer.constant.ENoteType;
import vn.com.gsoft.consumer.entity.GiaoDichHangHoa;
import vn.com.gsoft.consumer.entity.HangHoa;
import vn.com.gsoft.consumer.entity.HangHoaRepository;
import vn.com.gsoft.consumer.model.dto.GiaoDichHangHoaReq;
import vn.com.gsoft.consumer.model.dto.GiaoDichHangHoaRes;
import vn.com.gsoft.consumer.model.dto.WrapData;
import vn.com.gsoft.consumer.repository.GiaoDichHangHoaRepository;
import vn.com.gsoft.consumer.service.GiaoDichHangHoaService;
import vn.com.gsoft.consumer.service.RedisListService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Log4j2
public class GiaoDichHangHoaServiceImpl implements GiaoDichHangHoaService {
    @Autowired
    private GiaoDichHangHoaRepository giaoDichHangHoaRepository;
    @Autowired
    private HangHoaRepository hoaRepository;

    @Autowired
    RedisListService redisListService;
    @Override
    public void archiveData() {
        Calendar dateArchive = Calendar.getInstance();
        dateArchive.add(Calendar.YEAR, -1);

        //lấy ra dữ liệu dươí 1 năm chưa archive
        GiaoDichHangHoaReq req = new GiaoDichHangHoaReq();
        req.setToDate(dateArchive.getTime());
        req.setDongBang(false);
        var items = giaoDichHangHoaRepository.searchList(req);
        if(!items.isEmpty()){
            //xoá giao dịch cũ redis đi
            redisListService.deleteTransactions(items);
            //archive trong db
            items.forEach(x->{
                x.setDongBang(true);
            });
            giaoDichHangHoaRepository.saveAll(items);
        }

    }
}
