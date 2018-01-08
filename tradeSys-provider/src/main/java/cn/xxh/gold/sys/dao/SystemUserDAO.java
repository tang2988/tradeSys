package cn.xxh.gold.sys.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.sys.entity.SystemUser;

/**
 * 功能：用户信息类
 *
 * @version 2016年12月26日下午3:01:59
 * @author baocheng.ren
 */
@Repository
public interface SystemUserDAO   {
    
    
    /**
     * 功能:查询列表数据数量
     *
     * @version 2016年12月26日下午7:16:44
     * @author baocheng.ren
     * @param page 分页类
     * @return int
     */
    int findUserListCount(Page page);
    
    /**
     * 功能:查询列表数据集合
     *
     * @version 2016年12月26日下午7:16:44
     * @author baocheng.ren
     * @param page 分页类
     * @return List<Object>
     */
    List<SystemUser> findUserList(Page page);
    
    /**
     * 功能：设置用户状态
     *
     * @version 2016年12月27日下午2:39:59
     * @author baocheng.ren
     * @param status 登录状态
     * @param ids 主键
     * @return int
     */
    int updateStatusById(@Param("status") String status, @Param("ids") String[] ids);
    
    /**
     * 功能：查询登录用户名是否存在
     *
     * @version 2016年12月28日下午4:01:34
     * @author baocheng.ren
     * @param loginName 登录名
     * @param userId 用户id
     * @return SystemUser
     */
    SystemUser getSystemUserByLoginName(@Param("loginName") String loginName, @Param("userId") String userId);
    
    /**
     * 功能：修改密码
     *
     * @version 2016年12月29日上午9:27:42
     * @author baocheng.ren
     * @param id 主键
     * @param password 加密密码
     * @return int
     */
    int updatePassword(@Param("id") String id, @Param("password") String password);
    
    /**
     * 功能：查询原密码是否正确
     *
     * @version 2016年12月29日上午9:47:59
     * @author baocheng.ren
     * @param id 主键
     * @param password 原密码
     * @return String id
     */
    String getUserByPassword(@Param("id") String id, @Param("password") String password);
    
    /**
     * 功能：关联平台账户
     * 
     * @version 2017-7-11上午11:32:20
     * @author jian.xiao
     * @param id
     * @param customerId
     * @return
     */
    int updateRelation(@Param("id") String id, @Param("customerId") String customerId);
    
    /**
     * 功能：插入新对象
     *
     * @version 2016年12月28日下午8:53:19
     * @author baocheng.ren
     * @param o 对象
     * @return int
     */
    int insert(SystemUser o);
    
    /**
     * 功能：删除一个或多个对象
     *
     * @version 2016年12月28日下午8:53:35
     * @author baocheng.ren
     * @param o 对象
     * @return int
     */
    int delete(SystemUser o);
    
    /**
     * 功能：根据对象id删除单一对象
     *
     * @version 2016年12月28日下午8:53:53
     * @author baocheng.ren
     * @param id 主键
     * @return int
     */
    int deleteById(Serializable id);
    
    /**
     * 功能：更新修改的对象
     *
     * @version 2016年12月28日下午8:54:03
     * @author baocheng.ren
     * @param o 对象
     * @return int
     */
    int update(SystemUser o);
    
    /**
     * 功能：根据对象id获取单一对象
     *
     * @version 2016年12月28日下午8:54:14
     * @author baocheng.ren
     * @param id 主键
     * @return T
     */
    SystemUser findById(Serializable id);
}
