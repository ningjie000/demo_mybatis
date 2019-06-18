package com.example.mybatis_sd.util;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author: NJ
 * @Description:
 * @Date: 2019/5/17
 */
public class SSHHelper {

    /**
     * 远程 执行命令并返回结果调用过程 是同步的（执行完才会返回）
     * @param host  主机名
     * @param user  用户名
     * @param psw   密码
     * @param port  端口
     * @param command   命令
     * @return
     */
    public static String exec(String host,String user,String psw,int port,String command){
        String result="";
        Session session =null;
        ChannelExec openChannel =null;
        try {
            JSch jsch=new JSch();
            session = jsch.getSession(user, host, port);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setPassword(psw);
            session.connect();
            openChannel = (ChannelExec) session.openChannel("exec");
            openChannel.setCommand(command);
            int exitStatus = openChannel.getExitStatus();
            System.out.println(exitStatus);
            openChannel.connect();
            InputStream in = openChannel.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String buf = null;
            while ((buf = reader.readLine()) != null) {
                result+= new String(buf.getBytes("gbk"),"UTF-8")+"    <br>\r\n";
            }
        } catch (Exception e) {
            result+=e.getMessage();
        }finally{
            if(openChannel!=null&&!openChannel.isClosed()){
                openChannel.disconnect();
            }
            if(session!=null&&session.isConnected()){
                session.disconnect();
            }
        }
        return result;
    }

    /**
     * 连接Linux主机
     * @param userName
     * @param passwd
     * @param host
     * @param port
     * @return
     */
    public static Session connectionHost(String userName, String passwd, String host, int port) throws Exception{
        JSch jsch = new JSch();
        Session session = null;
        try {
            if(port==0){
                session = jsch.getSession(userName, host, 22);
            }else{
                session = jsch.getSession(userName, host, port);
            }

            session.setPassword(passwd);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
        } catch (JSchException e) {
            e.printStackTrace();
            session =null;
            System.out.println("connect error !");
        }
        return session;

    }

}
