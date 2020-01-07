package Lessons.Lesson3.Task4;


import Lessons.Lesson3.Task4.Object.Student;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Serv {

    public Serv() {
        Socket socket = null;
        ArrayList<Byte> arrayList = new ArrayList<>();


        try(ServerSocket server = new ServerSocket(8081)) {
            System.out.println("Сервер запущен");
            socket = server.accept();
            System.out.println("клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            int x;
            while ((x = in.readInt()) != 300){
                arrayList.add((byte) x);
            }
            byte[] stud = new byte[arrayList.size()];
            for (int i = 0; i < arrayList.size() ; i++) {
                stud[i] = arrayList.get(i);
            }

            try (ByteArrayInputStream barrIn = new ByteArrayInputStream(stud);
                 ObjectInputStream objIn = new ObjectInputStream(barrIn)) {
                Student stud1 = (Student) objIn.readObject();
//                System.out.println("А вот такого кота мы восстановили из набора байтов: " + stud1);
                stud1.info();
            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (IOException  e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
