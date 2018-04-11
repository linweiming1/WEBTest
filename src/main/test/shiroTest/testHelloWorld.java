package shiroTest;

import com.jolbox.bonecp.UsernamePassword;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;


import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SecurityManager.*;


import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class testHelloWorld {

    private static Logger logger = LoggerFactory.getLogger(testHelloWorld.class);

    @Test
    public void testHelloWorld() {
        Factory factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        SecurityManager securityManager = (SecurityManager) factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
            subject.login(token);


        } catch (AuthenticationException e) {
            logger.info("身份验证失败！");
        }
        Assert.assertEquals(true, subject.isAuthenticated());
        logger.info("身份认证成功！");
        subject.logout();

    }

    @Test
    public void testCustomRealm() {
        Factory factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        SecurityManager securityManager = (SecurityManager) factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
            subject.login(token);


        } catch (AuthenticationException e) {
            logger.info("身份验证失败！");
        }
        Assert.assertEquals(true, subject.isAuthenticated());
        logger.info("身份认证成功！");
        subject.logout();

    }

    @Test
    public void testJDBCRealm() {
        Factory factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");

        SecurityManager securityManager = (SecurityManager) factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
            subject.login(token);


        } catch (AuthenticationException e) {
            logger.info("身份验证失败！");
        }
        Assert.assertEquals(true, subject.isAuthenticated());
        logger.info("身份认证成功！");
        subject.logout();

    }


    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }
}
