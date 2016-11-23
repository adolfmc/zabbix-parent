package com.zabbix.sisyphus.crm.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.zabbix.sisyphus.base.repository.BaseRepository;
import com.zabbix.sisyphus.base.service.BaseService;
import com.zabbix.sisyphus.crm.entity.Attachment;
import com.zabbix.sisyphus.crm.repository.AttachmentDao;

/**
 * 作者: zabbix 创建于 16/10/18.
 */
@Service("attachmentService")
public class AttachmentService extends BaseService<Attachment> {

    @Autowired
    AttachmentDao attachmentDao;


    @Autowired
    public void setRepository(BaseRepository<Attachment> repository) {
        super.setRepository(repository);
    }

    public List<Attachment> find(Integer id) {
        List<Attachment> attachments = attachmentDao.findByCustomerId(id);
        List<Attachment> list = Lists.newArrayList();
        for (Attachment att : attachments) {
            Attachment newAtt = new Attachment();
            BeanUtils.copyProperties(att, newAtt);
            list.add(newAtt);
            newAtt.setFilePath(att.getSubFilePath());
            list.add(att);
        }
        return list;
    }

    public List<Attachment> findByIdAndType(Integer id, String type) {
        return attachmentDao.findByIdAndType(id,type);
    }
}
