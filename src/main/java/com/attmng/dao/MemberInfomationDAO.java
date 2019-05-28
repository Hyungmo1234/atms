package com.attmng.dao;

import java.util.List;

public interface MemberInfomationDAO {
	public List getMembersInfo() throws Exception;
	public List getMemberInfo(String name) throws Exception;
}
