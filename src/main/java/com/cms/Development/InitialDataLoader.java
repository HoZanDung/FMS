package com.cms.Development;

import com.cms.entity.*;
import com.cms.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HOZANDUNG on 17/5/24.
 */
@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    //
    boolean alreadySetup = false;
    @Autowired
    SysUserRepository userRepository;
    @Autowired
    SysRoleRepository roleRepository;
    @Autowired
    SysDrugRepository drugRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    StorageMainRepository storageMainRepository;
    @Autowired
    StorageDetailRepository storageDetailRepository;


    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (alreadySetup) return;


        //Create Role
        SysRole sysRole_admin = new SysRole();
        sysRole_admin.setName("ROLE_ADMIN");
        sysRole_admin.setCreate_ip("0:0:0:0:0:0:0:1");
        sysRole_admin.setUpdate_ip("0:0:0:0:0:0:0:1");
        sysRole_admin.setCreate_time(new Date());
        sysRole_admin.setUpdate_time(new Date());
        sysRole_admin.setDescription("管理员");
        roleRepository.save(sysRole_admin);

        SysRole sysRole_user = new SysRole();
        sysRole_user.setName("ROLE_USER");
        sysRole_user.setCreate_ip("0:0:0:0:0:0:0:1");
        sysRole_user.setUpdate_ip("0:0:0:0:0:0:0:1");
        sysRole_user.setCreate_time(new Date());
        sysRole_user.setUpdate_time(new Date());
        sysRole_user.setDescription("用户");
        roleRepository.save(sysRole_user);


        //Create User
        SysUser sysUser_admin = new SysUser();
        SysRole role_admin = roleRepository.findOne(1L);
        List<SysRole> sysRoles_admin = new LinkedList<>();
        sysRoles_admin.add(role_admin);
        sysUser_admin.setUsername("root");
        sysUser_admin.setPassword("root");
        sysUser_admin.setCreate_ip("0:0:0:0:0:0:0:1");
        sysUser_admin.setUpdate_ip("0:0:0:0:0:0:0:1");
        sysUser_admin.setCreate_time(new Date());
        sysUser_admin.setUpdate_time(new Date());
        sysUser_admin.setEmail("root@qq.com");
        sysUser_admin.setAddress("大学城校区3栋610");
        sysUser_admin.setPhone("13048034431");
        sysUser_admin.setRealname("何震东");
        sysUser_admin.setRoles(sysRoles_admin);
        userRepository.save(sysUser_admin);

        SysUser sysUser_user = new SysUser();
        SysRole role_user = roleRepository.findOne(2L);
        List<SysRole> sysRoles_user = new LinkedList<>();
        sysRoles_user.add(role_user);
        sysUser_user.setUsername("dong");
        sysUser_user.setPassword("dong");
        sysUser_user.setCreate_ip("0:0:0:0:0:0:0:1");
        sysUser_user.setUpdate_ip("0:0:0:0:0:0:0:1");
        sysUser_user.setCreate_time(new Date());
        sysUser_user.setUpdate_time(new Date());
        sysUser_user.setEmail("dong@qq.com");
        sysUser_user.setAddress("大学城校区3栋610");
        sysUser_user.setPhone("13048034432");
        sysUser_user.setRealname("何震东");
        sysUser_user.setRoles(sysRoles_user);
        userRepository.save(sysUser_user);

        SysUser sysUser = userRepository.findOne(1L);

        //Create drug
        for (int i = 2; i <= 12; i++) {
            String j = Integer.toString(i);
            SysDrug sysDrug = new SysDrug();
            sysDrug.setCreate_ip("0:0:0:0:0:0:0:1");
            sysDrug.setUpdate_ip("0:0:0:0:0:0:0:1");
            sysDrug.setCreate_time(new Date());
            sysDrug.setUpdate_time(new Date());
            sysDrug.setCreate_by(sysUser);
            sysDrug.setUpdate_by(sysUser);
            sysDrug.setName("药品" + j);
            sysDrug.setType("类型" + j);
            sysDrug.setIntroduce("介绍" + j);
            sysDrug.setDrugbar("药品条形" + j);
            sysDrug.setGenericName("药品通用名字" + j);
            sysDrug.setPinyinCode("药品拼音码" + j);
            sysDrug.setRetailPrice(Integer.toString(i));
            sysDrug.setReplenishPrice(Integer.toString(i - 1));
            sysDrug.setUnit("药品单位" + j);
            sysDrug.setDosage("药品剂量" + j);
            sysDrug.setOrigin("药品产地" + j);
            sysDrug.setValidity("药品时效性" + j);
            sysDrug.setQualityStandard("药品质量标准" + j);
            sysDrug.setOperation("药品经营方式" + j);
            sysDrug.setBatchNumber("药品批号" + j);
            drugRepository.save(sysDrug);
        }

        //Create supplier
        for (int i = 2; i <= 10; i++) {
            String j = Integer.toString(i);
            Supplier supplier = new Supplier();
            supplier.setCreate_ip("0:0:0:0:0:0:0:1");
            supplier.setUpdate_ip("0:0:0:0:0:0:0:1");
            supplier.setCreate_time(new Date());
            supplier.setUpdate_time(new Date());
            supplier.setCreate_by(sysUser);
            supplier.setUpdate_by(sysUser);
            supplier.setName("供应商" + j);
            supplier.setPinyinCode("供应商拼音码" + j);
            supplier.setAddress("供应商地址" + j);
            supplier.setArea("供应商地区" + j);
            supplier.setZipCode("邮政编码" + j);
            supplier.setPhone("1304803443" + j);
            supplier.setContactPerson("联系人" + j);
            supplier.setBank("银行" + j);
            supplier.setBankAccount("银行账户" + j);
            supplierRepository.save(supplier);
        }

        //Create storageMain
        for (int i = 2; i <= 10; i++) {
            String j = Integer.toString(i);
            StorageMain storageMain = new StorageMain();
            storageMain.setCreate_ip("0:0:0:0:0:0:0:1");
            storageMain.setUpdate_ip("0:0:0:0:0:0:0:1");
            storageMain.setCreate_time(new Date());
            storageMain.setUpdate_time(new Date());
            storageMain.setCreate_by(sysUser);
            storageMain.setUpdate_by(sysUser);
            storageMain.setSpeciesAmount(j + "￥");
            storageMain.setStorageAmount(j);
            storageMain.setStorageAllPrice(j);
            storageMain.setStorageDate("2018-04-" + j);
            storageMain.setStorageStatus("1");
            storageMain.setTransactor("经手人" + j);
            storageMain.setSupplierNo(j);
            storageMainRepository.save(storageMain);
        }

        //Create storageDetail
        for (int i = 2; i <= 10; i++) {
            String j = Integer.toString(i);
            StorageDetail storageDetail = new StorageDetail();
            storageDetail.setCreate_ip("0:0:0:0:0:0:0:1");
            storageDetail.setUpdate_ip("0:0:0:0:0:0:0:1");
            storageDetail.setCreate_time(new Date());
            storageDetail.setUpdate_time(new Date());
            storageDetail.setCreate_by(sysUser);
            storageDetail.setUpdate_by(sysUser);
            storageDetail.setDocumentNo(j + "￥");
            storageDetail.setDrugNumber(j);
            storageDetail.setStorageAmount(j);
            storageDetail.setStorageUnitPrice(j);
            storageDetail.setStorageAllPrice(j);
            storageDetail.setStorageDate("2018-04-" + j);
            storageDetail.setStorageAmounting(j);
            storageDetail.setStorageStatus("1");
            storageDetailRepository.save(storageDetail);
        }


        alreadySetup = true;
    }
}
