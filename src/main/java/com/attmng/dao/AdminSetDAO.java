package com.attmng.dao;
import java.util.List;

import org.springframework.stereotype.Service;

import com.attmng.domain.AdminSetVO;

@Service
public interface AdminSetDAO {
	public List<AdminSetVO> AdminList() throws Exception;
}