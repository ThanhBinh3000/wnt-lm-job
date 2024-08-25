package vn.com.gsoft.consumer.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vn.com.gsoft.consumer.model.system.BaseRequest;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class GiaoDichHangHoaReq extends BaseRequest {
    private Boolean dongBang;
    private String maCoSo;
    private Integer nhomThuocId;
    private Integer nhomDuocLyId;
    private Integer nhomNganhHangId;
    private Integer thuocId;
    private Integer nhomHoatChatId;
    private Integer hangThayTheId;
    private Long[] thuocIds;
    private Integer loaiGiaoDich;
    private Date fromDate;
    private Date toDate;
}
