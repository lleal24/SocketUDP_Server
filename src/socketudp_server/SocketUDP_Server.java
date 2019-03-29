/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketudp_server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class SocketUDP_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Objeto tipo datagramSOcket donde se define el puerto que va a utilizar como destino 
            DatagramSocket miSocket = new DatagramSocket(9107);
            System.out.print("Servidor iniciado\n");
            //Creacion de buffer con cantidad maxima de memoria
            byte [] buffer = new byte[1024];
            
            //Ciclo infinito que mantiene la conexion abierta del server
            //esperando a la peticion del cliente
            while(true){
                //Paquete que recibe peticion de cliete
                //solicita como parametro buffer y la dimencion del buffer
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                //el socket recibe peticion en base a datagramaPacket
                miSocket.receive(peticion);
                
                
                //impresion del mensaje
                System.out.println("IP: " + peticion.getAddress());
                System.out.println("Puerto: " + peticion.getPort());
                //La data llega en formato byte es necesario convertila a String
                System.out.println("Mensaje: " + new String(peticion.getData(),0,peticion.getLength()));
                
            }
            
        } catch (SocketException ex) {
            Logger.getLogger(SocketUDP_Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SocketUDP_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
