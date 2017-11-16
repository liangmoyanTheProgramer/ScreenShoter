package com.mystudio.moshui.screenshoter.net;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Created by lianghuiyu on 2017/11/5.
 */



public class SocketManager {

    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));




    public SocketManager() throws IOException{
        this.serverSocket = new ServerSocket(1234);

        this.socket = serverSocket.accept();




    }

    public void connect(int port){}

    public boolean transferFile(File origin, File destination){
        return true;
    }

    public Socket getSocket() {
        return socket;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }


}
