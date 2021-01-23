package com.company;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam M. Gamboa G
 */
public class SocketClient {

    private static final Logger LOGGER = Logger.getLogger(SocketClient.class.getName());

    private Socket client;
    private BufferedReader input;
    private BufferedWriter output;

    private static final int TIMEOUT_IN_MS = 30 * 1000;   // 1 segundo;

    public SocketClient(String host, int port) {
        this.create(host, port);
    }

    private void create(String host, int port) {
        // create a socket with a timeout
        try {
            SocketAddress socketAddress = new InetSocketAddress(host, port);
            // create a socket
            this.client = new Socket();

            // this method will block no more than timeout ms.
            this.client.connect(socketAddress, TIMEOUT_IN_MS);
            this.client.setSoTimeout(TIMEOUT_IN_MS);
            this.client.setTcpNoDelay(true);
            this.client.setKeepAlive(true);

            this.input = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
            this.output = new BufferedWriter(new OutputStreamWriter(this.client.getOutputStream()));
            this.output.flush();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            throw new RuntimeException();
        }
    }

    public byte[] execute(byte[] message) {
        try{
            //Sends the message
            this.output.write(new String(message));
            this.output.newLine();
            this.output.flush();

            //Gets the response. Because the server doesn´t close the
            //connection (if it´s closed by the server, the pool doesnt make sense)
            //Server used to send a new line character to finish the message.
            //that´s why we are reading a line.
            String line = input.readLine();
            return line.getBytes();
        }catch(IOException ioex){
            LOGGER.log(Level.SEVERE, ioex.getMessage(), ioex);
            throw new RuntimeException();
        }
    }

    public void close() {
        if (this.client != null) {
            try {
                this.client.close();
            } catch (IOException ioex) {
                LOGGER.log(Level.WARNING, "The socket client couldnt be close", ioex);
            } finally {
                this.client = null;
            }
        }
    }

    public boolean isValid() {
        if (this.client != null) {
            return this.client.isClosed();
        }
        return false;
    }

    public void activate() {
        LOGGER.log(Level.FINE, "... Activating socket ...");
    }

    public void desactivate() {
        LOGGER.log(Level.FINE, "... Desactivating socket ...");
    }

}