package com.zabbix.sisyphus.crm.repository;

import com.zabbix.sisyphus.base.repository.BaseRepository;
import com.zabbix.sisyphus.crm.entity.Attachment;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 作者: zabbix 创建于 16/10/19.
 */
public interface AttachmentDao extends BaseRepository<Attachment> {
    List<Attachment> findByCustomerId(Integer id);



    @Query(value ="select ac.* from ft_t_tender_plan tp \n" +
            "inner join ft_t_tender_plan_credit tpc on tp.id = tpc.tender_plan_id \n" +
            "inner join cd_t_credit_info ci on ci.id = tpc.credit_id \n" +
            "inner join crm_t_attachment ac on ci.customer_id = ac.customer_id \n" +
            "where tp.old_licai_pro_id =?1 and ac.type=?2", nativeQuery = true)
    List<Attachment> findAttachmentByPid(Integer pid ,String type);

    void deleteByCustomerId(Integer id);

    List<Attachment> findByIdAndType(Integer id, String type);
}
